import java.io.*;

class OFORTUNE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()), ini, years, num, op, max, cur, interest, curInterest;
        String[] temp;
        boolean isComp;
        double iRate;

        for (int i = 0; i < t; i++) {
            ini = Integer.parseInt(br.readLine());
            years = Integer.parseInt(br.readLine());
            num = Integer.parseInt(br.readLine());

            max = 0;

            for (int j = 0; j < num; j++) {
                temp = br.readLine().split(" ");
                isComp = temp[0].equals("1");
                iRate = Double.parseDouble(temp[1]);
                op = Integer.parseInt(temp[2]);

                interest = 0;
                cur = ini;
                for (int j2 = 0; j2 < years; j2++) {
                    curInterest = (int)(cur*iRate);
                    if(isComp)
                        cur+=curInterest;
                    else
                        interest+=curInterest;
                    cur-=op;
                }
                if(!isComp)
                    cur+=interest;
                if(cur>max)
                    max=cur;
            }
            pw.println(max);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}