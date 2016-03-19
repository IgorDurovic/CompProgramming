/*
ID: id.tesl1
LANG: JAVA
TASK: agrinet
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xen0phile on 12/26/15.
 */
class agrinet {

    public static int N;
    public static int[][] distance;
    public static int[] source, toTree;
    public static boolean[] intree;

    public static class Pair{
        public int index, value;

        Pair(int a, int b){
            index = a;
            value = b;
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner br = new Scanner(new FileReader("agrinet.in"));
        PrintWriter pw = new PrintWriter("agrinet.out");

        N = br.nextInt();
        distance = new int[N][N];
        intree = new boolean[N];
        source = new int[N];
        toTree = new int[N];
        Arrays.fill(toTree, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                distance[i][j] = br.nextInt();
            }
        }

        pw.println(prim());

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int prim(){

        intree[0] = true;
        toTree[0] = 0;
        int treeSize = 1, treeCost = 0;

        for(int i = 0; i < N; i++){
            source[i] = 0;
        }

        while(treeSize < N){
            Pair p = minDist();
            int i = p.index, cost = p.value;
            //System.out.println(i);
            if(i == -1){
                break;
            }
            intree[i] = true;
            treeSize++;
            treeCost += cost;

            for(int j = 0; j < N; j++){
                if(distance[i][j] < toTree[j]){
                    toTree[j] = distance[i][j];
                    source[j] = i;
                }
            }
        }

        return treeCost;
    }

    public static Pair minDist(){

        int min = Integer.MAX_VALUE, index = -1;
        for(int i = 0; i < N; i++){
            if(!intree[i]){
                for(int j = 0; j < N; j++){
                    if(intree[j] && distance[i][j] < min){
                       min = distance[i][j];
                        index = i;
                    }
                }
            }
        }

        return new Pair(index, min);
    }
}
