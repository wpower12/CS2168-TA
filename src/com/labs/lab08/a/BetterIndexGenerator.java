package com.labs.lab08.a;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class BetterIndexGenerator {

    // A Map that associates Strings (words) with Lists of Integers
    private Map<String, List<Integer>> wordToListMap;

    // Constructor
    public BetterIndexGenerator() { wordToListMap = new HashMap<>(); }

    // Getter method. Returns the wordToListMap.
    public Map<String, List<Integer>> getWordToListMap() { return wordToListMap; }

    // Reads each word in data file and stores it in a Map
    // along with an ArrayList of line numbers (a value).
    public void buildIndex(Scanner scanner) {
        int lineNum = 0; // Line number
        StringTokenizer st;
        String word;
        // Keep reading lines until done.
        while (scanner.hasNextLine()) {
            lineNum++;
            st = new StringTokenizer(scanner.nextLine());
            while (st.hasMoreTokens()) {
                word = st.nextToken();
                List<Integer> lines;
                lines = wordToListMap.getOrDefault(word, new ArrayList<>());
                // uncomment the next line to only keep unique entries in the list (could have used a Set for this)
                // if (!lines.contains(lineNum))
                lines.add(lineNum);
                wordToListMap.put(word, lines);  //Store new list

            }
        }

    }

    // display the wordToListMap
    public void showIndex() {
        for (String word : wordToListMap.keySet()) {
            System.out.println(String.format("%-17s %s", word, wordToListMap.get(word)));
            //System.out.println(String.format("%-17s %s (# of times: %1s)", word, wordToListMap.get(word), wordToListMap.get(word).size() ));
        }
    }

    // display frequencies of word occurrences
    public void showWordFrequency() {
        for (String word : wordToListMap.keySet()) {
            System.out.println(String.format("%-17s %s ", word, wordToListMap.get(word).size() ));
        }
    }

    // Sorts the Map by Key
    public void sortByKey()
    {
        ArrayList<String> sortedKeys =
                new ArrayList<String>(wordToListMap.keySet());

        Collections.sort(sortedKeys);

        // Display the TreeMap sorted by key
        for (String word : sortedKeys)
            System.out.println(word + "  " + wordToListMap.get(word));
    }

    public static void main(String[] args) throws FileNotFoundException {

        // Scanner scan = new Scanner(new FileInputStream("tinyTale.txt"));
        Scanner scan = new Scanner(new FileInputStream("inputs/tale.txt"));
        BetterIndexGenerator index = new BetterIndexGenerator(); // a BetterIndexGenerator instance
        index.buildIndex(scan);                                  // build the mapping from words to line numbers
        index.showIndex();                                       // display the mapping

        System.out.println();
        index.showWordFrequency();

        index.sortByKey();

        // determine which lines contain the word temple
        String word = "fragment";
        if (index.getWordToListMap().get(word) != null)
            System.out.printf("\nThe word %s appears on these lines: %s\n", word, index.getWordToListMap().get(word));
        else
            System.out.printf("\nThe word %s does not appear in this document", word);
    }
}
