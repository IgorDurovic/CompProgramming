import java.util.Scanner;

/**
 * Created by xen0phile on 6/25/15.
 */
class JAVAC {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String holder;

        while(scn.hasNext()){

            holder = scn.next();

            if(isJava(holder)){
                System.out.println(toCpp(holder));
            }
            else if(isCpp(holder)){
                System.out.println(toJava(holder));
            }
            else{
                System.out.println("Error!");
            }
        }

        scn.close();
        System.exit(0);
    }

    public static boolean isJava(String in){

        if(Character.isUpperCase(in.charAt(0))){
            return false;
        }

        for(int i = 0; i < in.length(); i++){
            if(in.charAt(i) == '_'){
                return false;
            }
        }

        return true;
    }

    public static boolean isCpp(String in){

        if(in.charAt(0) == '_' || in.charAt(in.length() - 1) == '_'){
            return false;
        }

        for(int i = 0; i < in.length(); i++){
            if(in.charAt(i) < 91){
                return false;
            }
            if(in.charAt(i) == '_' && in.charAt(i+1) =='_'){
                return false;
            }
        }

        return true;
    }

    public static String toJava(String con){

        StringBuilder sb = new StringBuilder(con);
        char temp;

        for(int i = 0; i < sb.length(); i++){
            temp = sb.charAt(i);
            if(temp == '_'){
                temp = sb.charAt(i+1);
                sb.delete(i, i+2);

                sb.insert(i, Character.toUpperCase(temp));
            }
        }

        return sb.toString();
    }

    public static String toCpp(String con){

        StringBuilder sb = new StringBuilder(con);
        char temp;

        for(int i = 0; i < sb.length(); i++){
            temp = sb.charAt(i);
            if(Character.isUpperCase(temp)){
                sb.insert(i, '_');
                sb.setCharAt(i+1, Character.toLowerCase(temp));
            }
        }

        return sb.toString();
    }

}
