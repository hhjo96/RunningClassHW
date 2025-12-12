package codingTestPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ9184 {

    public static long[][][] arr = new long[21][21][21]; // 값을 미리 저장할 정수 배열.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        //값을 미리 저장할 arr 배열 전부 1로 채워놓기
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if(i == 0 || j == 0 || k == 0) {
                        arr[i][j][k] = 1;

                    } else {
                        arr[i][j][k] = 0;
                    }

                }
            }
        }


        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int c1 = scanner.nextInt();


        while (true) {

            a.add(a1);
            b.add(b1);
            c.add(c1);

            if(a1 == -1 && b1 == -1 && c1 == -1) {
                break;
            } else {
                a1 = scanner.nextInt();
                b1 = scanner.nextInt();
                c1 = scanner.nextInt();
            }
        }

        for (int i = 0; i < a.size(); i++) {

            if (a.get(i) == -1 && b.get(i) == -1 && c.get(i) == -1) {
            } else {
                long answer = w(a.get(i), b.get(i), c.get(i));
                System.out.println("w(" + a.get(i) + ", " + b.get(i) + ", " + c.get(i) + ") = " + answer);
            }
        }
    }

    public static long w(int a, int b, int c) {
        //0이 있는 경우 바로넘기기
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }//20보다 큰 수가 있는 경우 결과 고정
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }// 값이 이미 계산된 경우 바로넘기기
        if (arr[a][b][c] != 0) {
            return arr[a][b][c];
        }
        if (a < b && b < c) {
            arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            arr[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
        return arr[a][b][c];
    }
}




