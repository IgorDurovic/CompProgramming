import java.util.Scanner;

/**
 * Created by xen0phile on 6/25/15.
 */
class MIRRORED {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String in = scn.nextLine();

        System.out.println("Ready");

        while(!in.equals("  ")){
            if(m(in)){
                System.out.println("Mirrored pair");
            }
            else{
                System.out.println("Ordinary pair");
            }
            if(!scn.hasNextLine()){
                break;
            }
            in = scn.nextLine();
        }

        scn.close();
        System.exit(0);
    }

    public static boolean m(String in){

        if(in.equals("pq")){
            return true;
        }
        if(in.equals("qp")){
            return true;
        }
        if(in.equals("db")){
            return true;
        }
        if(in.equals("bd")){
            return true;
        }

        return false;
    }

}
