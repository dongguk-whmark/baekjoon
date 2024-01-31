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

        queue = new int[N+1];
        size = 0;

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
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

    static void push_front(int item){
        for (int i = size-1; i >= 0; i--) {
            queue[i+1] = queue[i];
        }

        queue[0] = item;
        size++;
    }

    static void push_back(int item){
        queue[size] = item;
        size++;
    }

    static int pop_front(){
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

    static int pop_back(){
        if(size == 0){
            return -1;
        }

        int num = queue[size-1];
        queue[size-1] = 0;
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
