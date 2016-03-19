import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 8/1/15.
 */
class ARITH2 {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(rd.readLine());
        long temp, total;
        StringTokenizer holder, op;
        String s;

        for(int i = 0; i < t; i++){
            rd.readLine();
            s = rd.readLine();
            holder = new StringTokenizer(s, "+-*//= ");
            total = Long.parseLong(holder.nextToken().trim());
            op = new StringTokenizer(s, "0123456789 ");
            while(holder.hasMoreTokens()){
                temp = Long.parseLong(holder.nextToken().trim());
                switch(op.nextToken().trim().charAt(0)){
                    case '+':
                        total += temp;
                        break;
                    case '-':
                        total -= temp;
                        break;
                    case '*':
                        total *= temp;
                        break;
                    case '/':
                        total /= temp;
                        break;
                }
            }

            pw.println(total);
        }

        pw.flush();
        pw.close();
        rd.close();
    }

}
