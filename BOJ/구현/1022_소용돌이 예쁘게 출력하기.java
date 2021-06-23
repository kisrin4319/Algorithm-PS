import java.io.*;
import java.util.*;

public class Main {
    static int r1,c1,r2,c2,cnt,len;
    static ArrayList<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        cnt = (Math.abs(r1-r2)+1) * (Math.abs(c1-c2)+1);

        int r = 0;
        int c = 0;

        int rt = 1;
        int ct = 1;

        int value = 1;
        int loop = 1;

        boolean reverseR = false;
        boolean reverseC = false;

        boolean init = true;

        while(init)
        {
            if(loop%2 == 0)
            {
                for(int idx = 0; idx<rt;idx++)
                {
                    init = AddElement(r,c,value);

                    if(!reverseR) r--;
                    else         r++;
                    value++;
                }
                rt++;
                reverseR = !reverseR;
            }
            else
            {
                for(int idx =0;idx<ct;idx++)
                {
                    init = AddElement(r,c,value);

                    if(!reverseC) c++;
                    else         c--;
                    value++;
                }
                ct++;
                reverseC = !reverseC;
            }
            loop++;
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x == o2.x){
                    return o1.y - o2.y;
                }
                else{
                    return o1.x-o2.x;
                }
            }
        });

        String format = "%"+len+"d ";
        int enter = (c2-c1+1);
        for(int idx = 0; idx<list.size();idx++)
        {
            Point p = list.get(idx);
            int v = p.value;
            if(idx>0 && idx%enter == 0){
                System.out.println("");
            }
            System.out.printf(format,v);
        }
        br.close();
    }

    private static boolean AddElement(int r, int c,int value)
    {
        if(r1<=r && r<=r2 && c1<=c && c<=c2){
            list.add(new Point(r,c,value));
            len = Math.max(len,String.valueOf(value).length());
        }

        if(cnt == list.size()){
            return false;
        }
        return true;
    }
}

class Point
{
    int x;
    int y;
    int value;

    Point(int x, int y , int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}