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
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
 
class Main {
    static Myscanner sc = new Myscanner();
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static int N, M, map[][];
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0}; static int[] dy = {0,1,0,-1};
     
    public static void main(String[] args) {
 
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[305][305];
        Queue<Point> q = new LinkedList<Point>();
        int year = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        while(true)
        {
        	visited = new boolean[N][M];
        	int iceberg =0;
        	
        	for(int i=0;i<N;i++)
        	{
        		for(int j=0;j<M;j++)
        		{
        			if(map[i][j]!=0 && !visited[i][j])
        			{
        				iceberg++;
        				q.offer(new Point(i,j));
        				visited[i][j] = true;
        				
        				while(!q.isEmpty())
        				{
        					Point p = q.poll();
        					int x = p.x;
        					int y = p.y;
        					
        					for(int dr=0;dr<4;dr++)
        					{
        						int cx = x+dx[dr];
        						int cy = y+dy[dr];
        						
        						if(!visited[cx][cy] && map[cx][cy]==0){
        							if(map[x][y]>0){
        								map[x][y]--;
        							}
        						}
        						if(!visited[cx][cy] && map[cx][cy]!=0){
        							visited[cx][cy] = true;
        							q.offer(new Point(cx,cy));
        						}
        					} //end dr;
        				} // end  queue while
        			}
        		}
        	}
        	//빙하 확인
        	
        	if(iceberg>=2){
        		out.println(year);
        		out.flush();
        		return;
        	}
        	if(iceberg ==0){
        		out.println(0);
        		out.flush();
        		return;
        	}
        	year++;
        }
    }
}
class Point {
    int x, y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}