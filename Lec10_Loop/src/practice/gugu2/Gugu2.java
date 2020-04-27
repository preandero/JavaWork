package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {

		// 10_04 구구단 2 페이지 과제

		for (int i = 2; i < 9; i += 3) {

			for (int j = 1; j < 10; j++) {
				int i1 = (i + 1);
				int i2 = (i + 2);
				
				if (i == 2) {
					if (j < 4) {
						System.out.println(i + " x " + j + " = " + (i * j) + "      " + i1 + " x " + j + " = " + i1 * j
								+ "      " + i2 + " x " + j + " = " + i2 * j);
					} else if (j == 4) {
						System.out.println(i + " x " + j + " = " + (i * j) + "      " + i1 + " x " + j + " = " + i1 * j
								+ "     " + i2 + " x " + j + " = " + i2 * j);

					}

					else {
						System.out.println(i + " x " + j + " = " + (i * j) + "     " + i1 + " x " + j + " = " + i1 * j
								+ "     " + i2 + " x " + j + " = " + i2 * j);
					}

				}

				if (i == 5) {
					if (j == 1) {
						System.out.println(i + " x " + j + " = " + (i * j) + "      " + i1 + " x " + j + " = " + i1 * j
								+ "      " + i2 + " x " + j + " = " + i2 * j);
					} else {
						System.out.println(i + " x " + j + " = " + (i * j) + "     " + i1 + " x " + j + " = " + i1 * j
								+ "     " + i2 + " x " + j + " = " + i2 * j);

					}

				}

				if (i == 8) {
					if (j == 1) {
						System.out
								.println(i + " x " + j + " = " + (i * j) + "      " + i1 + " x " + j + " = " + i1 * j);
					} else {
						System.out.println(i + " x " + j + " = " + i1 + "      " + i1 + " x " + j + " = " + i1 * j);
					}

				}
				
			} // end for() int j

			System.out.println("\n");

		} // end for() int i

	} // end main()

} // end class
