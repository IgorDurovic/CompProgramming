import java.io.*;

/**
 * Created by xen0phile on 6/26/15.
 */
class ABSYS {
    public static void main(String[] args) throws IOException{
        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(scn.readLine());
        String exp[];
        int num[] = new int[2];
        int counter = 0;
        boolean b = false;
        boolean c = false;

        scn.readLine();

        for(int i = 0; i < T; i++){
            exp = scn.readLine().split(" ");
            for(int j = 0; j < 5; j += 2){
                if(!exp[j].contains("machula")){
                    num[counter] = Integer.parseInt(exp[j]);
                    counter++;
                }
                else if(j == 0){
                    b = true;
                }
                else if(j == 4){
                    c = true;
                }
            }

            if(b){
                pw.println(num[1] - num[0] + " + " + exp[2] + " = " + exp[4]);
            }
            else if(c){
                pw.println(exp[0] + " + " + exp[2] + " = " + (num[1] + num[0]));
            }
            else{
                pw.println(exp[0] + " + " + (num[1] - num[0]) + " = " + exp[4]);
            }

            counter = 0;
            b = false;
            c = false;
            scn.readLine();

        }

        pw.flush();
        pw.close();
        scn.close();
        System.exit(0);
    }
}
