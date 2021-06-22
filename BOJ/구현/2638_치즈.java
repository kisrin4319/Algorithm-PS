import java.io.*;
import java.util.*;

public class Main {
    static int N,M,Time=0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int r = 0; r<N;r++)
        {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c<M;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean init = true;
        while(init) {
            init = Oxidation(0, 0);
        }
        bw.append(String.valueOf(Time));
        br.close();
        bw.flush();
    }

    private static boolean Oxidation(int r, int c)
    {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[][] oxide = new int[N][M];

        q.add(new Point(r,c));
        visited[r][c] = true;
        Time++;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int sz = 0; sz<size;sz++)
            {
                Point p = q.poll();

                int x = p.x;
                int y = p.y;

                for(int cycle = 0 ;cycle<4;cycle++)
                {
                    int cx = x + dx[cycle];
                    int cy = y + dy[cycle];

                    if(cx>=0 && cx<N && cy>=0 && cy<M && !visited[cx][cy]) {
                        if (map[cx][cy] == 1) {
                            oxide[cx][cy] += 1;
                        } else {
                            visited[cx][cy] = true;
                            q.add(new Point(cx, cy));
                        }
                    }
                }
            }
        }
        Melt(oxide);
        int cheese = CountCheese(0);

        return cheese == 0 ? false : true;
    }

    private static int CountCheese(int cnt)
    {
        for(int r=0;r<N;r++)
        {
            for(int c=0;c<M;c++)
            {
                if(map[r][c]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void Melt(int[][] oxide)
    {
        for(int r=0;r<N;r++)
        {
            for(int c=0;c<M;c++)
            {
                if(oxide[r][c]>=2){
                    map[r][c] = 0;
                }
            }
        }
    }
}
class Point
{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}