/*
ID: id.tesl1
LANG: JAVA
TASK: concom
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/23/15.
 */
class concom {

    public static Company[] companies;
    public static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("concom.in"));
        PrintWriter pw = new PrintWriter("concom.out");
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        companies = new Company[101];

        for(int a = 1; a <= N; a++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()),
                    j = Integer.parseInt(st.nextToken()),
                    p = Integer.parseInt(st.nextToken());

            if(companies[i] == null){
                companies[i] = new Company();
            }
            if(companies[j] == null){
                companies[j] = new Company();
            }

            if(p > 50){
                companies[i].own[j] = true;
            }
            companies[i].percentage[j] = p;
        }

        solve();

        for(int i = 0; i < 101; i++){
            if(companies[i] != null){
                for(int j = 0; j < 101; j++){
                    if(companies[i].own[j] && i != j){
                        pw.println(i + " " + j);
                    }
                }
            }
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void solve(){

        boolean b = true;
        while(b) {
            for (int i = 0; i < 101; i++) {
                if (companies[i] != null) {
                    b = flood(i);
                }
            }
        }
    }

    public static boolean flood(int a){
        boolean b = true;
        boolean c = false;
        int[] percentage = new int[101];
        for(int i = 0; i < 101; i++){
            percentage[i] = companies[a].percentage[i];
        }
        while(b){
            percentage = new int[101];
            for(int i = 0; i < 101; i++){
                percentage[i] = companies[a].percentage[i];
            }
            b = false;
            for(int i = 0; i < 101; i++){
                if(companies[a].own[i]){
                    for(int j = 0; j < 101; j++){
                        percentage[j] += companies[i].percentage[j];
                    }
                }
            }

            for(int i = 0; i < 101; i++){
                if(percentage[i] > 50 && !companies[a].own[i]){
                    b = true;
                    c = true;
                    companies[a].own[i] = true;
                }
            }
        }

        return c;
    }

    public static class Company{
        public int[] percentage;
        public boolean[] own;

        Company(){
            percentage = new int[101];
            own = new boolean[101];
        }
    }
}
