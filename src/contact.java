/*
ID: id.tesl1
LANG: JAVA
TASK: contact
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by xen0phile on 12/27/15.
 */
class contact {

    public static int A, B, N;
    public static String S;
    public static ArrayList<Unit> sol;

    public static class Unit implements Comparable<Unit>{
        public ArrayList<String> sub;
        public int freq;

        Unit(int a){
            freq = a;
            sub = new ArrayList<String>();
        }

        public int compareTo(Unit u){
            return this.freq - u.freq;
        }

        public boolean equals(Object o){
            if(o instanceof Unit){
                return this.freq == ((Unit) o).freq;
            }

            return false;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("contact.in"));
        PrintWriter pw = new PrintWriter("contact.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Integer> counter = new HashMap<String, Integer>();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        sol = new ArrayList<Unit>();

        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null){
            sb.append(line);
        }

        S = sb.toString();

        for(int i = A; i <= B; i++){
            for(int start = 0; start + i <= S.length(); start++){
                String temp = S.substring(start, start + i);
                //System.out.println(temp);
                if(!counter.containsKey(temp)){
                    counter.put(temp, 1);
                }
                else{
                    counter.put(temp, counter.get(temp) + 1);
                }
            }
        }

        Set<String> set = counter.keySet();
        for(String s: set){
            System.out.println(s);
            Unit u = new Unit(counter.get(s));
            if(sol.contains(u)){
                int index = sol.indexOf(u);
                sol.get(index).sub.add(s);
            }
            else{
                u.sub.add(s);
                sol.add(u);
            }
        }

        Collections.sort(sol);

        //System.out.println(sol.size());

        for(int i = 0; i < Math.min(N, sol.size()); i++){
            Unit u = sol.get(sol.size() - 1 - i);
            pw.println(u.freq);
            Collections.sort(u.sub, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    if (s.length() != t1.length()) {
                        return s.length() - t1.length();
                    }

                    return s.compareTo(t1);
                }
            });

            for(int j = 0; j < u.sub.size(); j++){
                if(j == 0){
                    pw.print(u.sub.get(0));
                }
                else if(j % 6 == 0){
                    pw.println();
                    pw.print(u.sub.get(j));
                }
                else{
                    pw.print(" " + u.sub.get(j));
                }
            }

            pw.println();
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
