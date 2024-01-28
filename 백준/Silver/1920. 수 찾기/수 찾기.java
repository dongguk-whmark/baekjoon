import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] arr_2;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        arr_2 = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr_2[i] = Integer.parseInt(st.nextToken());
        }

        find_number();

        System.out.println(sb);
    }

    public static void find_number() {

        Arrays.sort(arr);

        for (int val : arr_2) {
            if (Arrays.binarySearch(arr, val) < 0) {
                sb.append(0).append('\n');
            } else if (Arrays.binarySearch(arr, val) >= 0) {
                sb.append(1).append('\n');
            }
        }
    }
}
