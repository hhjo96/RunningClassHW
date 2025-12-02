package codingTestPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ1002 {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        //리스트 여섯개 만들기
        int count = Scanner.nextInt();
        List<Integer> x1 = new ArrayList<>();
        List<Integer> y1 = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> x2 = new ArrayList<>();
        List<Integer> y2 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        //count 수만큼 입력받기
        for(int i = 0; i < count; i++) {
            x1.add(Scanner.nextInt());
            y1.add(Scanner.nextInt());
            r1.add(Scanner.nextInt());
            x2.add(Scanner.nextInt());
            y2.add(Scanner.nextInt());
            r2.add(Scanner.nextInt());
        }

        //d(01, 02)와 r1+r2를 구하기
        for(int i = 0; i < count; i++) {
            double d0102 = Math.pow(x1.get(i)-x2.get(i), 2) + Math.pow(y1.get(i)-y2.get(i), 2); // 거리의 제곱 상태로 비교해야 함
            double r1plusr2 = (r1.get(i)+r2.get(i))*(r1.get(i)+r2.get(i)); // 얘두 제곱함
            double r1minusr2 = (r1.get(i)-r2.get(i))*(r1.get(i)-r2.get(i)); // 제곱햇으므로 양수

            if(d0102 == 0){// 둘의 중심이 같다
                if(r2.get(i)- r1.get(i) != 0) {
                    System.out.println("0");
                } else {
                    System.out.println("-1");
                }
            } else if(d0102 > r1plusr2) { // 둘이 떨어져 있다
                System.out.println("0");
            } else if(d0102 == r1plusr2 || d0102 == r1minusr2) { // 둘이 외접 또는 내접
                System.out.println("1");
            } else if(d0102 > r1minusr2 && d0102 < r1plusr2 ) { // 둘이 두점에서 만난다
                System.out.println("2");
            } else {//한 원이 다른 원 안에 들어가있다
                System.out.println("0");
            }
        }

    }
}
