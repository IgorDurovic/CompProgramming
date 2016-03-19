/**
 * Created by xen0phile on 11/11/15.
 */
class pascal {

    public static int[] holder;
    public static int[] holderTemp;

    public static void main(String[] args){

        int rows = 10000;

        holder = new int[1];
        holder[0] = 1;

        for(int i = 1; i < rows; i++){
            //print();
            holderTemp = new int[holder.length + 1];

            holderTemp[0] = 1;

            if(holder.length > 1){
                for(int j = 1; j < holder.length; j++){
                    holderTemp[j] = holder[j] + holder[j - 1];
                }
            }

            holderTemp[holder.length] = 1;
            holder = holderTemp;
        }

    }

    public static void print(){
        for(int i = 0; i < holder.length; i++){
            System.out.print(holder[i] + " ");
        }

        System.out.println();
    }

}