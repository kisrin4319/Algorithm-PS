import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {	
		Scanner sc = new Scanner(System.in);	
		int first  = sc.nextInt();
		int second = sc.nextInt();
		int third  = sc.nextInt();
		int fourth = sc.nextInt();
		
		if(first > second && second > third && third > fourth) {
			System.out.println("Fish Diving");
		} else if(first < second && second < third && third < fourth) {
			System.out.println("Fish Rising");
		} else if(first == second && second == third && third == fourth) {
			System.out.println("Fish At Constant Depth");
		} else {
			System.out.println("No Fish");
		}
		sc.close();
	}
}