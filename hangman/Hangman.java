//Danyal Haque - Lab 1

package hangman;

import java.io.File;
import java.util.Scanner;

public class Hangman {

	
	public static void main(String[] args) {

		int number = 1;
		File words = new File("words.txt");
		Dictionary dictionary = new Dictionary(words);

		Scanner userinput = new Scanner(System.in);

		while (number != 0) {
			switch (number) {
			
			case 1:
				Game play = new Game(dictionary);
				play.playGame();
			}
			
			System.out.printf("----------------------------------\r\n" + "Play again?  (1: yes, 0: no) ==> ");
			number = userinput.nextInt();
		}

	}

}
