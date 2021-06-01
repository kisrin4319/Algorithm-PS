import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);		
		
		int Sum = sc.nextInt();
		int diff = sc.nextInt();
		
		
		int x = (Sum +diff) /2;
		int y = Sum-x;
		
		if(Math.abs(x+y) == Sum && Math.abs(x-y) == diff && x>=0 && y>=0 ) {
			System.out.println(Math.max(x,y)+" "+ Math.min(x,y));
		}
		else {
			System.out.println(-1);
		}
	}
}