import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);		
		
		int N = sc.nextInt();
		int row = N/2;
		int col = N-row;
		
		System.out.println((row+1)*(col+1));
	}
}