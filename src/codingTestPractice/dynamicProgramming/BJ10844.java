package codingTestPractice.dynamicProgramming;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10844
public class BJ10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        int[][] dp = new int[n+1][10]; // 길이가 행이고 맨뒷자리수가 열인 계단수의 개수를 저장하는 배열

        if(n == 1){
            System.out.println(9);
        } else {
            dp[1][0] = 0;
            dp[1][1] = 1;
            dp[1][2] = 1;
            dp[1][3] = 1;
            dp[1][4] = 1;
            dp[1][5] = 1;
            dp[1][6] = 1;
            dp[1][7] = 1;
            dp[1][8] = 1;
            dp[1][9] = 1;

            for(int i = 2; i <= n; i++){
                dp[i][0] = dp[i-1][1];
                dp[i][9] = dp[i-1][8];
                for(int j = 1; j < 9; j++){
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1] )% 1000000000;
                }
            }

//            for(int i = 1; i <=n; i++) {
//                for(int j = 0; j < 10; j++) {
//                    System.out.println("(" + i +", " + j + "):"+dp[i][j]+" ");
//                }
//            }

            for (int j = 0; j < 10; j++) {
                answer = (answer+ dp[n][j] )% 1000000000;

            }
            System.out.println(answer);
        }
    }
}
