import java.io.*;

/**
 * Created by xen0phile on 7/31/15.
 */
class MAXLN {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long r;

        for(int i = 1; i <= T; i++){
            r = Integer.parseInt(br.readLine());
            pw.printf("Case %d: %.2f\n", i, 4*r*r+0.25);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}

/*
 _  _  _  _  _  _
 _| _| _|| ||_||_
|_  _||_ |_|  | _|
    _     _     _
  ||_ |_||_   || |
  ||_|  ||_|  ||_|
 _  _  _  _     _
  ||_||_||_   ||_|
  |  |  | _|  ||_|
 */
