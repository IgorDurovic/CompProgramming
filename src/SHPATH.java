import java.util.Scanner;

/**
 * Created by xen0phile on 6/21/15.
 */
class SHPATH {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int tests = scn.nextInt();
        int num;
        int connections;
        String[] cities;

        for(int i = 0; i < tests; i++){
            num = scn.nextInt();
            cities = new String[num];
            for(int j = 0; j < num; j++){
                connections = scn.nextInt();

            }

        }
    }

    public class node{

        private int connections;
        private String name;
        private int[] cities;
        private int[] costs;

        node(String name, int connections){
            this.name = name;
            this.connections = connections;
            this.cities = new int[connections];
            this.costs = new int[connections];
        }

        public void setCities(int city, int index){
            this.cities[index] = city;
        }

        public void setCosts(int cost, int index){
            this.costs[index] = cost;
        }

    }

}
