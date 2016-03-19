import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by xen0phile on 7/22/15.
 */
class HYPNOS {

    static HashMap<Integer, Boolean> sol = new HashMap<Integer, Boolean>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        int counter = 0;
        String temp;
        N = Integer.parseInt(br.readLine());
        while(true){
            if(sol.get(N) != null && sol.get(N)){
                System.out.println("-1");
                break;
            }
            else if(N == 1){
                System.out.println(counter);
                break;
            }
            sol.put(N, true);
            temp = "" + N;
            N = 0;
            for(int j = 0; j < temp.length(); j++){
                N += Math.pow(Integer.parseInt(temp.substring(j, j + 1)), 2);
            }
            counter++;
        }

        br.close();
    }
}
