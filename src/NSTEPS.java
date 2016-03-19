import java.util.Scanner;

class NSTEPS {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();
        int x;
        int y;

        for(int i = 0; i < N; i++){
            x = scn.nextInt();
            y = scn.nextInt();
            if(x == y){
                if(x % 2 == 0){
                    System.out.println(x * 2);
                }
                else{
                    System.out.println(x * 2 -1);
                }
            }
            else if(x - 2 == y){
                if(x % 2 == 0){
                    System.out.println(x + y);
                }
                else{
                    System.out.println(x + y -1);
                }
            }
            else{
                System.out.println("No Number");
            }
        }

        scn.close();
        System.exit(0);
    }
}
