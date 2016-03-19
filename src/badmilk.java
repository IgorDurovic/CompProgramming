import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/13/15.
 */
public class badmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter pw = new PrintWriter("badmilk.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> milk = new ArrayList<Integer>();

        int N = Integer.parseInt(st.nextToken()) + 1,
                M = Integer.parseInt(st.nextToken()),
                D = Integer.parseInt(st.nextToken()),
                S = Integer.parseInt(st.nextToken());

        Person[] people = new Person[N];

        for(int i = 0; i < D; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()),
                    m = Integer.parseInt(st.nextToken()),
                    t = Integer.parseInt(st.nextToken());

            if(people[p] != null){
                people[p].drink.add(new Milk(m, t));
            }
            else{
                people[p] = new Person();
                people[p].drink.add(new Milk(m, t));
            }
        }

        for(int i = 1; i < N; i++){
            if(people[i] == null){
                people[i] = new Person();
            }
            Collections.sort(people[i].drink);
        }

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()),
                t = Integer.parseInt(st.nextToken());

        for(Milk j: people[p].drink){
            if(j.time >= t){
                break;
            }
            if(!milk.contains(j.type)){
                milk.add(j.type);
            }
        }

        for(int i = 1; i < S; i++){
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            for(int k = 0; k < milk.size(); k++) {
                Milk temp = new Milk(milk.get(k), 0);
                boolean b = false;
                for (Milk j : people[p].drink) {
                    if (j.time >= t) {
                        break;
                    }
                    if (temp.equals(j)) {
                        b = true;
                    }
                }

                if(!b){
                    milk.remove(new Integer(milk.get(k)));
                    k--;
                }
            }
        }

        int total = 0;
        for(int i = 1; i < N; i++){
            for(Milk j: people[i].drink){
                if(milk.contains(j.type)){
                    total++;
                    break;
                }
            }
        }

        pw.println(total);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static class Person{
        public ArrayList<Milk> drink;

        Person(){
            drink = new ArrayList<Milk>();
        }
    }

    public static class Milk implements Comparable<Milk>{
        public int type;
        public int time;

        Milk(int a, int b){
            type = a;
            time = b;
        }

        public int compareTo(Milk m){
            return this.time - m.time;
        }

        @Override
        public boolean equals(Object m){
            if(m instanceof Milk) {
                if (((Milk)m).type == this.type) {
                    return true;
                }
            }
            return false;
        }
    }
}
