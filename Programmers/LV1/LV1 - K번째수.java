import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] command : commands) {
            int start = command[0]-1;
            int end = command[1]-1;
            int cursor = command[2]-1;

            int[] slice = Arrays.copyOfRange(array, start, end+1);

            Arrays.sort(slice);
            list.add(slice[cursor]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}