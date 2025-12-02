package codingTestPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ4948 {

    public static int MAX = 123456 * 2 + 1;

    public static void main(String[] args) {

        //소수를 미리 구해 놓고 그 사이 범위에 있는지를 확인함.
        boolean[] isPrime = new boolean[MAX];
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();

        int n = scanner.nextInt(); // 첫번째 값은 미리 입력받기

        //소수를 미리 계산해서 저장함
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // i의 배수를 지우는 단계임. i*i보다 작은 수는 이전 단계에서 이미 지워졌고, i*i가 i의배수이고 거기에 i를 더해야 다음 i의배수가 나옴
        for(int i = 2; i * i < MAX; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j < MAX; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        //사용자에게 n 입력받기
        while(n!=0) {
            input.add(n);
            n = scanner.nextInt();
        }

        //input 에 따라 소수가 몇갠지 계산하기
        int[] answer = new int[input.size()];
        int count = 0;

        for (int i = 0; i < input.size(); i++) {
            for (int j = input.get(i) + 1; j <= input.get(i) * 2; j++) {
                if(isPrime[j]) {
                    count++;
                }
            }
            answer[i] = count;
            count = 0;
        }

        for (int j : answer) {
            System.out.println(j);
        }

    }
}
