import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[9][9];
        int max = -1;
        int max_x = 0;
        int max_y = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(max < num){
                    max = num;
                    max_x = i+1;
                    max_y = j+1;
                }
            }
        }

        sb.append(max).append('\n').append(max_x).append(' ').append(max_y);
        System.out.println(sb);
    }
}
