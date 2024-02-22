import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] visit;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int num){
        visit[num] = true;
        for (int i = 1; i <= N; i++) {
            if(!visit[i] && arr[num][i] == 1){
                dfs(i);
            }
        }
    }
}
