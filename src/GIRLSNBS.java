import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/22/15.
 */
class GIRLSNBS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int G, B;

        while(true){
            st = new StringTokenizer(br.readLine());
            G = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if(G == -1){
                break;
            }

            if(G == B){
                if(G == 0){
                    System.out.println(0);
                }
                else {
                    System.out.println(1);
                }
            }
            else if(G > B){
                if(G % (B + 1) == 0){
                    System.out.println(G / (B + 1));
                }
                else{
                    System.out.println(G / (B + 1) + 1);
                }
            }
            else{
                if(B % (G + 1) == 0){
                    System.out.println(B / (G + 1));
                }
                else{
                    System.out.println(B / (G + 1) + 1);
                }
            }
        }

        br.close();
    }
}
