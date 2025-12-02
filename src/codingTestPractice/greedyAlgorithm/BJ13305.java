package codingTestPractice;

import java.util.Scanner;

public class BJ13305 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 도시의 개수
        long[] cityOil = new long[n]; // 각 도시의 리터당 가격 저장
        long[] road = new long[n-1]; // road[i] 가 cityOil[i] , [i+1] 사이 도로임

        //입력받기
        for(int i = 0; i < n-1; i++){
            road[i] = scanner.nextLong();
        }
        for(int i = 0; i < n; i++){
            cityOil[i] = scanner.nextLong();
        }

        //1. 기본적으로 지금 도시에서 다음 도시까지 갈만큼만 주유한다.
        //2. 근데 지금까지 내가 가봤던 도시중에 가장 저렴했던 곳을 기억한다.
        //3. 모든 다음 구간은 그 가장 저렴한 가격으로 넣는 것으로 한다.
        long minCityOil = cityOil[0]; // 가장 저렴한 도시의 가격
        long answer = 0;
        for(int i = 0; i < n-1; i++) {
            if(minCityOil > cityOil[i]) {
                minCityOil = cityOil[i];
            }
            answer += minCityOil * road[i];

        }
        System.out.println(answer);

    }
}
