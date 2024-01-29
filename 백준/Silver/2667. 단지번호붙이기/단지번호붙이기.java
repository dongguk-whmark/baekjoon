import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static int count;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visit;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        arr = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visit[i][j]){
                    count = 1;
                    dfs(i,j);
                    cnt++;
                    q.add(count);
                }
            }
        }

        int[] result = new int[cnt];

        for (int i = 0; i < result.length; i++) {
            result[i] = q.remove();
        }
        Arrays.sort(result);

        sb.append(cnt).append('\n');
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);

    }

    static void dfs(int x, int y){
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(!visit[nx][ny] && arr[nx][ny] == 1){
                    count++;
                    dfs(nx, ny);
                }
            }
        }
    }
}
