import java.util.Scanner;
class SIZECON {
    public static void main(String[] a){
        Scanner b=new Scanner(System.in);
        int t=b.nextInt();
        int N;
        int s=0;
        while(t-->0){
            N=b.nextInt();
            s+=N>0?N:0;
        }
        System.out.println(s);
    }
}
