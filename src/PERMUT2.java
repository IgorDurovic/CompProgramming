import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PERMUT2 {

    static int n;
    static BufferedReader br;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            n = Integer.parseInt(br.readLine());

            if(n == 0){
                break;
            }

            if(isAmbiguous()){
                System.out.println("ambiguous");
            }
            else{
                System.out.println("not ambiguous");
            }
        }
    }

    public static boolean isAmbiguous() throws IOException{

        String[] line = br.readLine().split(" ");
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        for(int i = 1; i <= n; i++){
            if(nums[nums[i - 1] - 1] != i){
                return false;
            }
        }

        return true;
    }
}
