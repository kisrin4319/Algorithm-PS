import java.io.*;
import java.util.*;
 
class Myscanner {
    BufferedReader br;
    StringTokenizer st;
 
    Myscanner() {
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
 
    String nextLine() {
        String str = "";
        try {
            str += br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
 
public class Main {
    static Myscanner sc = new Myscanner();
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
     public static void main(String[] args) {
      
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	char[][] map = new char[50][50];
    	
    	for(int i=0;i<N;i++){
    		map[i] = sc.next().toCharArray();
    	}
    	int ans = 65;
    	for(int i=0;i<=N-8;i++)
    	{
    		for(int j=0;j<=M-8;j++){
    			int cnt =0;
    			
    			for(int r =0; r<8;r++){
    				for(int c = 0;c<8;c++){
    					cnt+= (r%2==c%2 ? 'W':'B') ==map[i+r][j+c] ? 1:0;
    				}
    			}
    			ans = Math.min(ans, cnt);
    			ans = Math.min(ans, 64-cnt);
    		}
    	}
    	out.println(ans);
        out.flush();
    }
}