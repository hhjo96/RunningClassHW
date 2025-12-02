package codingTestPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ1011 {
    public static void main(String[] args) {

        // 이동횟수 k = 2n -1 일 경우 움직횟수 n2
        // 거리 k = 2n 일 경우 움직횟수 n2 + n
        // 거리 k = 2n +1 일 경우 움직횟수 (n+1)2

        Scanner scanner = new Scanner(System.in);
        List<Long> list1 = new ArrayList<Long>(); // 출발지
        List<Long> list2 = new ArrayList<Long>(); // 도착지

        List<Long> answer = new ArrayList<Long>();

        int count = scanner.nextInt();

        for(int i = 0; i<count; i++){
            list1.add(scanner.nextLong());
            list2.add(scanner.nextLong());

        }

        answer = calculate(list1, list2);

        for(Long a : answer){
            System.out.println(a);
        }

    }
    public static List<Long> calculate(List<Long> list1, List<Long> list2){

        //케이스 분류
        List<Long> answer = new ArrayList<Long>();

        for(int i = 0; i < list1.size(); i++){
            long distance = list2.get(i) - list1.get(i);
            long n = (long)Math.sqrt(distance);

            if(distance == n*n) {
                answer.add(2*n-1);
            } else if (distance <= n*n+n) {
                answer.add(2*n);
            } else {
                answer.add(2*n+1);
            }
        }

        return answer;

    }
}
