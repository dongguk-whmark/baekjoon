import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visit;
    static int p_count, size, n, m;
    static int[][] paper;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p_count = 0;
        size = 0;
        int max = 0;

        visit = new boolean[n][m];
        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && paper[i][j] == 1){
                    size = 0;
                    dfs(i,j);
                    p_count++;
                    max = Math.max(max, size);
                }
            }
        }

        sb.append(p_count).append('\n').append(max);
        System.out.println(sb);
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >=0 && nx < n && ny < m){
                if(!visit[nx][ny] && paper[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }

    }
}
