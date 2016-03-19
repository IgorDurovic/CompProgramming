/*
ID: id.tesl1
LANG: JAVA
TASK: wormhole
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class wormhole {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
      PrintWriter pw = new PrintWriter("wormhole.out");
      StringTokenizer st;

      Point[] holes;
      int N = Integer.parseInt(br.readLine().trim());
      holes = new Point[N];

      for(int i = 0; i < N; i++){
         st = new StringTokenizer(br.readLine().trim());
         holes[i] = new Point(Integer.parseInt(st.nextToken()),
                 Integer.parseInt(st.nextToken()));
      }

      Arrays.sort(holes);

      for(int i = 0; i < N; i++){
         if(holes[i].next == -1) {
            for (int j = i + 1; j < N; j++) {
               if(holes[i].y == holes[j].y){
                  holes[i].next = j;
                  break;
               }
            }
         }
      }

      pw.println(solve(holes, 0, 0));

      pw.flush();
      pw.close();
      br.close();
      System.exit(0);
   }

   public static int solve(Point[] holes, int a, int b){

      int i, total = 0;
      for(i = 0; i < holes.length && holes[i].isLinked; i++);

      if(i == holes.length){
         if(loop(holes)){
            holes[a].isLinked = false;
            holes[b].isLinked = false;
            return 1;
         }
         else{
            holes[a].isLinked = false;
            holes[b].isLinked = false;
            return 0;
         }
      }

      for(int j = i + 1; j < holes.length; j++){
         if(!holes[j].isLinked) {
            holes[j].link = i;
            holes[j].isLinked = true;
            holes[i].link = j;
            holes[i].isLinked = true;
            total += solve(holes, i, j);
            holes[j].isLinked = false;
            holes[i].isLinked = false;
         }
      }

      return total;
   }

   public static boolean loop(Point[] holes){

      Point cur;

      for(int i = 0; i < holes.length; i++){
         cur = holes[holes[i].link];
         int j;
         for(j = 0; j < holes.length; j++){
            if(cur.next == -1){
               break;
            }

            cur = holes[holes[cur.next].link];
         }

         if(j == holes.length){
            return true;
         }
      }

      return false;
   }

   public static class Point implements Comparable<Point>{
      public int x;
      public int y;
      public int link;
      public int next;
      public boolean isLinked;

      Point(int a, int b){
         x = a;
         y = b;
         isLinked = false;
         next = -1;
      }

      public int compareTo(Point p){
         return this.x - p.x;
      }

   }

}

// 1 2 3 7 8
// 6
