/*
ID: id.tesl1
LANG: JAVA
TASK: lamps
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 10/31/15.
 */
class lamps {

    public static BufferedReader br;
    public static PrintWriter pw;
    public static int N, C;
    public static ArrayList<Integer> on, off;
    public static boolean[] lights;
    public static ArrayList<String> solutions = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new FileReader("lamps.in"));
        pw = new PrintWriter("lamps.out");

        N = Integer.parseInt(br.readLine());
        lights = new boolean[N + 1];
        C = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        on = new ArrayList<Integer>();
        while(st.hasMoreTokens()){
            on.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        off = new ArrayList<Integer>();
        while(st.hasMoreTokens()){
            off.add(Integer.parseInt(st.nextToken()));
        }

        sol();

        Object[] finTemp = solutions.toArray();
        String[] fin = new String[finTemp.length];

        for(int i = 0; i < finTemp.length; i++){
            fin[i] = (String)finTemp[i];
        }

        Arrays.sort(fin);
        for(String s: fin){
            pw.println(s);
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void sol(){

        Arrays.fill(lights, true);
        if(C == 0){
            if(off.size() == 1) {
                printLamps(lights);
            }
            else{
                pw.println("IMPOSSIBLE");
            }
            return;
        }

        boolean[] temp = xor(Arrays.copyOf(lights, lights.length));
        if(check(temp)){
            printLamps(temp);
        }

        if(C > 1) {
            temp = three(temp);
            if (check(temp)) {
                printLamps(temp);
            }
        }

        temp = and(Arrays.copyOf(lights, lights.length));
        if(check(temp)){
            printLamps(temp);
        }

        if(C > 1) {
            temp = three(temp);
            if (check(temp)) {
                printLamps(temp);
            }
        }

        temp = or(Arrays.copyOf(lights, lights.length));
        if(check(temp)){
            printLamps(temp);
        }

        if(C > 1) {
            temp = three(temp);
            if (check(temp)) {
                printLamps(temp);
            }
        }

        temp = three(Arrays.copyOf(lights, lights.length));
        if(check(temp)){
            printLamps(temp);
        }

        if(C > 1){
            if(check(lights)){
                printLamps(lights);
            }
        }

        if(solutions.isEmpty()){
            pw.println("IMPOSSIBLE");
        }
    }

    public static boolean[] and(boolean[] bin){

        for(int i = 1; i < bin.length; i += 2){
            bin[i] = !bin[i];
        }

        return bin;
    }

    public static boolean[] or(boolean[] bin){

        for(int i = 2; i < bin.length; i += 2){
            bin[i] = !bin[i];
        }

        return bin;
    }

    public static boolean[] xor(boolean[] bin){

        for(int i = 1; i < bin.length; i++){
            bin[i] = !bin[i];
        }

        return bin;
    }

    public static boolean[] three(boolean[] bin){

        for(int i = 1; i < bin.length; i += 3){
            bin[i] = !bin[i];
        }

        return bin;
    }

    public static void printLamps(boolean[] bin){

        char[] temp = new char[bin.length - 1];

        for(int i = 1; i < bin.length; i++){
            boolean b = bin[i];

            if(b) temp[i - 1] = '1';
            else temp[i - 1] = '0';
        }

        solutions.add(new String(temp));

    }

    public static boolean check(boolean[] bin){

        for(int i: on){
            if(i >= 0 && !bin[i]){
                return false;
            }
        }

        for(int i: off){
            if(i >= 0 && bin[i]){
                return false;
            }
        }

        return true;
    }

}