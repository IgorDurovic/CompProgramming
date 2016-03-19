import java.io.*;

/**
 * Created by xen0phile on 7/24/15.
 */
class RLM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        StringBuilder sb;

        String holder;
        String[] exp;
        long op1;
        long op2;
        long answer = 0;

        while(true){
            holder = br.readLine();
            if(holder == null || holder.length() == 0){
                break;
            }

            exp = holder.split(" ");

            int counter;
            sb = new StringBuilder("");
            for(int i = 0; i < exp[0].length(); i += 2){
                counter = Integer.parseInt(exp[0].substring(i, i + 1));
                for(int j = 0; j < counter; j++){
                    sb.append(exp[0].substring(i + 1, i + 2));
                }
            }

            op1 = Long.parseLong(sb.toString());

            sb = new StringBuilder("");
            for(int i = 0; i < exp[2].length(); i += 2){
                counter = Integer.parseInt(exp[2].substring(i, i + 1));
                for(int j = 0; j < counter; j++){
                    sb.append(exp[2].substring(i + 1, i + 2));
                }
            }

            op2 = Long.parseLong(sb.toString());

            switch (exp[1]){
                case "+":
                    answer = op1 + op2;
                    break;
                case "-":
                    answer = op1 - op2;
                    break;
                case "*":
                    answer = op1 * op2;
                    break;
                case "/":
                    answer = op1 / op2;
                    break;
            }

            for(int i = 0; i < exp.length; i++){
                System.out.print(exp[i] + " ");
            }
            System.out.println("= " + toRunlength(answer));

        }

        br.close();
        pw.flush();
    }

    public static String toRunlength(long n){

        StringBuilder s = new StringBuilder("");
        String temp = "" + n;
        char current = temp.charAt(0);
        int counter = 1;
        for(int i = 1; i < temp.length(); i++){
            if(temp.charAt(i) == current){
                counter++;
                if(counter > 9){
                    s.append("9" + temp.charAt(i));
                    counter = 1;
                }
            }
            else{
                s.append(counter);
                s.append(current);
                current = temp.charAt(i);
                counter = 1;
            }
        }
        s.append(counter);
        s.append(current);

        return s.toString();
    }

}
