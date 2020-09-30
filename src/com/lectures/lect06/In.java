package com.lectures.lect06;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

// In is a helper class written for CIS-2168 Labs. Its purpose is to help read
// a text file. The file can be remote (accessed through an URL) or local.
// Each line of the input file is assumed to be a single entry that needs to be
// interpreted as an integer. For example, the file contents might be:  23
//                                                                      85
//                                                                      121689
//
// Method readAllInts() returns the contents of the file as an array of ints.
// The main() method shows an example of using the In class.
// You do not need to modify this file.
public final class In {
   private Scanner scanner;

   // Constructor. Initializes an input stream from a filename (local or URL).
   public In(String name) {
      if (name == null) throw new IllegalArgumentException("please tell me which file to open. exiting for now...");
      try {
         // first try to read file from local file system
         File file = new File(name);
         if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis));
            return;
         }

         // resource on the web
         URL url = new URL(name);
         URLConnection site = url.openConnection();
         InputStream is     = site.getInputStream();
         scanner            = new Scanner(new BufferedInputStream(is));
      }
      catch (IOException ioe) {
         throw new IllegalArgumentException("Could not open " + name, ioe);
      }
   }

   // Reads all lines from this input stream and returns them as
   // an array of strings.
   public String[] readAllLines() {
      ArrayList<String> lines = new ArrayList<String>();
      while (scanner.hasNextLine()) {
         lines.add(scanner.nextLine());
      }
      return lines.toArray(new String[lines.size()]);
   }

   // Reads all lines from this input stream, parses them as integers,
   // and returns them as an array of integers.
   public int[] readAllInts() {
      String[] fields = readAllLines();
      int[] vals = new int[fields.length];
      for (int i = 0; i < fields.length; i++)
         vals[i] = Integer.parseInt(fields[i].trim());
      return vals;
   }

   /**
    * Reads all remaining tokens from this input stream and returns them as
    * an array of strings.
    *
    * @return all remaining tokens in this input stream, as an array of strings
    */
   public String[] readAllStrings() {
      // we could use readAll.trim().split(), but that's not consistent
      // since trim() uses characters 0x00..0x20 as whitespace
      String[] tokens = Pattern.compile("\\p{javaWhitespace}+").split(readAll());
      if (tokens.length == 0 || tokens[0].length() > 0)
         return tokens;
      String[] decapitokens = new String[tokens.length-1];
      for (int i = 0; i < tokens.length-1; i++)
         decapitokens[i] = tokens[i+1];
      return decapitokens;
   }

   public String readAll() {
      if (!scanner.hasNextLine())
         return "";

      String result = scanner.useDelimiter(Pattern.compile("\\A")).next();
      // not that important to reset delimeter, since now scanner is empty
      scanner.useDelimiter(Pattern.compile("\\p{javaWhitespace}+")); // but let's do it anyway
      return result;
   }

   // Reads the next token from this input stream and returns it as a {@code String}.
   public String readString() {
      try {
         return scanner.next();
      }
      catch (NoSuchElementException e) {
         throw new NoSuchElementException("attempts to read a 'String' value from the input stream, "
               + "but no more tokens are available");
      }
   }

   // Returns true if input stream is empty (except possibly whitespace).
   public boolean isEmpty() { return !scanner.hasNext(); }

   // main() tests the In data type
   public static void main(String[] args) {
      // initialize In with tinyT.txt data file (stored on the web)
      In in = new In("https://gist.githubusercontent.com/david-dobor/b4817f435bb4cc58adefc8f101f44efa/raw/d43fee7207dbac6fd70a1a111dd4992ffbd318ec/tinyT.txt");
      int[] a = in.readAllInts();
      System.out.println("Integers in tinyT.txt: " + Arrays.toString(a));

      // You can also read tinyW.txt from your local directory as follows:
      // in = new In("tinyW.txt");
      // a = in.readAllInts();

      // You can read large data files without downloading them to your local machine.
      // For example, read 1 million integers from this URL
      in = new In("https://gist.githubusercontent.com/david-dobor/a97af6e62ddd2a3af6104989721553d5/raw/fea635101c2d19ee9f219503555e6371c1ca4b2c/largeW.txt");
      a = in.readAllInts();

      //the following line prints the integers in largeW.txt:
      System.out.println(Arrays.toString(a));
   }
}
