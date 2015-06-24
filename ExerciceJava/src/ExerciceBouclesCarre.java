import java.util.Scanner;

public class ExerciceBouclesCarre {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		int size = Integer.parseInt(reader.nextLine());

		reader.close();

		// Milieu de la ligne
		int mid = size / 2;

		// Forcer taille impaire
		size = mid * 2 + 1;

		for (int line = 0; line < size; line++) {
			for (int i = 0; i < size; i++) {
				// décalage du 'bord' par rapport au milieu de la ligne.
				int offset = (line <= mid) ? line : (size - line - 1);

				// Au delà du bord
				if (i < mid - offset || i > mid + offset)
					System.out.print(' ');
				// Au bord
				else if (i == mid - offset || i == mid + offset)
					System.out.print('X');
				// A l'interieur
				else
					System.out.print('0');

			}

			// Saute une ligne
			System.out.println();
		}

	}

}
