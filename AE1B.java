import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/29/15.
 */
class AE1B {

    static int[] friends;
    static int more;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()),
                k = Integer.parseInt(st.nextToken()),
                s = Integer.parseInt(st.nextToken());
        more = k * s;

        String[] holder;

        holder = br.readLine().split(" ");
        friends = new int[holder.length];
        for (int j = 0; j < friends.length; j++) {
            friends[j] = Integer.parseInt(holder[j]);
        }
        pw.println(min() + "\n");

        pw.flush();
        pw.close();
        br.close();
    }

    public static int min(){

        int total = 0;

        Arrays.sort(friends);
        for(int i = friends.length - 1; i >= 0; i--){
            total += friends[i];
            if(total >= more){
                return friends.length - i;
            }
        }
        return -1;
    }

}
