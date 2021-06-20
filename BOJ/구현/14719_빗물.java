import java.util.*;

public class Main {
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        
        int H = sc.nextInt();
        int W = sc.nextInt();
 
        int leftMax = 0;
        int cur     = 0;
        int rightMax= 0;        
        int answer  = 0;
        
        int[] block = new int[W];
        
        for(int idx = 0; idx<W; idx++)
        {
            block[idx] = sc.nextInt();
        }        
        
        //H는 굳이 필요 없을 듯..
        
        for(int idx = 1; idx<W-1;idx++)
        {
            cur = block[idx];
            
            leftMax = rightMax = 0;
            
            for(int left = 0; left<idx;left++)
            {
                leftMax = Math.max(leftMax,block[left]);
            }
            
            for(int right = idx+1; right<W;right++)
            {
                rightMax = Math.max(rightMax,block[right]);
            }
            int min = Math.min(leftMax,rightMax) - cur;
            
            if(min>=0)
            {
                answer+= min;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}