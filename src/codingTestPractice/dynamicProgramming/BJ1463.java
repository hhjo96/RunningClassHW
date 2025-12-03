package codingTestPractice.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BJ1463 {

    static int[] dp = new int[1000001]; // 0은 사용 안함
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       int n = scanner.nextInt();
       if(n == 1){
           System.out.println(0);
       }
        else if (n == 2 || n == 3) {
            System.out.println(1);
        } else {
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;

            for(int i = 4; i <= n; i++) {
                dp[i] = c(i);
            }

            System.out.println(dp[n]);
        }


    }
    public static int c(int n) {
        dp[n] = dp[n - 1] + 1;

        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], dp[n / 3] + 1);
        }
        if(n % 2 == 0) {
            dp[n] = Math.min(dp[n], dp[n / 2] + 1);
        }
        return dp[n];

    }

}
