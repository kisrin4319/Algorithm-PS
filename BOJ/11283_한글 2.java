import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();		
		char answer = s.charAt(0);		
		System.out.println(((int)answer) - 44031);
	}
}