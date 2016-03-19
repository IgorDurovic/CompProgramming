/*
ID: id.tesl1
LANG: JAVA
TASK: ttwo
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xen0phile on 12/24/15.
 */
class ttwo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("ttwo.in"));
        PrintWriter pw = new PrintWriter("ttwo.out");

        int[][] grid = new int[10][10];
        Cow farmer = null, cow = null;

        for(int i = 0; i < 10; i++){
            char[] row = br.readLine().toCharArray();
            for(int j = 0; j < 10; j++){
                switch(row[j]){
                    case '*':
                        grid[i][j] = 1;
                        break;
                    case 'C':
                        cow = new Cow(i, j);
                        break;
                    case 'F':
                        farmer = new Cow(i, j);
                }
            }
        }

        int min;
        for(min = 1; min <= 160000; min++){
            switch (farmer.direction){
                case 1:
                    if(farmer.x == 0 || grid[farmer.x - 1][farmer.y] == 1){
                        farmer.rotate();
                    }
                    else{
                        farmer.x--;
                    }
                    break;
                case 2:
                    if(farmer.y == 9 || grid[farmer.x][farmer.y + 1] == 1){
                        farmer.rotate();
                    }
                    else{
                        farmer.y++;
                    }
                    break;
                case 3:
                    if(farmer.x == 9 || grid[farmer.x + 1][farmer.y] == 1){
                        farmer.rotate();
                    }
                    else{
                        farmer.x++;
                    }
                    break;
                case 4:
                    if(farmer.y == 0 || grid[farmer.x][farmer.y - 1] == 1){
                        farmer.rotate();
                    }
                    else{
                        farmer.y--;
                    }
                    break;
            }

            switch (cow.direction){
                case 1:
                    if(cow.x == 0 || grid[cow.x - 1][cow.y] == 1){
                        cow.rotate();
                    }
                    else{
                        cow.x--;
                    }
                    break;
                case 2:
                    if(cow.y == 9 || grid[cow.x][cow.y + 1] == 1){
                        cow.rotate();
                    }
                    else{
                        cow.y++;
                    }
                    break;
                case 3:
                    if(cow.x == 9 || grid[cow.x + 1][cow.y] == 1){
                        cow.rotate();
                    }
                    else{
                        cow.x++;
                    }
                    break;
                case 4:
                    if(cow.y == 0 || grid[cow.x][cow.y - 1] == 1){
                        cow.rotate();
                    }
                    else{
                        cow.y--;
                    }
                    break;
            }

            if(cow.x == farmer.x && cow.y == farmer.y){
                pw.println(min);
                break;
            }
        }

        if(min == 160001){
            pw.println(0);
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static class Cow{
        public int direction, x, y;

        Cow(int a, int b){
            x = a;
            y = b;
            direction = 1;
        }

        public void rotate(){
            this.direction++;
            if(this.direction == 5){
                this.direction = 1;
            }
        }
    }
}
