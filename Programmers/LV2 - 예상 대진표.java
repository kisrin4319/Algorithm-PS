import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        
        boolean init = true;
        int cnt = 0;
        int num1;
        int num2;
        
        
        num1 = divide(max);
        num2 = divide(min);
        
        if(num1 == num2){
            cnt++;
            init = false;
        }
        
        while(init)
        {
          max = divide(max);
          min = divide(min);
          cnt++;
          if((max == min)){
              break;
          }
          //  System.out.println("min: "+min+" max: " + max);
        }
        
        return cnt;
    }
    public static int divide(int num){
        if(num% 2 ==0){
            return num/2;
        }
        else{
            return num/2 +1;
        }
    }
}