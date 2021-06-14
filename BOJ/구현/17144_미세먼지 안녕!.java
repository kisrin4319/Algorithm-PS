import java.util.*;

public class Main {

    static int R,C,T,tx,ty,bx,by;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static Queue<Point> dust;
    static ArrayList<Point> filter;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        
        map = new int[R][C];
        visited = new boolean[R][C];
        dust = new LinkedList<Point>();
        filter = new ArrayList<Point>();
        
        for(int r = 0; r<R; r++)
        {
            for(int c = 0; c<C; c++)
            {
                map[r][c] = sc.nextInt();
                if(map[r][c]==-1) {
                    filter.add(new Point(r,c));
                }
            }
        }
        
        Collections.sort(filter,new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.x-p2.x;
            }
        });
                
        tx = filter.get(0).x;
        ty = filter.get(0).y;
        bx = filter.get(1).x;
        by = filter.get(1).y;
        
        int[] tp = {3,0,1,2};
        int[] bp = {3,2,1,0};
        
        while(T-->0) {
            dustBatch();
            Spread();
            //PrintArray(map);
            Cleaner(tx,ty,tp);
            //PrintArray(map);
            Cleaner(bx,by,bp);
            //PrintArray(map);            
        }
        
        System.out.println(ArraySum());
        
        sc.close();

    }

    //미세 먼지 위치 다시 배치
    private static void dustBatch()
    {
        dust.clear();
        for(int r = 0; r<R; r++)
        {
            for(int c = 0; c<C; c++)
            {
                if(map[r][c] > 0) {
                    dust.add(new Point(r,c));
                }
            }
        }
    }

    //1. 확산
    private static void Spread()
    {
        int[][] temp = new int[R][C];
        
        temp[tx][ty] = -1;
        temp[bx][by] = -1;
        
        int size = dust.size();
        
        for(int sz =0; sz<size;sz++)
        {
            Point p = dust.poll();
            
            int r = p.x;
            int c = p.y;
            
            int cnt =0;
            for(int cycle = 0; cycle<4;cycle++)
            {
                int cr = r+dr[cycle];
                int cc = c+dc[cycle];                
                
                if(cr>=0 && cr<R && cc>=0 && cc < C && map[cr][cc]!=-1) {
                    cnt++;
                    temp[cr][cc]+= map[r][c]/5;
                    dust.offer(new Point(cr,cc));
                }
            }

            if(cnt!=0) {
             temp[r][c]+= map[r][c] - ((map[r][c]/5)*cnt);   
            }
        }
        map = ArrayCopy(temp);
    }
    
    //2. 공기 청정 작업
    private static void Cleaner(int x, int y, int[] dir)
    {
        int[][] temp = ArrayCopy(map);
                
        int CleanerX = x;
        int CleanerY = y+1;
        
        map[CleanerX][CleanerY] = 0;                
        
        for(int cycle =0; cycle<4;cycle++)
        {
            
            while(true)
            {
                int cx = CleanerX + dr[dir[cycle]];
                int cy = CleanerY + dc[dir[cycle]];
                
                if( cx <0 || cx>=R || cy <0 || cy>=C ) {
                    break;
                }
                
                if(cx == x && cy == y) {
                    break;
                }
                
                map[cx][cy] = temp[CleanerX][CleanerY];
                CleanerX = cx;
                CleanerY = cy;
            }
        }
    }
    
    
    
    private static void PrintArray(int[][] temp) {
        System.out.println("");
        
        for(int r =0; r<R;r++)
        {
            for(int c =0; c<C;c++) {
                System.out.printf("%3d ", temp[r][c]); 
            }
            System.out.println("");
        }
        System.out.println("");
    }
    private static int[][] ArrayCopy(int[][] origin)
    {
        int[][] temp = new int[R][C];
        
        for(int r =0; r<R;r++)
        {
            for(int c =0; c<C;c++) {
                temp[r][c] = origin[r][c];
            }
        }
        return temp;
    }
    
    private static int ArraySum()
    {
        int answer = 0;
        for(int r =0; r<R;r++)
        {
            for(int c =0; c<C;c++) {
                if(map[r][c]>0)
                {
                    answer+= map[r][c];
                }
            }
        }
        return answer;
    }
}
class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}