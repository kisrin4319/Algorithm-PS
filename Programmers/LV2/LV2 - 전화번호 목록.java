import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] phoneBook = {"123", "456", "1234"};
        String[] mockPhoneBook = {"123","2345","23467"};


        System.out.println(solution.solution(phoneBook));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>(Arrays.asList(phone_book));
        for (String s : phone_book) {
            for (int i =1; i< s.length();i++) {
                if (hs.contains(s.substring(0,i))){
                    return false;
                }
            }
        }
        return answer;
    }
}