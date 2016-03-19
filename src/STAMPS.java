import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by xen0phile on 7/19/15.
 */
class STAMPS {

    static int[] friends;
    static int more;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] holder;

        for(int i = 1; i <= n; i++){
            more = Integer.parseInt(br.readLine().split(" ")[0]);
            holder = br.readLine().split(" ");
            friends = new int[holder.length];
            for(int j = 0; j < friends.length; j++){
                friends[j] = Integer.parseInt(holder[j]);
            }
            System.out.println("Scenario #" + i + ":");
            int temp = min();
            if(temp == -1){
                System.out.println("impossible");
            }
            else{
                System.out.println(min() + "\n");
            }
        }
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
