

import java.util.Scanner;

public class Console {

	private static final Scanner scan = new Scanner(System.in);

	public static String getString(String msg) {
		String ret;

		System.out.println(msg);
		ret = scan.next();
		return ret;

	}
	
	public static char getChar(String msg) {
		char ret;

		System.out.println(msg);
		ret = scan.next().charAt(0);
		return ret;

	}
	
	
	

	public static int getInt(String message, int min, int max) {
		// Create a function that takes min and max as an argument and you have to validate that to be and INT along 
		// with it being in that min and max. also handle exceptions that may occur
		// Also min CANNOT BE >= max
		
		while (min >= max)
		{
			System.out.println("Value of Min is eqaul to or greater than the value of Max.\n Please re-enter Min value");
			min = scan.nextInt();
			System.out.println("Please re-enter Max value");
			max = scan.nextInt();
			
		}
		
		Integer num = null;
		do {
			
			System.out.println(message);
			try {
				num = scan.nextInt();

			} catch (java.util.InputMismatchException e) {
				System.err.println("error " + e + "\n");
				scan.nextLine();
			}

		} while (num == null || num < min || num > max);
		return num;
	}
	
	
	
	
	public static int getInt(String message) {
	
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		int num;
		
		num = Console.getInt(message, min, max);
		return num;
	}
	
}
