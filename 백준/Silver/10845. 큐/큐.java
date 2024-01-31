import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int size;
    static int[] queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        queue = new int[N];
        size = 0;

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    static void push(int item){
        queue[size] = item;
        size++;
    }

    static int pop(){
        if(size == 0){
            return -1;
        }

        int num = queue[0];

        for (int i = 0; i < size-1; i++) {
            queue[i] = queue[i+1];
        }

        size--;

        return num;
    }

    static int size(){
        return size;
    }

    static int empty(){
        if(size == 0){
            return 1;
        }

        return 0;
    }

    static int front(){
        if(size == 0){
            return -1;
        }

        return queue[0];
    }

    static int back(){
        if(size == 0){
            return -1;
        }

        return queue[size-1];
    }
}
