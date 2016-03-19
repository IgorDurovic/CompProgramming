import java.io.*;
import java.util.Arrays;

/**
 * Created by xen0phile on 8/2/15.
 */
class BITMAP {

    static int[][] dist;

    public static void main(String[] args) throws IOException{
        Reader rd = new Reader();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = rd.nextInt(), n, m;
        char[] holder;

        for(int i = 0; i < T; i++){
            n = rd.nextInt();
            m = rd.nextInt();
            dist = new int[n][m];

            for(int a = 0; a < n; a++){
                Arrays.fill(dist[a], n + m);
                holder = rd.readLine().toCharArray();
                for(int b = 0; b < m; b++){
                    if(holder[b] == '1'){
                        dist[a][b] = 0;
                        for(int c = 1; c <= Math.max(m - b, Math.max(n - a, Math.max(a, b))); c++) {
                            if (a - c >= 0) dist[a - c][b] = Math.min(c, dist[a - c][b]);
                            if (a + c < dist.length) dist[a + c][b] = Math.min(c, dist[a + c][b]);
                            if (b - c >= 0) dist[a][b - c] = Math.min(c, dist[a][b - c]);
                            if (b + c < dist[0].length) dist[a][b + c] = Math.min(c, dist[a][b + c]);
                        }
                    }
                }
            }

            for(int a = 0; a < n; a++){
                for(int b = 0; b < m; b++){
                    for(int c = 1; c <= Math.max(m - b, Math.max(n - a, Math.max(a, b))); c++) {
                        if (a - c >= 0) dist[a - c][b] = Math.min(dist[a][b] + c, dist[a - c][b]);
                        if (a + c < dist.length) dist[a + c][b] = Math.min(dist[a][b] + c, dist[a + c][b]);
                        if (b - c >= 0) dist[a][b - c] = Math.min(dist[a][b] + c, dist[a][b - c]);
                        if (b + c < dist[0].length) dist[a][b + c] = Math.min(dist[a][b] + c, dist[a][b + c]);
                    }
                }
            }

            for(int a = 0; a < n; a++){
                for(int b = 0; b < m - 1; b++){
                    pw.print(dist[a][b] + " ");
                }
                pw.println(dist[a][m - 1]);
            }
        }

        pw.flush();
        pw.close();
        rd.close();
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
