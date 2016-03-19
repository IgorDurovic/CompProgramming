import java.util.Scanner;

class LASTDIG2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        while(--T >= 0){
            String first = scn.next();
            int a = first.charAt(first.length()-1) - '0';
            long b = scn.nextLong();
            if (b == 0)
                System.out.println(1);
            else {
                b %= 4;
                if (b == 0)
                    b = 4;
                System.out.println(((int) Math.pow(a, b)) % 10);
            }
        }
    }
}
