package lab4;

import java.util.Scanner;

public class MorseCode {

	private BinTree<Character> decodingTree;
	private String[] encodingArray = new String[26];

	public MorseCode() {

		// Constructing encoding array with 26 variables for each letter and its Morse
		// equivalent
		encodingArray[0] = ".-";
		encodingArray[1] = "-...";
		encodingArray[2] = "-.-.";
		encodingArray[3] = "-..";
		encodingArray[4] = ".";
		encodingArray[5] = "..-.";
		encodingArray[6] = "--.";
		encodingArray[7] = "....";
		encodingArray[8] = "..";
		encodingArray[9] = ".---";
		encodingArray[10] = "-.-";
		encodingArray[11] = ".-..";
		encodingArray[12] = "--";
		encodingArray[13] = "-.";
		encodingArray[14] = "---";
		encodingArray[15] = ".--.";
		encodingArray[16] = "--.-";
		encodingArray[17] = ".-.";
		encodingArray[18] = "...";
		encodingArray[19] = "-";
		encodingArray[20] = "..-";
		encodingArray[21] = "...-";
		encodingArray[22] = ".--";
		encodingArray[23] = "-..-";
		encodingArray[24] = "-.--";
		encodingArray[25] = "--..";

		// Constructing the decoding tree starting with the bottom level, going to the
		// top
		BinTree<Character> h = new BinTree<>('H');
		BinTree<Character> v = new BinTree<>('V');
		BinTree<Character> f = new BinTree<>('F');
		BinTree<Character> l = new BinTree<>('L');
		BinTree<Character> p = new BinTree<>('P');
		BinTree<Character> j = new BinTree<>('J');
		BinTree<Character> b = new BinTree<>('B');
		BinTree<Character> x = new BinTree<>('X');
		BinTree<Character> c = new BinTree<>('C');
		BinTree<Character> y = new BinTree<>('Y');
		BinTree<Character> z = new BinTree<>('Z');
		BinTree<Character> q = new BinTree<>('Q');
		BinTree<Character> s = new BinTree<>('S', h, v);
		BinTree<Character> u = new BinTree<>('U', f, null);
		BinTree<Character> r = new BinTree<>('R', l, null);
		BinTree<Character> w = new BinTree<>('W', p, j);
		BinTree<Character> d = new BinTree<>('D', b, x);
		BinTree<Character> k = new BinTree<>('K', c, y);
		BinTree<Character> g = new BinTree<>('G', z, q);
		BinTree<Character> o = new BinTree<>('O');
		BinTree<Character> i = new BinTree<>('I', s, u);
		BinTree<Character> a = new BinTree<>('A', r, w);
		BinTree<Character> n = new BinTree<>('N', d, k);
		BinTree<Character> m = new BinTree<>('M', g, o);
		BinTree<Character> e = new BinTree<>('E', i, a);
		BinTree<Character> t = new BinTree<>('T', n, m);
		decodingTree = new BinTree<>(null, e, t);

	}

	// Encodes the text into Morse Code. Subtracts the characters by 65 to get
	// values from 0-25 to print from the encoding array.
	public String encode(String message) {
		char[] tempArray = message.toCharArray();
		String returnString = "";

		for (int i = 0; i < tempArray.length; i++) {
			int sub = tempArray[i] - 65;

			if (sub <= 25 && sub >= 0) {
				returnString = returnString + encodingArray[sub] + " ";
			} else if (tempArray[i] == ' ') {
				returnString = returnString + "#";
			}

		}

		return returnString;
	}

	// Decodes the Morse Code into text. Turns the code into a character array, and
	// goes through each index, of the array, going down the tree accordingly until
	// a space or # is found, printing out either the info from the current node in
	// the tree, or printing a space.
	public String decode(String code) {

		String returnString = "";
		char[] tempArray = code.toCharArray();
		BinTree<Character> tempTree = decodingTree;

		for (int i = 0; i < tempArray.length; i++) {

			if (tempArray[i] == '-') {
				tempTree = tempTree.right;
			}

			else if (tempArray[i] == '.') {
				tempTree = tempTree.left;
			}

			else if (tempArray[i] == ' ' && tempTree.getInfo() != null) {
				returnString = returnString + tempTree.getInfo();
				tempTree = decodingTree;

			} else if (tempArray[i] == '#' && tempTree.getInfo() != null) {
				returnString = returnString + tempTree.getInfo() + " ";
				tempTree = decodingTree;
			}

			if (i == tempArray.length - 1 && tempTree.getInfo() != null) {
				returnString = returnString + tempTree.getInfo();

//				System.out.print(tempTree.getInfo());
			}

		}
		return returnString;

	}
}