import java.io.*;

class AP2 {
    public static void main(String[] args) throws IOException{
        Reader br = new Reader();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int t = br.nextInt();
        long term3;
        long end3;
        long sum;
        long diff = 0;
        long start = 0;
        long n = 0;

        for(int i = 0; i < t; i++){
            term3 = br.nextLong();
            end3 = br.nextLong();
            sum = br.nextLong();
            for(int j = 1; j <= term3/2; j++){
                if(((term3 - 2 * j) * ((end3-term3)/j + 5)) + j * (((end3-term3)/j + 5) * ((end3-term3)/j + 4) / 2) == sum){
                    diff = j;
                    start = term3 - 2 * j;
                    n = (end3-term3)/j + 5;
                    break;
                }
            }

            pw.println(n);
            pw.print(start);

            for(long j = 1; j < n; j++){
                pw.print(" " + (start + (j * diff)));
            }

            pw.println();
        }

        pw.flush();
        pw.close();
        br.close();
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
