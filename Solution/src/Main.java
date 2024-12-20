import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] mockArray = {1,5,2,6,3,7,4};
        int[][] mockCommands = {{2, 5, 3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(solution.solution(mockArray, mockCommands)));
    }
}

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