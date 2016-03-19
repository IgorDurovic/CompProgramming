/*
ID: id.tesl1
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

public class castle {

    public static Unit[][] castle;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("castle.in"));
        PrintWriter pw = new PrintWriter("castle.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()),
                N = Integer.parseInt(st.nextToken());

        castle = new Unit[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int val = Integer.parseInt(st.nextToken());
                Unit temp = new Unit();
                while(val != 0){
                     if(val >= 8){
                         temp.south = false;
                         val -= 8;
                     }
                     else if(val < 8 && val >= 4){
                         temp.east = false;
                         val -= 4;
                     }
                     else if(val < 4 && val >= 2){
                         temp.north = false;
                         val -= 2;
                     }
                     else{
                         temp.west = false;
                         val -= 1;
                     }
                }

                castle[i][j] = temp;
            }
        }

        int rooms = countRooms();
        pw.println(rooms);

        int[] roomSize = new int[rooms + 1];

        for(int i = 0; i < castle.length; i++){
            for(int j = 0; j < castle[i].length; j++){
                roomSize[castle[i][j].component]++;
            }
        }

        int max = 0;
        for(int i = 0; i <= rooms; i++){
            if(roomSize[i] > max){
                max = roomSize[i];
            }
        }

        pw.println(max);

        max = 0;
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        int direction = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(i > 0 && !castle[i][j].north && castle[i][j].component != castle[i - 1][j].component){
                    if(roomSize[castle[i][j].component] + roomSize[castle[i - 1][j].component] >= max){
                        if(roomSize[castle[i][j].component] + roomSize[castle[i - 1][j].component] == max){
                            if(j < y || j == y && i > x){
                                max = roomSize[castle[i][j].component] + roomSize[castle[i - 1][j].component];
                                x = i;
                                y = j;
                                direction = 0;
                            }
                        }
                        else {
                            max = roomSize[castle[i][j].component] + roomSize[castle[i - 1][j].component];
                            x = i;
                            y = j;
                            direction = 0;
                        }
                    }
                }
                if(i < N - 1 && !castle[i][j].south && castle[i][j].component != castle[i + 1][j].component){
                    if(roomSize[castle[i][j].component] + roomSize[castle[i + 1][j].component] >= max){
                        if(roomSize[castle[i][j].component] + roomSize[castle[i + 1][j].component] == max){
                            if(j < y || j == y && i > x){
                                max = roomSize[castle[i][j].component] + roomSize[castle[i + 1][j].component];
                                x = i;
                                y = j;
                                direction = 1;
                            }
                        }
                        else {
                            max = roomSize[castle[i][j].component] + roomSize[castle[i + 1][j].component];
                            x = i;
                            y = j;
                            direction = 1;
                        }
                    }
                }
                if(j < M - 1 && !castle[i][j].east && castle[i][j].component != castle[i][j + 1].component){
                    if(roomSize[castle[i][j].component] + roomSize[castle[i][j + 1].component] >= max){
                        if(roomSize[castle[i][j].component] + roomSize[castle[i][j + 1].component] == max){
                            if(j < y || j == y && i > x){
                                max = roomSize[castle[i][j].component] + roomSize[castle[i][j + 1].component];
                                x = i;
                                y = j;
                                direction = 2;
                            }
                        }
                        else {
                            max = roomSize[castle[i][j].component] + roomSize[castle[i][j + 1].component];
                            x = i;
                            y = j;
                            direction = 2;
                        }
                    }
                }
                if(j > 0 && !castle[i][j].west && castle[i][j].component != castle[i][j - 1].component){
                    if(roomSize[castle[i][j].component] + roomSize[castle[i][j - 1].component] >= max){
                        if(roomSize[castle[i][j].component] + roomSize[castle[i][j - 1].component] == max){
                            if(j < y || j == y && i > x){
                                max = roomSize[castle[i][j].component] + roomSize[castle[i][j - 1].component];
                                x = i;
                                y = j;
                                direction = 3;
                            }
                        }
                        else {
                            max = roomSize[castle[i][j].component] + roomSize[castle[i][j - 1].component];
                            x = i;
                            y = j;
                            direction = 3;
                        }
                    }
                }
            }
        }

        pw.println(max);


        x++;
        y++;

        switch (direction){
            case 0:
                pw.println(x + " " + y + " N");
                break;
            case 1:
                pw.println(x + " " + y + " S");
                break;
            case 2:
                pw.println(x + " " + y + " E");
                break;
            case 3:
                pw.println(x + " " + y + " W");
                break;
        }

        /*for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(castle[i][j].component + " ");
            }
            System.out.println();
        }*/

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int countRooms(){

        int counter = 0;
        for(int i = 0; i < castle.length; i++){
            for(int j = 0; j < castle[i].length; j++){
                if(!castle[i][j].visited){
                    counter++;
                    castle[i][j].visited = true;
                    flood(counter);
                }
            }
        }

        return counter;
    }

    public static void flood(int c){

        boolean b = true;

        while(b){
            b = false;
            for(int i = 0; i < castle.length; i++){
                for(int j = 0; j < castle[i].length; j++){
                    if(castle[i][j].visited && castle[i][j].component == -1){
                        castle[i][j].component = c;
                        b = true;
                        if(castle[i][j].north){
                            castle[i - 1][j].visited = true;
                        }
                        if(castle[i][j].south){
                            castle[i + 1][j].visited = true;
                        }
                        if(castle[i][j].east){
                            castle[i][j + 1].visited = true;
                        }
                        if(castle[i][j].west){
                            castle[i][j - 1].visited = true;
                        }
                    }
                }
            }
        }
    }

    public static class Unit {
        public boolean north, east, south, west, visited;
        public int component;

        Unit(){
            component = -1;
            north = true;
            south = true;
            east = true;
            west = true;
        }
    }

}
