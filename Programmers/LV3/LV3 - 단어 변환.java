import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();

        q.add(begin);

        answer = dfs(q, visited, words, target, 0);

        return answer;
    }

    public int dfs(Queue<String> q, boolean[] visited, String[] words, String target, int depth)
    {
        int result = Integer.MAX_VALUE;
        while (!q.isEmpty())
        {
            int size = q.size();
            for (int sz = 0; sz < size; sz++) {
                String str = q.poll();
                if (str.equals(target)) {
                    return Math.min(result, depth);
                }

                char[] origin = str.toCharArray();
                for (int i = 0; i < words.length; i++) {
                    int cnt = 0;
                    char[] change = words[i].toCharArray();
                    for (int j = 0; j < change.length; j++) {
                        if (origin[j] != change[j]) {
                            cnt++;
                        }
                    }
                    if (cnt == 1 && !visited[i]) {
                        visited[i] = true;
                        q.add(words[i]);
                    }
                }
            }
            depth++;
        }
        return 0;
    }
}
