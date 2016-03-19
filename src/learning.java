import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by xen0phile on 11/7/15.
 */
class learning {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("learning.in"));
        PrintWriter pw = new PrintWriter("learning.out");

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]),
                A = Integer.parseInt(in[1]),
                B = Integer.parseInt(in[2]);

        Cow[] dataset = new Cow[N];
        for(int i = 0; i < N; i++){
            in = br.readLine().split(" ");

            dataset[i] = new Cow(in[0], Integer.parseInt(in[1]));
        }

        Arrays.sort(dataset);

        int numSpots = 0;
        boolean start = true;
        if(dataset[0].weight > A && dataset[0].spots){
            numSpots = dataset[0].weight - A + 1 + (dataset[1].weight - dataset[0].weight)/2;
            if((dataset[1].weight - dataset[0].weight) % 2 == 0 && !dataset[1].spots){
                numSpots++;
            }
        }
        for(int i = 1; i < N - 1; i++){
            if(dataset[i + 1].weight > A && dataset[i].spots){
                numSpots += (dataset[i].weight - dataset[i - 1].weight)/2 + 1
                        + (dataset[i + 1].weight - dataset[i].weight)/2;
                if((dataset[i + 1].weight - dataset[i].weight) % 2 == 0 && !dataset[i + 1].spots){
                    numSpots++;
                }
            }
            else if(dataset[i].weight > A && dataset[i].spots && start){
                start = false;
                numSpots += (dataset[i].weight - dataset[i - 1].weight)/2 + 1
                        + (dataset[i + 1].weight - dataset[i].weight)/2;
                if((dataset[i + 1].weight - dataset[i].weight) % 2 == 0 && !dataset[i + 1].spots){
                    numSpots++;
                }
            }
            else if(dataset[i].weight > A && dataset[i].spots){
                numSpots += (dataset[i].weight - dataset[i - 1].weight)/2 + 1
                        + (dataset[i + 1].weight - dataset[i].weight)/2;
                if((dataset[i + 1].weight - dataset[i].weight) % 2 == 0 && !dataset[i + 1].spots){
                    numSpots++;
                }
            }
        }
        if(dataset[B - 1].spots){
            numSpots += (dataset[B - 1].weight - dataset[B - 2].weight)/2 + 1;
        }

        System.out.println(numSpots);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static class Cow implements Comparable<Cow>{
        public boolean spots;
        public int weight;

        Cow(String s, int i){

            if(s.equals("S")){
                spots = true;
            }
            else{
                spots = false;
            }

            weight = i;
        }

        public int compareTo(Cow c){
            return this.weight - c.weight;
        }
    }

}
