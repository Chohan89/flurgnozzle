
import java.util.concurrent.ThreadLocalRandom;

public class Flurgnozzle {

	@SuppressWarnings("unused")
	private static char start;
	private static int Rounds = 0, User = 0, Computer = 0, Tie = 0;

	public static void main(String[] args) {

		Rules();
		start = Ask();
		Play();

	}

	public static void Rules() {

		System.out.println("During each round, players choose a move: either Flurg, Stuga, Kvartal, or Lerberg.");
		System.out.println("The rules are: \n	*Flurg beats Stuga and Kvartal");
		System.out.println("	*Stuga beats Kvartal");
		System.out.println("	*Kvartal beats Lerberg");
		System.out.println("	*Lerberg beats Flurg and Stuga");
	}

	public static char Ask() {
		char start = 'X';
		do {
			String Sendout = ("\n Would you like to play? (y/n)");
			start = Console.getChar(Sendout);
		} while (start != 'y' && start != 'Y' && start != 'n' && start != 'N');
		if (start == 'n' || start == 'N') {
			System.out.println("Exiting Game, Goodbye!");
			if (Rounds > 0) {
				Statistics();
			}
			System.exit(0);
		}
		return start;
	}

	public static void Play() {
		char start = 'y';
		do {
			Rounds++;
			char usrmove = Usermove();
			char cmpmove = Compmove();
			CheckWinner(usrmove, cmpmove);
			start = Ask();
		} while (start == 'y' || start == 'Y');
	}

	public static char Usermove() {

		String msg = "Enter a move: 'F'lurg, 'S'tuga, 'K'vartal, or 'L'erberg. ";
		char usrmove;
		do {
			usrmove = Console.getChar(msg);
		} while (usrmove != 'F' && usrmove != 'S' && usrmove != 'K'
				&& usrmove != 'L');
		return usrmove;
	}

	public static char Compmove() {
		int min = 1, max = 4, randnum;
		char cmpmove = 'X';
		randnum = ThreadLocalRandom.current().nextInt(min, max + 1);

		if (randnum == 1) {
			cmpmove = 'F';
		} else if (randnum == 2) {
			cmpmove = 'S';
		} else if (randnum == 3) {
			cmpmove = 'K';
		} else if (randnum == 4) {
			cmpmove = 'L';
		} else if (randnum < min || randnum > max) {
			System.out.println("random gen failed, exiting");
			System.exit(0);
		}
		return cmpmove;
	}

	public static void CheckWinner(char usrmove, char cmpmove) {
		// User has Tied //
		if (usrmove == cmpmove) {
			Tie++;
			System.out.println("Player got: " + usrmove + " Computer got: "
					+ cmpmove + "\n Whoa its a Tie!!");
			return;
		}
		// User has Flurg //
		if (usrmove == 'F') {
			if (cmpmove == 'S') {
				User++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Congratulations You Win!!");
			} else if (cmpmove == 'K') {
				User++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Congratulations You Win!!");
			} else {
				Computer++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Sorry You Lost =(");
			}
		}
		// User has Stuga //
		if (usrmove == 'S') {
			if (cmpmove == 'K') {
				User++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Congratulations You Win!!");
			} else {
				Computer++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Sorry You Lost =(");
			}
		}

		// User has Kvartal //
		if (usrmove == 'K') {
			if (cmpmove == 'L') {
				User++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Congratulations You Win!!");
			} else {
				Computer++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Sorry You Lost =(");
			}
		}

		// User has Lerberg //
		if (usrmove == 'L') {
			if (cmpmove == 'F') {
				User++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Congratulations You Win!!");
			} else if (cmpmove == 'S') {
				User++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Congratulations You Win!!");
			} else {
				Computer++;
				System.out.println("Player got: " + usrmove + " Computer got: "
						+ cmpmove + "\n Sorry You Lost =(");
			}
		}

	}

	public static void Statistics() {
		System.out.println("\n Rounds played " + Rounds);
		System.out.println("\n Player wins " + User);
		System.out.println("\n Computer wins " + Computer);
		System.out.println("\n Ties " + Tie);
	}

}
