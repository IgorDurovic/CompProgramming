/*
ID: id.tesl1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

/**
 * Created by xen0phile on 11/10/15.
 */
class milk2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter pw = new PrintWriter("milk2.out");
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()), A = 0, B = 0;
        ArrayList<CowTime> ct = new ArrayList<CowTime>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            ct.add(new CowTime(s, e));
        }

        Collections.sort(ct);

        for(int i = 0; i < ct.size() - 1; i++){
            if(ct.get(i).end >= ct.get(i + 1).start){
                ct.get(i).end = Math.max(ct.get(i).end, ct.get(i+1).end);
                ct.remove(i + 1);
                i--;
            }
        }

        for(int i = 0; i < ct.size(); i++){
            if(ct.get(i).end - ct.get(i).start > A){
                A = ct.get(i).end - ct.get(i).start;
            }

            if(i < ct.size() - 1 && ct.get(i + 1).start - ct.get(i).end > B){
                B = ct.get(i + 1).start - ct.get(i).end;
            }
        }

        pw.println(A + " " + B);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static class CowTime implements Comparable<CowTime>{
        public int start;
        public int end;

        CowTime(int a, int b){
            start = a;
            end = b;
        }

        public int compareTo(CowTime ct){
            return this.start - ct.start;
        }
    }
}
