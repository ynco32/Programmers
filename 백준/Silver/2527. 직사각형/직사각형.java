import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < 4; t++) {
			int x1, x2, y1, y2;
			int a1, a2, b1, b2;
			x1 = sc.nextInt();
			y1 = sc.nextInt();			
			x2 = sc.nextInt();
			y2 = sc.nextInt();			
			a1 = sc.nextInt();
			b1 = sc.nextInt();			
			a2 = sc.nextInt();
			b2 = sc.nextInt();			
	
			if (x2 < a1) {
				System.out.println("d");
			}
			else if (x2 == a1) {
				if (y1> b2) System.out.println("d");
				else if (y1 == b2) System.out.println("c");
				else {
					if(b1> y2) System.out.println("d");
					else if (b1 == y2) System.out.println("c");
					else System.out.println("b");
				}
			}
			else {
				if (a2<x1) System.out.println("d");
				else if (a2 == x1) {
					if (y1> b2) System.out.println("d");
					else if (y1 == b2) System.out.println("c");
					else {
						if(b1> y2) System.out.println("d");
						else if (b1 == y2) System.out.println("c");
						else System.out.println("b");
					}					
				}
				else {
					if (b2 < y1) System.out.println("d");
					else if (b2 == y1) System.out.println("b");
					else {
						if (b1 > y2) System.out.println("d");
						else if (b1 == y2) System.out.println("b");
						else System.out.println("a");
					}
				}
			}
		}
	}
}