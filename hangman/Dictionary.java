//Danyal Haque - Lab 1

package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {

	private ArrayList<String> wordList;

	//Dictionary constructor that adds words from file to wordlist using addword method.
	public Dictionary(File words) {

		ArrayList<String> wordList = new ArrayList<>();
		this.wordList = wordList;
		
		try {
			Scanner input = new Scanner(words);

		while(input.hasNext())
			addWord(input.next());
			
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}	

	}
	
	//Adds words to wordlist
	public void addWord(String word) {
		
		this.wordList.add(word);
		
	}
	
	//Selects a random word from the wordlist to be used as the word to be guessed by the user.
	public String randomWord(){
		
		Random random = new Random();
		int index = random.nextInt(this.wordList.size());
		
		
		return this.wordList.get(index);
		
	}

}
