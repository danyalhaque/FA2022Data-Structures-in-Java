//Danyal Haque - Lab 1

package hangman;

import java.util.Scanner;

public class Game {

	private Dictionary dictionary;
	private String guessWord;
	private String currentGuesses;
	private char[] guesses = new char[26];
	private int guessAmount;
	private Scanner userinput = new Scanner(System.in);

	// Plays the game, gets the guessword, initializes unused letters and guess
	// amounts.
	public void playGame() {

		String guessLetter = null;

		this.guessWord = getWord();
		String unusedLetters = "abcedfghijklmnopqrstuvwxyz";

		this.guessAmount = this.guessWord.length() + 5;
		userGuesses();
		filledGuesses();

		System.out.printf("Welcome to Hangman!%n" + "Try to guess my word, it has %d letters.%n%n",
				this.guessWord.length());

		// When guesses are out, the game is lost and the loop is finished, and a
		// message is printed to indicate this.
		while (guessAmount > 0) {
			System.out.printf("--------------------%n" + "Word: %s%n" + "Guesses left: %d%n"
					+ "Available letters: %s%n%n" + "Please enter a letter: ", filledGuesses(), this.guessAmount,
					unusedLetters);

			guessLetter = userinput.nextLine();
			userInputCheck(guessLetter);
			unusedLetters = unusedLetters.replace(guessLetter, "");

			// If the word has been guessed, a message is printed to indicate this, and the
			// loop is broken early before guesses run out.
			if (this.currentGuesses.equals(this.guessWord)) {
				System.out.printf("%nWord: %s%n", filledGuesses());
				System.out.println("Congratulations! You guessed it!");
				break;
			}

		}

		if (guessAmount <= 0) {
			System.out.printf("%nSorry, you have no more guesses, you lose.%n" + "The word was: %s%n", this.guessWord);
		}

	}

	// Constructor for the Game to load the dictionary.
	public Game(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	// Gets the random word from the wordlist
	public String getWord() {

		return (this.dictionary.randomWord());

	}

	// Initializes the users guess as a series of hyphens
	public void userGuesses() {

		this.guesses = this.guessWord.toCharArray();

		for (int i = 0; i < this.guessWord.length(); i++) {

			this.guesses[i] = '-';

		}

	}

	// Shows the current guess, including the hyphens and guessd letters
	public String filledGuesses() {
		this.currentGuesses = null;

		this.currentGuesses = this.currentGuesses.valueOf(this.guesses);

		return this.currentGuesses;
	}

	// Shows whether or not the guess from the userinput was in the word or not, and
	// replaces one of the blank hyphen spaces with the appropriate letter.
	public boolean userInputCheck(String guessLetter) {

		if (this.guessWord.contains(guessLetter)) {
			System.out.println("Good guess!");

			for (int i = 0; i < this.guesses.length; i++) {

				if (guessLetter.equals(this.guessWord.substring(i, i + 1))) {
					this.guesses[i] = this.guessWord.substring(i, i + 1).charAt(0);

				}

			}
			this.currentGuesses = this.currentGuesses.valueOf(this.guesses);
			return true;
		} else
			System.out.println("Oops! That letter is not in my word.");
		this.guessAmount--;
		return false;

	}
}
