class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int opportunity = nums.length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        answer = Math.min(opportunity, map.size());
        return answer;
    }
}