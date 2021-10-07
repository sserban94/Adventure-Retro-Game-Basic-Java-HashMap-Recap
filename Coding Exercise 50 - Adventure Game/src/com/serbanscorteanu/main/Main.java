package com.serbanscorteanu.main;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

import com.serbanscorteanu.classes.Location;

public class Main {
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	private static Map<String, String> vocabulary = new HashMap<String, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner scanner = new Scanner(System.in);

		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
		locations.put(4, new Location(4, "You are in a valley beside a stream"));
		locations.put(5, new Location(5, "You are in the forest"));

		// EXITS
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);
		// locations.get(1).addExit("Q", 0);

		locations.get(2).addExit("N", 5);
		// locations.get(2).addExit("Q", 0);

		locations.get(3).addExit("W", 1);
		// locations.get(3).addExit("Q", 0);

		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);
		// locations.get(4).addExit("Q", 0);

		locations.get(5).addExit("S", 1);
		locations.get(5).addExit("W", 2);
		// locations.get(5).addExit("Q", 0);

		// ..............................
		// add words in vocabulary
		vocabulary.put("NORTH", "N");
		vocabulary.put("SOUTH", "S");
		vocabulary.put("WEST", "W");
		vocabulary.put("EAST", "E");
		vocabulary.put("QUIT", "Q");

		command();
	}

	// 1st way - with return
//	public static String command() {
//		// get input from user
//		Scanner scanner = new Scanner(System.in);
//		// convert whole sentence to upper case and store it
//		String sentence = scanner.nextLine().toUpperCase();
//		// split the sentence in words
//		String[] words = sentence.split(" ");
//		// check if any of the words in in the vocabulary
//		for (String word : words) {
//			if (vocabulary.containsKey(word)){
//				// if yes - return the value (N,S,W,E)
//				return vocabulary.get(word);
//			}
//		}
//		return "";
//	}

	public static void command() {
		Scanner scanner = new Scanner(System.in);
		int loc = 1;
		while (true) {
			System.out.println(locations.get(loc).getDescription());
			if (loc == 0) {
				break;
			}

			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.print("Available exits are ");
			for (String key : exits.keySet()) {
				System.out.print(key + ", ");
			}
			System.out.println();
			// get input from user

			// convert whole sentence to upper case and store it
			String sentence = scanner.nextLine().toUpperCase();
			// split the sentence in words
			// String[] delimiters = {' ', '.', ','};
			String[] words = sentence.split(" |\\.");
			// variable to store the value of the direction
			String direction = "";
			// check if any of the words in in the vocabulary
			for (String word : words) {
				if (vocabulary.containsKey(word)) {
					// if yes - return the value (N,S,W,E)
					// return vocabulary.get(word);
					direction = vocabulary.get(word);
					break;
				} else if (vocabulary.containsValue(word)) { // this could be easier. just check if
					direction = word; // direction > 1 letter
					break;
				}
			}
			if (exits.containsKey(direction)) {
				loc = exits.get(direction); // get the int for that direction
			} else {
				System.out.println("You cannot go in that direction");
			}
		}
		scanner.close();
	}
}
