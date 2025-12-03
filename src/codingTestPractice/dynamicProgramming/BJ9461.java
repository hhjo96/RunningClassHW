package codingTestPractice.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/9461
public class BJ9461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t > 0) {
            int n = scanner.nextInt();
            if(n == 1 || n == 2){
                System.out.println(1);
            } else {
                long answer = calculate(n);
                System.out.println(answer);
            }

            t--;
        }
    }

    public static long calculate(int n) {
        long[] arr = new long[n+1];

        //초기화
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for(int i = 4; i <= n; i++) {
//            System.out.println(Arrays.toString(arr));
            arr[i] =  arr[i-2] + arr[i-3];
//            System.out.println(i + " " + arr[i]);
        }

        return arr[n];

    }
}
