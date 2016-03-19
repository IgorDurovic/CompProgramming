import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by xen0phile on 8/3/15.
 */
class EXPRESS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        char[] exp;
        String temp;

        for(int i = 0; i < T; i++){
            exp = br.readLine().toCharArray();
            temp = postToReg(exp);
            pw.println(RegToPre(temp));
        }

        pw.flush();
        pw.close();
        br.close();
    }

    public static String postToReg(char[] c){
        Stack<String> exp = new Stack<String>();
        String temp, temp1, temp2;

        for(int i = 0; i < c.length; i++){
            if(c[i] > 90){
                exp.push("" + c[i]);
            }
            else{
                temp2 = exp.pop();
                temp1 = exp.pop();
                temp = "((" + temp1 + ")" + c[i] + "(" + temp2 + "))";
                exp.push(temp);
            }
        }

        temp = exp.pop();
        return temp;
    }

    public static String preToReg(char[] c){
        ArrayList<String> q = new ArrayList<String>();
        String temp, temp1, temp2;

        for(int i = 0; i < c.length; i++){
            if(c[i] > 90){
                q.add("" + c[i]);
            }
            else{
                temp2 = q.remove(0);
                temp1 = q.remove(0);
                temp = "((" + temp1 + ")" + c[i] + "(" + temp2 + "))";
                System.out.println(temp);
                q.add(temp);
            }
        }

        temp = q.remove(0);
        return temp;
    }

    public static String RegToPre(String s){

        Stack<String> st = new Stack<String>();
        ArrayList<char[]> q = new ArrayList<char[]>();
        q.add(s.toCharArray());
        int counter;
        char[] temp = q.remove(0);

        while(true) {

            if(q.isEmpty() && temp == null){
                break;
            }
            counter = 0;

            if(temp.length != 1) {
                for (int i = 1; i < temp.length - 1; i++) {

                    if (temp[i] == '(') {
                        counter++;
                    } else if (temp[i] == ')') {
                        counter--;
                    } else {
                        if (counter == 0) {
                            st.push("" + temp[i]);
                            if (temp.length > 1) {
                                q.add(Arrays.copyOfRange(temp, 2, i - 1));
                                q.add(Arrays.copyOfRange(temp, i + 2, temp.length - 2));
                            } else {
                                if (q.isEmpty()) {
                                    temp = null;
                                    break;
                                }
                            }

                            temp = q.remove(0);

                            break;
                        }
                    }

                }
            }
            else{
                st.push(temp[0] + "");
                if(q.isEmpty())
                    break;
                temp = q.remove(0);
            }

        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }
}