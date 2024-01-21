import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Person[] per = new Person[N];

        for (int i = 0; i < N; i++) {
            per[i] = new Person(sc.nextInt(), sc.next());
        }

        Arrays.sort(per, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(per[i]);
        }

        System.out.println(sb);

    }

    public static class Person{
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        public String toString(){
            return age + " " + name + '\n';
        }
    }
}
