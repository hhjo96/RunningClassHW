package codingTestPractice;

import java.util.Arrays;
import java.util.Scanner;


//백준 1931번 https://www.acmicpc.net/problem/1931
public class BJ1931 {
    public static void main(String[] args) {
        //회의의 수 입력받기
        Scanner scanner = new Scanner(System.in);
  //      System.out.print("회의의 개수 입력: ");
        int countMeetingInput = scanner.nextInt();
        scanner.nextLine();


        //(시작시간, 종료시간) 이 N개인 배열로 입력받기
 //       System.out.println("회의 시간 입력");

        int[][] time = new int[countMeetingInput][2];

        for(int i = 0; i< countMeetingInput; i++){
            time[i][0] = scanner.nextInt();
            time[i][1] = scanner.nextInt();
        }

        //종료 시간을 기준으로 배열 sort. 종료시간이 같을경우 시작시간이 빠른순으로.
        //리턴이 음수인 경우 앞에있는애 먼저, 리턴이 양수인 경우 뒤에있는애 먼저.
        //음수 또는 양수를 만들기 위해 빼기를 하는거임!
        Arrays.sort(time, (a1, a2) -> {
            if(a1[1] == a2[1]){
                return a1[0] - a2[0];
            } else
                return a1[1] - a2[1];
                }
                );
        
        int answer = 0;
        int prev_end_time = 0;

        //종료시간이 작거나 같을경우 걔를 사용함
        for(int i = 0;i<countMeetingInput;i++) {
            if(prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                answer++;
            }
        }

        System.out.println("answer = " + answer);
            
    }
}
