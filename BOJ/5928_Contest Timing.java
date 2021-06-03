import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {		
	
		Scanner sc = new Scanner(System.in);
	
		int D = sc.nextInt();
		int H = sc.nextInt();
		int M = sc.nextInt();		
		
		int STime = 11 * 24 * 60 + 11 * 60 + 11;
		
		int ETime = D  * 24 * 60 + H  * 60 + M;		
		
		int Time = ETime - STime;		
		
		if(Time <0) {
			System.out.println(-1);
		}
		else {
			System.out.println(Time);
		}		
		sc.close();
	}
}