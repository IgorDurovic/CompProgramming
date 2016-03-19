import java.io.*;

/**
 * Created by xen0phile on 7/29/15.
 */
class SYMN {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String[] temp = br.readLine().split(" ");

        int i;
        for(i = 0; i <= temp.length/2; i++){
            if(!temp[i].equals(temp[temp.length - 1 - i])){
                pw.println("No");
                break;
            }
        }
        if(i > temp.length/2){
            pw.println("Yes");
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
