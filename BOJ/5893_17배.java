import java.math.*;
import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb.append(br.readLine());
		
		String str = sb.reverse().toString();
		
		BigInteger N = new BigInteger("0");
		
		
		for(int idx =0; idx<str.length();idx++)
		{
			String num = str.charAt(idx)+"";
			
			N = N.add(new BigInteger(num).multiply((new BigInteger("2").pow(idx))));
		}		
		N= N.multiply(new BigInteger("17"));
				
		while(N!= BigInteger.ZERO)
		{
			sb2.append(N.mod(new BigInteger("2")));
			N = N.divide(new BigInteger("2"));
		}
		
		System.out.println(sb2.reverse());	
		
	}
}