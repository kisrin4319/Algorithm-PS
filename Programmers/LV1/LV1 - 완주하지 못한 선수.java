class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> hm = new HashMap<String,Integer>();

        for (String s : completion) {
            int p = hm.getOrDefault(s, 0);
            hm.put(s, p + 1);
        }

        for (String s : participant) {
            int p = hm.getOrDefault(s, 0);
            if (p == 0) {
                answer = s;
                break;
            }
            hm.put(s, p - 1);
        }

        return answer;
    }
}