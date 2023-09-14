// Danyal Haque
// Lab 4

package lab4;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Scanner userinput = new Scanner(System.in);
		MorseCode mc = new MorseCode();

		System.out.println("Enter 1 to enter Morse Code");
		System.out.println("Enter 2 to enter text");
		System.out.println("Enter 0 to exit\n");
		System.out.print("Enter: ");

		int input = userinput.nextInt();
		userinput.nextLine();

		// Loop that prompts the user to enter either Morse Code to text, or text to
		// Morse Code
		while (input != 0) {

			System.out.print("Enter: ");

			if (input == 1) {
				System.out.print("\nInsert Morse Code to be decoded: ");
				String code = userinput.nextLine();
				System.out.println("This code translates to: " + mc.decode(code));

			}

			if (input == 2) {
				System.out.print("\nInsert text to be encoded: ");
				String message = userinput.nextLine();
				message = message.toUpperCase();
				System.out.println("This text translates to: " + mc.encode(message));

			}

			System.out.println("\nEnter 1 to enter Morse Code");
			System.out.println("Enter 2 to enter text");
			System.out.println("Enter 0 to exit\n");
			System.out.print("Enter: ");
			input = userinput.nextInt();
			userinput.nextLine();

		}

	}

}
