import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/20/15.
 */
class ARMY {
    public static void main(String[] args) throws IOException{
        Reader br = new Reader();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = br.nextInt();
        int NG, NM;
        int maxG = 0, maxM = 0;
        int temp;

        for(int i = 0; i < T; i++){

            NG = br.nextInt();
            NM = br.nextInt();

            for(int j = 0; j < NG; j++){
                temp = br.nextInt();
                if(temp > maxG){
                    maxG = temp;
                }
            }

            for(int j = 0; j < NM; j++){
                temp = br.nextInt();
                if(temp > maxM){
                    maxM = temp;
                }
            }

            if(maxM <= maxG){
                pw.println("Godzilla");
            }
            else{
                pw.println("MechaGodzilla");
            }

            maxG = 0;
            maxM = 0;
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
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
