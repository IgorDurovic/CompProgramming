import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Projectile{
    public static void main(String[] args) throws IOException{
        Random r = new Random();
        final double SOL = 0.4443;
        PrintWriter out = new PrintWriter("s-data.txt");

        for(int j = 5; j < 10; j++) {
            out.println(j + " cm");
            for (int i = 0; i < 30; i++) {
                double error = (r.nextDouble() * 2 - 1) / 50;
                out.println(SOL + error);
            }
            out.println("-----------------");
        }

        out.flush();
        out.close();
    }

}
