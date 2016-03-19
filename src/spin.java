/*
ID: id.tesl1
LANG: JAVA
TASK: spin
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xen0phile on 12/30/15.
 */
class spin {

    public static Wheel[] wheels;
    public static boolean[][] light;

    public static class Wheel{
        public int speed, cur;
        public ArrayList<Wedge> wedges;

        Wheel(int a){
            speed = a;
            cur = 0;
            wedges = new ArrayList<Wedge>();
        }
    }

    public static class Wedge{
        public int position, extent;

        Wedge(int a, int b){
            position = a;
            extent = b;
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(new FileReader("spin.in"));
        PrintWriter pw = new PrintWriter("spin.out");

        wheels = new Wheel[5];
        light = new boolean[5][360];

        for(int i = 0; i < 5; i++){
            int s = scn.nextInt();
            int w = scn.nextInt();
            wheels[i] = new Wheel(s);
            for(int j = 0; j < w; j++){
                int a = scn.nextInt();
                int e = scn.nextInt();
                wheels[i].wedges.add(new Wedge(a, e));
                if((a + e + 1) % 360 < a){
                    Arrays.fill(light[i], a, light[i].length, true);
                    Arrays.fill(light[i], 0, (a + e + 1) % 360, true);
                }
                else {
                    Arrays.fill(light[i], a, (a + e + 1) % 360, true);
                }
            }
        }

        int counter = 0;
        while(true){
            if(check()){
                System.out.println(counter);
                break;
            }
            counter++;
            turn();
            if(done()){
                counter = -1;
                break;
            }
        }

        if(counter >= 0){
            pw.println(counter);
        }
        else{
            pw.println("none");
        }

        pw.flush();
        pw.close();
        scn.close();
        System.exit(0);
    }

    public static void turn(){
        for(int i = 0; i < 5; i++){
            wheels[i].cur += wheels[i].speed;
            Arrays.fill(light[i], false);
            for(Wedge w: wheels[i].wedges){
                int a = (wheels[i].cur + w.position) % 360,
                        b = (wheels[i].cur + w.position + w.extent) % 360;
                if(a > b){
                    Arrays.fill(light[i], a, light[i].length, true);
                    Arrays.fill(light[i], 0, b + 1, true);
                }
                else{
                    Arrays.fill(light[i], a, b + 1, true);
                }
            }
        }
    }

    public static boolean check(){

        for(int i = 0; i < 360; i++){
            int j;
            for(j = 0; j < 5; j++){
                if(!light[j][i]) break;
            }
            if(j == 5) return true;
        }

        return false;
    }

    public static boolean done(){

        for(int i = 0; i < 5; i++){
            if(wheels[i].cur % 360 != 0){
                return false;
            }
        }

        return true;
    }

}
