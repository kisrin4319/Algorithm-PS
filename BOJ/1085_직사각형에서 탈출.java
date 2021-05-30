import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int WM = Math.min(x, Math.abs(w-x));
		int HM = Math.min(y, Math.abs(h-y));
		double cross = Math.min(Math.sqrt(x*x+y*y), Math.sqrt(Math.pow(w-x,2)+Math.pow(h-y,2)));
	
		int min = (int) Math.min(WM, Math.min(HM, cross));
		System.out.println(min);
		sc.close();
	}
}