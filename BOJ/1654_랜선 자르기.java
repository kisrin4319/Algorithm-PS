import java.io.*;
import java.math.*;
import java.util.*;

class MyScanner {
	BufferedReader br;
	StringTokenizer st;
	public MyScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	int nextInt() {
		return Integer.parseInt(next());
	}
	long nextLong() {
		return Long.parseLong(next());
	}
	double nextDouble() {
		return Double.parseDouble(next());
	}
}
public class Main {

	public static PrintWriter out;
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int K = sc.nextInt();
		int N = sc.nextInt();
		long[] LAN = new long[K];
		long max =-1;
		for(int i=0;i<K;i++)
		{
			LAN[i] = sc.nextLong();
		}
		long low = 1;
		long high = (long) (Math.pow(2, 31)-1);
		while(low<=high){
			long mid = (high+low)/2;
			long Sum =0;
			for(int i=0;i<K;i++){
				Sum+=LAN[i]/mid;
			}
			if(Sum>=N)
			{ 
				low = mid+1;
				if(mid>max)
					max = mid;
			}
			else
			{
				high = mid-1;
			}			
		}		
		out.println(max);
		out.close();
	}
}