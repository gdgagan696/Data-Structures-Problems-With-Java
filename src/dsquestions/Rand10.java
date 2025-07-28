package dsquestions;

public class Rand10 {

	private static int rand7() {
		return ((int) (Math.random() * (7 - 1))) + 1;
	}

	private static int rand10() {
		int randomNumber = 41;
		while (randomNumber > 40) {
			randomNumber = 7 * (rand7() - 1) + rand7();
		}
		return (randomNumber % 10) + 1;
	}

	public static void main(String[] args) {
		int n = 10;
		for (int i = 0; i < n; i++)
			System.out.print(rand10()+" ");

	}

}
