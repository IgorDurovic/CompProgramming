import java.io.*;
import java.util.*;

/**
 * Created by xen0phile on 7/29/15.
 */
class GOSSIPER {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N, M;
        HashMap<String, Integer> mp = new HashMap<String, Integer>();

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0){
                break;
            }

            mp.clear();

            for(int i = 0; i < N; i++){
                mp.put(br.readLine(), 1);
            }

            String a, b;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                a = st.nextToken();
                b = st.nextToken();
                mp.put(a, Math.max(mp.get(a), mp.get(b)) + 1);
                mp.put(b, mp.get(a));
            }

            Iterator<Integer> temp = mp.values().iterator();

            while(temp.hasNext()){
                if(temp.next() < N){
                    pw.println("NO");
                    break;
                }
            }
            if(!temp.hasNext()){
                pw.println("YES");
            }

            br.readLine();
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
