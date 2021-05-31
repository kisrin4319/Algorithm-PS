import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());		
		
		int Time = N % 5 == 0 ? N/5 : N/5 +1;
		System.out.println(Time);
	}
}