// 백준 2805 나무 자르기. 자바 풀이
// 2024-03-09 01:09

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
        int[] arr = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int start = 0;
        int end = max;

        while(start < end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for(int val: arr){
                if(val > mid){
                    sum += val - mid;
                }
            }

            if(sum >= M){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }

        System.out.println(start - 1);
    }
}
