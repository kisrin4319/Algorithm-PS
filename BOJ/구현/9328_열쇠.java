import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            boolean[] keys = new boolean[26];
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            int answer = 0;
            char[][] building = new char[H+2][W+2];
            
            
            //가상의 벽면을 만들어서 진입 한다.
            for(int r=0;r<W+2;r++)
            {
                building[0][r] = building[H+1][r] = '.';
            }
            
            for(int r = 1; r<H+1; r++)
            {
                String str = br.readLine();
                building[r][0] = building[r][W+1] = '.';
                
                for(int c = 1; c<W+1;c++) {
                    building[r][c] = str.charAt(c-1);
                }
            }
            
            String key = br.readLine();

            if (!key.equals("0")) {
                for (int idx = 0; idx < key.length(); idx++) {
                   keys[key.charAt(idx) -'a'] = true;
                }
            }
            
            answer = Find(building,keys,0,0);

            bw.append(String.valueOf(answer));
            bw.newLine();
        }
        bw.flush();
        
    }

    private static int Find(char[][] building, boolean[] keys, int row, int col) {
        
        Queue<Point> q = new LinkedList<Point>();
        Queue<Point>[] lock = new Queue['Z'-'A'+1];
        
        
        for(int idx = 0; idx<keys.length;idx++)
        {
            lock[idx] = new ArrayDeque<>();
        }

        int R = building.length;
        int C = building[0].length;
        int doc = 0;

        boolean[][] visited = new boolean[R][C];

        visited[row][col] = true;

        q.add(new Point(row, col));

        while (!q.isEmpty()) {
            int size = q.size();

            for (int sz = 0; sz < size; sz++) {
                Point p = q.poll();
                int x = p.x;
                int y = p.y;

                for (int cycle = 0; cycle < 4; cycle++) {
                    int cx = x + dx[cycle];
                    int cy = y + dy[cycle];
                    

                    if(cx <0 || cx>=R || cy<0 || cy>=C || visited[cx][cy]) continue;
                    
                    char c = building[cx][cy];
                    
                    if(c == '*') continue;
                    
                    visited[cx][cy] = true;
                    
                    if(c == '$') doc++;
                    else if(c>='A' && c<='Z')
                    {
                        if(!keys[c-'A']) {
                            lock[c-'A'].add(new Point(cx,cy));
                            continue;
                        }
                    }
                    else if(c>='a' && c<='z') {
                        keys[c-'a'] = true;
                        while (!lock[c - 'a'].isEmpty())
                            q.offer(lock[c - 'a'].poll());
                    }
                    
                    q.add(new Point(cx,cy));
                    
                }
            }
        }
        return doc;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}