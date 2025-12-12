package codingTestPractice;

import java.util.Scanner;

//1541 https://www.acmicpc.net/problem/1541
public class BJ1541 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

 //       System.out.println("str = " + str);

        //마이너스가 나올때마다 잘라(마이너스 앞에서 괄호 친다고 생각)
        String[] partStr = str.split("-");
        int sum = sumByPlus(partStr[0]);

 //       System.out.println("partStr = " + partStr);

        //마이너스 기준으로 나뉜 속은 플러스임.
        for(int i = 1;i< partStr.length; i++) {
            sum -= sumByPlus(partStr[i]);
        }

        System.out.println(sum);
    }
    
    //+ 기준으로 나누는 함수
    public static int sumByPlus(String s){

        int sum = 0;
        String[] temp = s.split("\\+");

        for (String string : temp) {
            sum += Integer.parseInt(string);
        }
        return sum;
    }

}
