package codingTestPractice.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1904
public class BJ1904 {
    public static void main(String[] args) {
        //1 00 두종류만 있다.
        //N이 1인 경우 1 1개, N이 2인경우 11 00 2개. N이 3인경우 111 100 001 3개. N이 4인경우 1111 1001 1100 0000 0011 5개.
        //피보나치와 비슷한 형태

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n == 1 || n == 2) {
            System.out.println(n);
        } else {
            long answer = calculate(n);
            //   System.out.println(answer + ", " + calculate(n));
            System.out.println(answer);
        }

    }

    public static long calculate(int n) {
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3;i<=n;i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 15746;
        }
//        System.out.println(Arrays.toString(arr));
 //       System.out.println(n);

        return arr[n];

    }
}
