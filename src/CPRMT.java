import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by xen0phile on 8/4/15.
 */
class CPRMT {
    public static void main(String[] args) throws IOException{
        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        char[] a, b;
        ArrayList<Character> per = new ArrayList<Character>();
        String temp;

        while(true){
            temp = scn.readLine();
            if(temp == null){
                break;
            }
            a = temp.toCharArray();
            b = scn.readLine().toCharArray();
            per.clear();

            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < b.length; j++){
                    if(a[i] == b[j]){
                        per.add(a[i]);
                        a[i] = 0;
                        b[j] = 0;
                        break;
                    }
                }
            }

            Collections.sort(per);

            for(int i = 0; i < per.size(); i++){
                pw.print(per.get(i));
            }

            pw.println();
        }

        pw.flush();
        pw.close();
        scn.close();
    }
}
