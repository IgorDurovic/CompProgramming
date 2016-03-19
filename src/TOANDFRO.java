import java.util.Scanner;

/**
 * Created by xen0phile on 6/24/15.
 */
class TOANDFRO {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int columns = scn.nextInt();
        String input = scn.next();
        String[] message = new String[input.length()/columns];
        StringBuilder temp;

        while(true){
            for(int i = 0; i < message.length; i++){
                temp = new StringBuilder(input.substring(i*columns, i*columns + columns));
                if(i % 2 != 0){
                    temp.reverse();
                }
                message[i] = temp.toString();
            }
            for(int i = 0; i < columns; i++){
                for(int j = 0; j < message.length; j++){
                    System.out.print(message[j].substring(i, i+1));
                }
            }

            System.out.println();

            columns = scn.nextInt();
            if(columns == 0){
                break;
            }
            input = scn.next();
            message = new String[input.length()/columns];
        }

        scn.close();
        System.exit(0);
    }
}
