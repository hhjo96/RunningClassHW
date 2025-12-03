package codingTestPractice.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2579
public class BJ2579 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = 0; //계단의 개수

        n = scanner.nextInt();
        int[] score = new int[n]; // 단순 점수만 저장, n: 계단의 개수
        int[] dp = new int[n];

        //입력받기
        for (int i = 0; i < n; i++) { // 0번째가 첫번째칸이고 n-1번째가 맨마지막칸임
            score[i] = scanner.nextInt();
        }

//        System.out.println(Arrays.toString(score));

        //dp 계산하기
        if (n == 1) {
            System.out.println(score[0]);
        } else if (n == 2) {
            System.out.println(score[0] + score[1]);
        } else if (n == 3) {
            System.out.println(Math.max(score[0] + score[2], score[1] + score[2]));
        } else { //n >3
            dp[0] = score[0];
            dp[1] = score[1] + score[0];
            dp[2] = Math.max(score[1] + score[2], score[0] + score[2]);

            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
            }

             System.out.println(dp[n - 1]);
        }


    }
}
