import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] clothes = {{"crow_mask", "face"},{"blue_sunglasses", "face"},{"smoky_makeup", "face"}};


        System.out.println(solution.solution(clothes));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String,Integer> cloth = new HashMap<String,Integer>();

        for (String[] clothe : clothes) {
            cloth.put(clothe[1],cloth.getOrDefault(clothe[1],0)+1);
        }

        Set<String> keys = cloth.keySet();

        for (String key : keys) {
            answer *= (cloth.get(key) + 1);
        }

        return answer-1;
    }
}