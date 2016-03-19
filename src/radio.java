import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 1/18/16.
 */
public class radio {

    public static int N, M, fx, fy, bx, by;
    public static char[] f, b;
    public static HashMap<Pair, Integer> memo = new HashMap<>();

    public static class Position{
        public int x, y, cur;
        public boolean farmer;

        Position(int a, int b, int c, boolean d){
            x = a;
            y = b;
            cur = c;
            farmer = d;
        }

        Position(Position p){
            x = p.x;
            y = p.y;
            cur = p.cur;
            farmer = p.farmer;
        }

        public boolean equals(Object o){
            if(o instanceof Position){
                return ((Position) o).x == this.x && ((Position) o).y == this.y;
            }

            return false;
        }

        public Position move(){

            Position p = new Position(this);

            char[] temp;
            if(p.farmer){
                temp = f;
            }
            else{
                temp = b;
            }

            if(p.cur == temp.length){
                return null;
            }

            switch(temp[p.cur]){
                case 'N':
                    p.y++;
                    break;
                case 'S':
                    p.y--;
                    break;
                case 'W':
                    p.x--;
                    break;
                case 'E':
                    p.x++;
                    break;
            }

            p.cur++;

            return p;
        }

    }

    public static class Pair{
        public Position p1, p2;

        Pair(Position a, Position b){
            p1 = a;
            p2 = b;
        }

        public boolean equals(Object o){
            if(o instanceof Pair){
                return ((Pair) o).p1.equals(this.p1) && ((Pair) o).p2.equals(this.p2);
            }

            return false;
        }

        public int hashCode(){

            return (p1.x + "," + p1.y + "," + p2.x + "," + p2.y).hashCode();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("radio.in"));
        PrintWriter pw = new PrintWriter("radio.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        fx = Integer.parseInt(st.nextToken());
        fy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        bx = Integer.parseInt(st.nextToken());
        by = Integer.parseInt(st.nextToken());

        f = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        pw.println(solve(new Position(fx, fy, 0, true), new Position(bx, by, 0, false))
                    - distance(fx, fy, bx, by));

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int solve(Position fp, Position bp){

        if(fp == null || bp == null){
            return Integer.MAX_VALUE;
        }

        if(memo.containsKey(new Pair(fp, bp))){
            //System.out.println("here: " + memo.get(new Pair(fp, bp)));
            return memo.get(new Pair(fp, bp));
        }

        int cost = distance(fp.x, fp.y, bp.x, bp.y);

        if(fp.cur == f.length && bp.cur == b.length){
            return cost;
        }

        int sol = Math.min(solve(fp.move(), bp),
                Math.min(solve(fp, bp.move()), solve(fp.move(), bp.move())));

        memo.put(new Pair(fp, bp), cost + sol);

        //System.out.println(sol);

        return cost + sol;
    }

    public static int distance(int x1, int y1, int x2, int y2){
        return (int)(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

}
