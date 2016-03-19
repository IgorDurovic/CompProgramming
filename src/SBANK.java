import java.io.*;
import java.util.ArrayList;

/**
 * Created by xen0phile on 8/3/15.
 */
class SBANK {

    static PrintWriter pw;
    static int[] len = {2, 8, 4, 4, 4, 4};

    public static void main(String[] args) throws IOException{
        Reader rd = new Reader();
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = rd.nextInt(), n, control, t;
        ArrayList<TreeNode> bank = new ArrayList<TreeNode>();
        TreeNode temp;

        for(int i = 0; i < T; i++){
            n = rd.nextInt();
            bank.clear();

            bank.add(new TreeNode(rd.nextInt()));
            bank.get(0).children.add(new TreeNode(rd.nextInt()));
            bank.get(0).children.get(0).children.add(new TreeNode(rd.nextInt()));
            bank.get(0).children.get(0).children.get(0).children.add(new TreeNode(rd.nextInt()));
            bank.get(0).children.get(0).children.get(0).children.get(0).children.add(new TreeNode(rd.nextInt()));
            bank.get(0).children.get(0).children.get(0).children.get(0).children.get(0).children.add(new TreeNode(rd.nextInt()));
            bank.get(0).children.get(0).children.get(0).children.get(0).children.get(0).children.get(0).isLast = true;
            bank.get(0).children.get(0).children.get(0).children.get(0).children.get(0).children.get(0).count = 1;

            for(int j = 1; j < n; j++){
                control = rd.nextInt();
                t = bank.indexOf(new TreeNode(control));
                if(t != -1){
                    temp = bank.get(t);
                }
                else{
                    int a;
                    for(a = 0; a < bank.size(); a++){
                        if(bank.get(a).value > control){
                            bank.add(a, new TreeNode(control));
                            break;
                        }
                    }
                    if(a == bank.size()){
                        bank.add(new TreeNode(control));
                    }
                    temp = bank.get(a);
                }

                for(int a = 0; a < 5; a++){
                    control = rd.nextInt();
                    t = temp.children.indexOf(new TreeNode(control));
                    if(t != -1){
                        temp = temp.children.get(t);
                        if(temp.isLast){
                            temp.count++;
                        }
                    }
                    else{
                        int b;
                        for(b = 0; b < temp.children.size(); b++){
                            if(temp.children.get(b).value > control){
                                temp.children.add(b, new TreeNode(control));
                                break;
                            }
                        }
                        if(temp.children.isEmpty()){
                            temp.children.add(new TreeNode(control));
                            temp = temp.children.get(0);
                        }
                        else {
                            if(b == temp.children.size()){
                                temp.children.add(new TreeNode(control));
                            }
                            temp = temp.children.get(b);
                        }

                        if(a == 4){
                            temp.isLast = true;
                            temp.count = 1;
                        }
                    }
                }
            }

            for(int j = 0; j < bank.size(); j++){
                printTree("", bank.get(j), 0);
            }

            pw.println();
        }

        pw.flush();
        pw.close();
        rd.close();
    }

    public static void printTree(String s, TreeNode n, int counter){

        StringBuilder temp = new StringBuilder(n.value + "");
        StringBuilder sb = new StringBuilder(s);
        sb.append(" ");
        if(temp.length() < len[counter]){
            for(int i = temp.length(); i < len[counter]; i++){
                sb.append(0);
            }
        }

        sb.append(temp);

        if(n.isLast){
            sb.append(" " + n.count);
            sb.deleteCharAt(0);
            pw.println(sb.toString());
            return;
        }

        for(int i = 0; i < n.children.size(); i++){
            printTree(sb.toString(), n.children.get(i), counter + 1);
        }
    }

    static class TreeNode implements Comparable<TreeNode>{
        public int value;
        public ArrayList<TreeNode> children;
        public boolean isLast;
        public int count;

        TreeNode(int n){
            value = n;
            children = new ArrayList<TreeNode>();
            isLast = false;
            count = 0;
        }

        public boolean equals(Object o){
            if(o instanceof TreeNode) {
                return ((TreeNode)o).value == this.value;
            }
            else{
                return false;
            }
        }

        public int compareTo(TreeNode t){
            return this.value - t.value;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte [] buffer;
        private int bufferPointer, bytesRead;

        public Reader () {
            din = new DataInputStream (System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader (String file_name) throws IOException {
            din = new DataInputStream (new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine () throws IOException {
            byte [] buf = new byte[1024];
            int cnt = 0, c;
            while ((c = read ()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String (buf, 0, cnt);
        }

        public int nextInt () throws IOException {
            int ret = 0;
            byte c = read ();
            while (c <= ' ')
                c = read ();
            boolean neg = (c == '-');
            if (neg)
                c = read ();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read ()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong () throws IOException {
            long ret = 0;
            byte c = read ();
            while (c <= ' ')
                c = read ();
            boolean neg = (c == '-');
            if (neg)
                c = read ();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read ()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble () throws IOException {
            double ret = 0, div = 1;
            byte c = read ();
            while (c <= ' ')
                c = read ();
            boolean neg = (c == '-');
            if (neg)
                c = read ();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read ()) >= '0' && c <= '9');
            if (c == '.')
                while ((c = read ()) >= '0' && c <= '9')
                    ret += (c - '0') / (div *= 10);
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer () throws IOException {
            bytesRead = din.read (buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read () throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer ();
            return buffer[bufferPointer++];
        }

        public void close () throws IOException {
            if (din == null)
                return;
            din.close ();
        }
    }

}
