import java.util.Scanner;

public class ExerciceBouclesTriangle {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		int size = Integer.parseInt(reader.nextLine());

		reader.close();

		for (int line = 0; line < size; line++) {
			for (int i = 0; i < (size - line); i++) {
				// Au bord
				if (line == 0 || i == 0 || i == (size - line - 1))
					System.out.print('X');
				// A l'interieur
				else
					System.out.print('0');
			}

			System.out.println();
		}

	}

}
