import java.io.*;

/**
 * Created by xen0phile on 7/30/15.
 */
class SPCS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int cur, counter;
        char[] temp;
        char[] pal;


        for(int i = 0; i < T; i++){
            temp = br.readLine().toCharArray();
            cur = 0;
            counter = 1;
            for(int j = 1; j < temp.length; j++){
                if(temp[j] == temp[cur]){
                    temp[j] = '*';
                }
                else{
                    cur = j;
                    counter++;
                }
            }

            pal = new char[counter];
            counter = 0;
            for(int j = 0; j < temp.length; j++){
                if(temp[j] != '*'){
                    pal[counter] = temp[j];
                    counter++;
                }
            }

            if(isPalin(pal)){
                pw.println("YES");
            }
            else{
                pw.println("NO");
            }
        }

        pw.flush();
        pw.close();
        br.close();
    }

    public static boolean isPalin(char[] s){

        for(int i = 0; i < s.length/2; i++){
            if(s[i] != s[s.length - 1 - i]){
                return false;
            }
        }

        return true;
    }

}
