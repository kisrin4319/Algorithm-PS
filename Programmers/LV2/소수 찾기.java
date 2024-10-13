import java.util.*;

class Solution {
	boolean[] eratos = new boolean[10000000];
    HashSet<Integer> hs = new HashSet<Integer>();
    
    public int solution(String numbers) {
        int answer = 0;
                    
        
        permutation("",numbers);
        
        int max = Collections.max(hs);
        
        IsPrime(max);
                
        Iterator<Integer> it = hs.iterator();
        
        while(it.hasNext()) {
        	int num = it.next();
        	if(eratos[num]) {
        		answer++;
        	}
        }
        
        return answer;
    }
    
    private void permutation(String str, String numbers) {
		int n = numbers.length();
		if(!str.equals("")) {
			hs.add(Integer.valueOf(str));
		}
		
		for(int i=0; i<n;i++) {
			permutation(str+numbers.charAt(i), numbers.substring(0,i)+ numbers.substring(i+1,n));
		}
		
	}

	// Hash 중에 만들어진 최대 수 까지만 돌면 되지 않을까?
    public void IsPrime(int n){
    	Arrays.fill(eratos,true);
        eratos[0] = false;
        eratos[1] = false;
        
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(!eratos[i]){
                continue;
            }
            for(int j= i*2;j<=n;j+=i){
                eratos[j] = false;
            }
        }
        return;
    }   
    
}
