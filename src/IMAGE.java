import java.io.*;

/**
 * Created by xen0phile on 8/3/15.
 */
class IMAGE {
    public static void main(String[] args) throws IOException{
        Reader rd = new Reader();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int a, b, x, y;
        boolean[][] grid;
        int[][] perimeter;
        char[] temp;

        while(true){
            a = rd.nextInt();
            b = rd.nextInt();
            x = rd.nextInt();
            y = rd.nextInt();
            grid = new boolean[a][b];
            perimeter = new int[a][b];

            for(int i = 0; i < a; i++){
                temp = rd.readLine().toCharArray();
                for(int j = 0; j < b; j++){
                    if(temp[j] == 'X'){
                        grid[i][j] = true;
                        perimeter[i][j] = 4;
                    }
                }
            }

            for(int i = 0; i < a; i++){
                for(int j = 0; j < b; j++){
                    if(grid[i][j]) {
                        for (int z = i - 1; z <= i + 1; z++) {
                            for (int zz = j - 1; zz <= j + 1; zz++) {
                                if (z >= 0 && z < a && zz >= 0 && zz < b) {
                                    if (!((zz == j - 1 || zz == j + 1) && (z == i - 1 || z == i + 1))) {
                                        if (grid[z][zz]) {
                                            perimeter[i][j]--;
                                        }
                                    }
                                }
                            }
                        }

                        for (int z = i - 1; z <= i + 1; z++) {
                            for (int zz = j - 1; zz <= j + 1; zz++) {
                                if (z >= 0 && z < a && zz >= 0 && zz < b) {
                                    if (grid[z][zz]) {
                                        perimeter[i][j] += perimeter[z][zz];
                                    }
                                }
                            }
                        }
                    }
                }
            }
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
