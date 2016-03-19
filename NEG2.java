import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xen0phile on 7/30/15.
 */
class NEG2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        Stack s = new Stack();

        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            pw.println(0);
        }
        else{
            boolean b = false;

            if(n < 0){
                n = -n;
                b = true;
            }

            while(n > 0){
                s.push(n & 1);
                if(b){
                    if(n == 1){
                        s.push(1);
                        break;
                    }
                    if((n & 1) == 1){
                        n++;
                    }
                }

                n >>= 1;
                b = !b;
            }

            while(!s.isEmpty()){
                pw.print(s.pop());
            }
        }

        pw.flush();
        pw.close();
        br.close();
    }

}
