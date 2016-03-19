
/**
 * Created by xen0phile on 12/19/15.
 */
public class FloodFill {
    public static void main(String[] args){
        Node[] graph = new Node[10];
        int[] temp = new int[2];
        temp[0] = 4;
        temp[1] = 8;
        graph[1] = new Node(temp);
        temp = new int[2];
        temp[0] = 7;
        temp[1] = 9;
        graph[2] = new Node(temp);
        temp = null;
        graph[3] = new Node(temp);
        temp = new int[1];
        temp[0] = 1;
        graph[4] = new Node(temp);
        temp = new int[3];
        temp[0] = 7;
        temp[1] = 9;
        temp[2] = 6;
        graph[5] = new Node(temp);
        temp = new int[1];
        temp[0] = 5;
        graph[6] = new Node(temp);
        temp = new int[3];
        temp[0] = 5;
        temp[1] = 9;
        temp[2] = 2;
        graph[7] = new Node(temp);
        temp = new int[1];
        temp[0] = 1;
        graph[8] = new Node(temp);
        temp = new int[3];
        temp[0] = 7;
        temp[1] = 2;
        temp[2] = 5;
        graph[9] = new Node(temp);
        System.out.println(countComponents(graph));
    }

    public static int countComponents(Node[] graph){

        int counter = 0;
        for(int i = 1; i < graph.length; i++){
            Node n = graph[i];
            if(!n.visited){
                counter++;
                n.visited = true;
                flood(graph, counter);
                System.out.println(graph[3].visited);
            }
        }

        return counter;
    }

    public static void flood(Node[] graph, int num){

        boolean b = true;
        while(b) {
            b = false;
            for (int i = 1; i < graph.length; i++) {
                Node n = graph[i];
                if (n.visited && n.component == 0) {
                    b = true;
                    n.component = num;
                    if(n.neighbors == null){
                        continue;
                    }
                    for(int m: n.neighbors){
                        if(!graph[m].visited){
                            graph[m].visited = true;
                        }
                    }
                }
            }
        }

    }

    public static class Node{
        public int[] neighbors;
        public boolean visited;
        public int component;

        Node(int[] n){
            neighbors = n;
            visited = false;
            component = 0;
        }
    }
}
