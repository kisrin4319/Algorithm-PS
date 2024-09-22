import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfHumans = Integer.parseInt(br.readLine());
        int[] waitTimes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(waitTimes);

        int[] cumulativeTime = new int[numberOfHumans];
        cumulativeTime[0] = waitTimes[0];

        for (int i = 1; i < numberOfHumans; i++) {
            cumulativeTime[i] = cumulativeTime[i - 1] + waitTimes[i];
        }

        int totalWaitTime = Arrays.stream(cumulativeTime).sum();
        System.out.println(totalWaitTime);
    }
}