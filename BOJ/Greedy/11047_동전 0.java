import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int coinCount = input[0];
        int targetAmount = input[1];

        int[] coins = new int[coinCount];
        for (int i = 0; i < coinCount; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 동전으로 만들 수 있는 최대 개수 계산
        int totalCoins = calculateMinimumCoins(coins, targetAmount);
        System.out.println(totalCoins);
    }

    private static int calculateMinimumCoins(int[] coins, int amount) {
        int totalCoins = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount == 0) {
                break;
            }

            totalCoins += amount / coins[i];
            amount %= coins[i];
        }

        return totalCoins;
    }
}
