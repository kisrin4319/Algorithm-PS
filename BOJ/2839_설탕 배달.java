import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(br.readLine());
        int minBasket = Integer.MAX_VALUE;

        for(int fiveBasket = 0; fiveBasket <= weight / 5; ++fiveBasket) {
            int remainingWeight = weight - fiveBasket * 5;
            if (remainingWeight % 3 == 0) {
                int threeBasket = remainingWeight / 3;
                minBasket = Math.min(minBasket, fiveBasket + threeBasket);
            }
        }

        if (minBasket == Integer.MAX_VALUE) {
            minBasket = -1;
        }

        System.out.println(minBasket);
    }
}
