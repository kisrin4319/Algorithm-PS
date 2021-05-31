import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		long remain =0;
		for(int index = 0; index<str.length();index++)
		{
			remain = (remain * 10 + (str.charAt(index)-'0')) % 20000303;
		}
		
		System.out.println(remain);
	}
}