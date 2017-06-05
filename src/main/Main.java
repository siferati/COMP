package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


  public static ArrayList<Match> matchedNodes = new ArrayList<Match>();
  public static boolean starting = true;

  public static void main(String args[]){

    try {

      if (args.length != 1) {
        System.out.println("sytnax: Main <FILE>");
      }
      else {
        // open file as input stream
        InputStream ss = new FileInputStream(args[0]);
        // create parser with file as input stream
        Parser parser = new Parser(ss);
        // get AST root
        SimpleNode root = parser.start();
        // display AST
        //root.dump("");

        // call gson
        GsonTest gsonTest = new GsonTest();

        root.findPattern(gsonTest);

        displayPatternsFound();

      }
    }
    catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }

  public static void displayPatternsFound() {

    for (int i = 0; i < matchedNodes.size(); i++) {

      Match match = matchedNodes.get(i);

      if (match.pattern.equals(match.content)) {

        matchedNodes.remove(match);
        i--;
      }
    }

    boolean found = true;

    for (int i = 0; i < matchedNodes.size(); i++) {

      Match match = matchedNodes.get(i);

      if (!match.pattern.contains("@")) {
        found = false;
        break;
      }

      for (int j = i + 1; j < matchedNodes.size(); j++) {

        Match match2 = matchedNodes.get(j);

        if (match.pattern.equals(match2.pattern) &&
            !match.content.equals(match2.content)) {
          found = false;
          break;
        }
      }

      if (!found) {
        break;
      }
    }

    if (found) {
      System.out.println("Pattern found on line " + matchedNodes.get(0).location);
    } else {
      System.out.println("Pattern not found!");
    }
  }
}
