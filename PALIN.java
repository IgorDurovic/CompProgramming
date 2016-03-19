import java.io.IOException;
import java.util.Scanner;

/**
 * Created by xen0phile on 6/10/15.
 */
class PALIN {
    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(System.in);
        int lineNum = Integer.parseInt(scn.nextLine());

        String num;
        String holder;
        int length = 0;

        for(int i = 0; i < lineNum; i++){
            holder = scn.nextLine();
            num = addOne(holder, holder.length() - 1);
            holder = num;
            length = num.length();

            if(isPalindrome(num)){
                System.out.println(num);
            }
            else {
                if (length % 2 == 0) {
                    num = num.substring(0, length / 2) + reverse(num.substring(0, length / 2));
                } else {
                    num = num.substring(0, length / 2) + num.charAt(length / 2) + reverse(num.substring(0, length / 2));
                }
                if (num.compareTo(holder) > 0) {
                    System.out.println(num);
                } else {
                    if (length% 2 == 0) {
                        int a = Integer.parseInt(num.substring(length / 2 - 1, length / 2));
                        int b = Integer.parseInt(num.substring(length / 2, length / 2 + 1));
                        if (a <= b) {
                            num = addOne(num, length / 2 - 1);
                        }
                        System.out.println(num.substring(0, length / 2) + reverse(num.substring(0, length / 2)));
                    } else {
                        num = addOne(num, length / 2);
                        System.out.println(num.substring(0, length / 2) + num.charAt(length / 2) + reverse(num.substring(0, length / 2)));
                    }
                }
            }
        }
        scn.close();
        System.exit(0);
    }

    public static String addOne(String s, int index){
        int temp = index;
        char digit = s.charAt(index);
        StringBuilder sb = new StringBuilder();
        while(digit == '9') {
            if (index == 0) {
                break;
            }
            sb.append(0);
            index--;
            digit = s.charAt(index);
        }
        s = s.substring(0, index) + (Character.getNumericValue(digit) + 1) + sb.toString() + s.substring(temp+1);
        return s;
    }

    public static boolean isPalindrome(String s){
        int length = s.length();
        for(int i = 0; i <= length/2; i++){
            if(s.charAt(i) != s.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

}
