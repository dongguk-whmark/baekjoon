import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
                else if (map[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        }
        map[x][y] = 0;
        bfs(x,y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    map[i][j] = -1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y){
        visited[x][y] = true;
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        map[nx][ny] = map[cur[0]][cur[1]] + 1;
                        q.add(new int[] {nx,ny});
                    }
                }
            }
        }

    }
}
