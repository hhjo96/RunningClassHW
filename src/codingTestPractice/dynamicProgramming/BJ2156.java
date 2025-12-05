package codingTestPractice.dynamicProgramming;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2156
public class BJ2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n+1];
        long[] sum = new long[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = scanner.nextInt();
        }


        if(n == 1) {
            System.out.println(arr[1]);
        } else if(n==2) {
            System.out.println(arr[1] + arr[2]);
        } else if(n==3) {
            System.out.println(Math.max(Math.max(arr[1] + arr[3], arr[2] + arr[3]), arr[1] + arr[2]));
        } else {
            sum[1] = arr[1];
            sum[2] = arr[1] + arr[2];
            sum[3] = Math.max(Math.max(arr[1] + arr[3], arr[2] + arr[3]), arr[1] + arr[2]);

            for(int i = 4; i <= n; i++){
                sum[i] = Math.max(Math.max(sum[i-1], sum[i-2] + arr[i]), sum[i-3] + arr[i-1] + arr[i]);
            }
            System.out.println(sum[n]);
        }

    }

}
