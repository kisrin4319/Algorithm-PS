import java.io.*;
import java.math.BigInteger; 

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		BigInteger TotApple = new BigInteger(br.readLine());
		BigInteger Diff = new BigInteger(br.readLine());
		BigInteger Div  = new BigInteger("2");
		BigInteger Klaudia = (TotApple.add(Diff)).divide(Div);
		BigInteger Natalia = Klaudia.subtract(Diff);
		
		System.out.println(Klaudia);
		System.out.println(Natalia);
	}
}