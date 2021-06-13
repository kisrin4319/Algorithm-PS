import java.util.*;

public class Main {

    static Shark shark;
    static int N, answer, sharkx, sharky;
    static int[][] map;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];        
        shark = new Shark(2,0);

        // 기본 세팅 및 상어 위치
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                map[row][col] = sc.nextInt();
                if (map[row][col] == 9) {
                    sharkx = row;
                    sharky = col;
                    map[row][col] = 0;
                }
            }
        }
        Eating();

        System.out.println(answer);
        sc.close();

    }

    private static void Eating() {

        int time = 0;
        Queue<Point> q = new LinkedList<Point>();
        PriorityQueue<Point> fish = new PriorityQueue<>();
        
        boolean[][] eat = new boolean[N][N];
        
        q.offer(new Point(sharkx,sharky));
        eat[sharkx][sharky] = true;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int sz = 0; sz<size; sz++)
            {
                
                Point p = q.poll();
                
                int x = p.x;
                int y = p.y;
                
                for(int cycle = 0; cycle<4; cycle++)
                {
                    int cx = x+dx[cycle];
                    int cy = y+dy[cycle];
                    
                    if(cx>=0 && cx<N && cy>=0 && cy<N ) // 좌표 범위 체크
                    {
                        if(!eat[cx][cy] && map[cx][cy]<=shark.size) //이미 방문했는지,지나갈수 있는지 
                        {
                            q.offer(new Point(cx,cy));
                            eat[cx][cy] = true;
                            
                            if(map[cx][cy]!= 0 && map[cx][cy]<shark.size) {
                                fish.offer(new Point(cx,cy));
                            }
                        }                        
                    }
                 }
             }
            time++;
            
            if(!fish.isEmpty())
            {
                Point p = fish.poll();
                fish.clear();
                shark.eat();
                
                if(shark.size == shark.cnt)
                {
                    shark.SizeUp();
                }
                
                sharkx = p.x;
                sharky = p.y;
                map[sharkx][sharky] = 0;
                answer+=time;
                time = 0;
                q.clear();
                q.offer(new Point(sharkx,sharky));
                
                eat = ArraySet(sharkx,sharky);
                
            }
         }
        
    }

    private static boolean[][] ArraySet(int sharkx, int sharky) {
        boolean[][] tmp = new boolean[N][N];
        tmp[sharkx][sharky] = true;
        return tmp;
        
    }
}
class Point implements Comparable<Point>
{
    int x;
    int y;
    
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point p)
    {
        if (this.x == p.x)
        {
            return this.y - p.y;
        }
        else
        {
            return this.x - p.x;
        }
    }
}
class Shark
{
    int size;
    int cnt;
 
    Shark(int size, int cnt){
        this.size = size;
        this.cnt = cnt;
    }
    
    void eat() {
        this.cnt = this.cnt+1;
    }
    void SizeUp() {
        this.size = this.size+1;
        this.cnt  = 0;
    }
}