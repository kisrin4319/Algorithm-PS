class Solution {
    public long[] solution(long[] numbers) {
        StringBuilder sb;
        long[] answer = new long[numbers.length];
        
        for(int idx = 0; idx<numbers.length;idx++)
        {            
            long n = numbers[idx];
            String xor = "0"+Long.toBinaryString(n);
            
            sb = new StringBuilder(xor);
            
            //짝수 일 때 이진법으로 맨 끝자리 0 만 1로 바꿔주면 끝
            
            int lastIndex = sb.lastIndexOf("0");
                sb.setCharAt(lastIndex,'1');            

            if(n%2 !=0)
            {                
                sb.setCharAt(xor.indexOf('1',lastIndex+1),'0');
            }            
            answer[idx] = Long.parseLong(sb.toString(),2);
        }
        return answer;
    }
}
