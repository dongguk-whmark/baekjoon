import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] coord = new int[N][M];

        int max = 0;
        int min = 256;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                coord[i][j] = num;

                max = Math.max(max, num);
                min = Math.min(min, num); // 높이의 최대, 최소값
            }
        }
        
        int time = Integer.MAX_VALUE;
        int height = 0;

        for (int i = min; i <= max; i++) {
            int count = 0;

            // 바로 정수 B를 이용할 경우 초기화 x.
            int block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {

                    // 현재 높이보다 높은 블록을 깎아낼 때
                    if(i < coord[j][k]){

                        // 1블록당 2초 소요이므로 *2
                        count += (coord[j][k] - i) * 2;
                        block += coord[j][k] - i;
                    }

                    // 현재 높이보다 낮은 블록을 채울 때
                    else if(i > coord[j][k]){
                        count += i - coord[j][k];
                        block -= i - coord[j][k];
                    }
                }
            }

            // 블록 수가 음수일 경우 다음 경우의 수로 넘어감
            if(block < 0){
                break;
            }

            if(time >= count){
                time = count;
                height = i;
            }
        }

        System.out.println(time + " " + height);

    }
}
