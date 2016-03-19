import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/13/15.
 */
class geteven {

    public static Stack<Integer> B = new Stack<Integer>();
    public static Stack<Integer> E = new Stack<Integer>();
    public static Stack<Integer> S = new Stack<Integer>();
    public static Stack<Integer> I = new Stack<Integer>();
    public static Stack<Integer> G = new Stack<Integer>();
    public static Stack<Integer> O = new Stack<Integer>();
    public static Stack<Integer> M = new Stack<Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken().charAt(0)){
                case 'B':
                    B.add(Integer.parseInt(st.nextToken()));
                    break;
                case 'E':
                    E.add(Integer.parseInt(st.nextToken()));
                    break;
                case 'S':
                    S.add(Integer.parseInt(st.nextToken()));
                    break;
                case 'I':
                    I.add(Integer.parseInt(st.nextToken()));
                    break;
                case 'G':
                    G.add(Integer.parseInt(st.nextToken()));
                    break;
                case 'O':
                    O.add(Integer.parseInt(st.nextToken()));
                    break;
                case 'M':
                    M.add(Integer.parseInt(st.nextToken()));
                    break;
            }
        }

        Object[][] holder = new Object[7][];

        for(int i = 0; i < holder.length; i++){
            holder[i] = B.toArray();
        }

    }

    public static int foil(int[] num){

        return (num[0] + num[1] + num[2] + num[2] + num[3] + num[1]) * (num[4] + num[5] + num[1] + num[2]) * (num[6] + num[5] + num[5]);
    }
}
