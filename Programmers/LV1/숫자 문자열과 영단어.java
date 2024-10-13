class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] number = {"0","1","2","3","4","5","6","7","8","9"};        
        
        for(int idx = 0; idx<number.length;idx++)
        {
            s = s.replaceAll(str[idx],number[idx]);
        }
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
