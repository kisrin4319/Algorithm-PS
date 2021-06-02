import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0)
		{
			String s = br.readLine();
			sb.append(s.length()+"\n");
		}
		System.out.println(sb);	
			
	}
}