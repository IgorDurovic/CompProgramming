import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/30/15.
 */
class OFFSIDE {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int A, D, minA, minD, min2D;
        int temp;

        while(true){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            minA = 10000;
            minD = 10000;
            min2D = 10000;

            if(A == 0 && D == 0){
                break;
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < A; i++){
                temp = Integer.parseInt(st.nextToken());
                if(temp < minA){
                    minA = temp;
                }
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < D; i++){
                temp = Integer.parseInt(st.nextToken());
                if(temp < minD){
                    min2D = minD;
                    minD = temp;
                }
                else if(temp < min2D){
                    min2D = temp;
                }
            }

            if(minA < min2D){
                pw.println("Y");
            }
            else{
                pw.println("N");
            }
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
