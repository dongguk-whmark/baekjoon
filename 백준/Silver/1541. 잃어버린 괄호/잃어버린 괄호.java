// 백준 1541 잃어버린 괄호. 자바 풀이
// 2024-03-07 22:31

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            int temp = 0;

            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");

            while(add.hasMoreTokens()){
                temp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }
            else{
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
