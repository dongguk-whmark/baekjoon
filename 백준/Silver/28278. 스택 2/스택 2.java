// 백준 28278 스택 2. 자바 풀이
// 2024-03-16 03:46

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        size = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch (num){
                case 1:
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    sb.append(pop()).append('\n');
                    break;
                case 3:
                    sb.append(size()).append('\n');
                    break;
                case 4:
                    sb.append(isEmpty()).append('\n');
                    break;
                case 5:
                    sb.append(peek()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    static void push(int num){
        arr[size++] = num;
    }

    static int pop(){
        if(size == 0){
            return -1;
        }
        else{
            return arr[--size];
        }
    }

    static int size(){
        return size;
    }

    static int isEmpty(){
        if(size == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    static int peek(){
        if(size == 0){
            return -1;
        }
        else{
            return arr[size-1];
        }
    }
}
