package practice.game369;

public class Game369 {
	public static void main(String[] args) {
		
		
		for (int i = 1; i <= 10000; i++) {
			String stringI = Integer.toString(i);
			if(stringI.contains("3") || stringI.contains("6") || stringI.contains("9")) {
				System.out.print("*" + "\t");
				
			} else {
				System.out.print(i + "\t");
			}
			if(i % 10 == 0) {
				System.out.println();
			}
		}
	}

}
