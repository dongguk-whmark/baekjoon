// 백준 7576 토마토. 자바 풀이
// 2024-03-02 01:25

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] box;
    static boolean[][] visited;
    static int N,M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 1){
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 이미 익은 토마토로 꽉 차있는 경우 = 큐의 사이즈가 박스 크기와 같을 때
        if(q.size() == N * M){
            System.out.println(0);
        }
        else {
            bfs();

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[i][j] == 0) {
                        result = -1;
                        break;
                    }
                    result = Math.max(result, box[i][j] - 1);
                }
                if (result == -1) break;
            }

            System.out.println(result);
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(!visited[nx][ny] && box[nx][ny] == 0){
                        visited[nx][ny] = true;
                        box[nx][ny] = box[cur[0]][cur[1]] + 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
