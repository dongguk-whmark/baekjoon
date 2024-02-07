import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, M, person;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        person = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visit[i][j] && map[i][j] == 'I'){
                    dfs(i,j);
                }
            }
        }

        if(person == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(person);
        }
    }
    
    static void dfs(int x, int y){
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >=0 && nx < N && ny < M){
                if(!visit[nx][ny] && map[nx][ny] == 'O'){
                    dfs(nx,ny);
                }
                if(!visit[nx][ny] && map[nx][ny] == 'P'){
                    person++;
                    dfs(nx,ny);
                }
            }
        }
    }
}
