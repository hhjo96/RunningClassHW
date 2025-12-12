package codingTestPractice.dynamicProgramming;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11054
public class BJ11054 {
    public static void main(String[] args) {
        //배열의 길이 입력받고
        Scanner scanner = new Scanner(System.in);
        //배열을 입력받고
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        //dp[i]: i에서 끝나는 LIS의 길이
        int[] dpf = new int[arr.length];
        int[] dpb = new int[arr.length];

        //앞으로 가면서 최대값 찾기
        dpf[0] = 1;
        if (arr.length == 1) {
            System.out.println(arr.length);
        } else if (arr.length == 2) {
            if (arr[0] == arr[1]) {
                System.out.println(1);
            } else {
                System.out.println(arr.length);
            }
        } else {
            //앞으로 가면서 찾기
            for (int i = 1; i < arr.length; i++) {
                dpf[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dpf[i] = Math.max(dpf[i], dpf[j] + 1);
                    }
                }
               // System.out.println("현재 값: dpf[i] = " + dpf[i]);
            }
            //뒤로 가면서 찾기
            for (int i = arr.length - 1; i >= 0; i--) {
                dpb[i] = 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        dpb[i] = Math.max(dpb[i], dpb[j] + 1);
                    }
                }
                //System.out.println("현재 값: dpb[i] = " + dpb[i]);
            }
            //둘이 더해서 최대값 찾기
            int max = dpf[0] + dpb[0];
            for (int i = 1; i < arr.length; i++) {
                max = Math.max(max, dpf[i] + dpb[i]);
               // System.out.println(dpf[i] + " " + dpb[i]);
            }
            System.out.println(max - 1);


        }
    }
}
