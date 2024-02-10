// 2024-02-10
// 카운팅 정렬을 이용한 통계학(백준 2108번) 문제풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 테스트 케이스 범위 -4,000 ~ 4,000, 카운팅 정렬을 위한 배열
        int[] arr = new int[8001];

        // 반올림을 위해 double로 선언
        double sum = 0;

        // 최대값 비교를 위해 max는 정수형 최소값, 최소값 비교를 위해 min은 정수형 최대값 초기화
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 중앙값, 최빈값 초기화
        int median = 0;
        int mode = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            // 입력되는 값에 해당하는 인덱스에 빈도수 저장
            arr[value+4000]++;

            // 평균 계산을 위해 합 계산
            sum += value;

            /*
            일반 정렬을 사용한다면 arr[arr.length - 1] - arr[0]을 출력하면 간단하겠지만,
            효율을 위해 카운팅 정렬을 사용하기 때문에 최대값과 최소값을 비교하여 범위 출력
             */
            if(max < value){
                max = value;
            }

            if(min > value){
                min = value;
            }
        }

        // 중앙값 찾기 위해 원소 개수 count
        int count = 0;

        // 최빈값 중 빈도수 최대값
        int max_mode = 0;

        // 최빈값이 등장했는 지 체크하기 위한 flag값
        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {

            // 카운팅 배열에 해당하는 원소가 한 번이라도 등장했을 경우(빈도수가 1 이상일 경우)
            if(arr[i] > 0){

                // 원소 개수가 절반에 미치지 못했을 때
                if(count < (N+1) / 2){
                    // 빈도수만큼 원소 개수 카운트
                    count += arr[i];
                    // 절반에 도달하는 순간 해당 인덱스 = 중앙값
                    median = i - 4000;
                }

                // 이전 최빈값 빈도수 < 현재 값 빈도수
                if(max_mode < arr[i]){
                    max_mode = arr[i];
                    mode = i - 4000;
                    flag = true; // 처음으로 등장했음을 알림
                }
                
                /* 이전 최빈값 중 빈도수 최대값과 동일 && 최빈값 이미 한 번 등장했을 경우
                    카운팅 정렬을 통해 작은 수부터 정렬하기 때문에 '두 번째로 작은 수'를 출력하기 위함
                 */
                else if(max_mode == arr[i] && flag == true){
                    mode = i - 4000;
                    flag = false; // 최빈값이 또 나오더라도 두 번째로 작은 수가 변경되지 않게 하기 위해 false로 변경
                }
            }
        }

        System.out.println((int)Math.round(sum / N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
    }
}
