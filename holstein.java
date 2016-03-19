/*
ID: id.tesl1
LANG: JAVA
TASK: holstein
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class holstein {

    public static int[][] scoop;
    public static int[] vit, curSet, curSetFinal;
    public static int min;

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new FileReader("holstein.in"));
       PrintWriter pw = new PrintWriter("holstein.out");

       int V = Integer.parseInt(br.readLine());
       vit = new int[V];
       ArrayList<Integer> order = new ArrayList<Integer>();

       StringTokenizer st = new StringTokenizer(br.readLine());

       for(int i = 0; i < V; i++){
           vit[i] = Integer.parseInt(st.nextToken());
       }

       int G = Integer .parseInt(br.readLine());
       scoop = new int[G][V];

       for(int i = 0; i < G; i++){
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j < V; j++){
               scoop[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       curSet = new int[G];
       curSetFinal = new int[1];
       min = Integer.MAX_VALUE;
       solve(0, 0);

       pw.print(min);
       for(int i = 0; i < min; i++){
           pw.print(" " + (curSetFinal[i] + 1));
       }
       pw.println();

       pw.flush();
       pw.close();
       br.close();
       System.exit(0);
   }

    public static boolean solve(int num, int cur){

        //System.out.println(num + " " + min);

        if(num >= min){
            return false;
        }

        int i;
        for(i = 0; i < vit.length; i++){
            int max = vit[i];
            for(int j = 0; j < num; j++){
                max -= scoop[curSet[j]][i];
            }

            if(max > 0){
                break;
            }
        }

        if(i == vit.length){
            min = num;
            curSetFinal = new int[min];
            for(int j = 0; j < num; j++){
                curSetFinal[j] = curSet[j];
            }
            return true;
        }

        for(int j = cur; j < scoop.length; j++){
            curSet[num] = j;
            solve(num + 1, j + 1);
        }

        return false;
    }

}
