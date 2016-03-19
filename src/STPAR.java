import java.io.*;
import java.util.*;

/**
 * Created by xen0phile on 7/30/15.
 */
class STPAR {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        LinkedList<Integer> parade = new LinkedList<Integer>();
        Stack<Integer> side = new Stack<Integer>();
        int n, current;

        while(true){
            n = Integer.parseInt(br.readLine());
            parade.clear();
            side.clear();
            current = 1;
            if(n == 0){
                break;
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                parade.addLast(Integer.parseInt(st.nextToken()));
            }

            ListIterator<Integer> it = parade.listIterator();
            int t;
            while(it.hasNext()){
                t = it.next();
                if(t != current){
                    if(!side.isEmpty() && side.peek() == current){
                        it.previous();
                        it.add(side.pop());
                        current++;
                    }
                    else {
                        it.remove();
                        side.push(t);
                    }
                }
                else{
                    current++;
                }
            }

            while(!side.isEmpty()){
                parade.add(side.pop());
            }

            Object[] temp = parade.toArray();

            int j;
            for(j = 0; j < temp.length - 1; j++){
                if((int)temp[j] > (int)temp[j+1]){
                    pw.println("no");
                    break;
                }
            }
            if(j == temp.length - 1){
                pw.println("yes");
            }
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
