import java.io.*;

/**
 * Created by xen0phile on 7/24/15.
 */
class INVCNT {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception{
        int testcases = Integer.parseInt(in.readLine());
        String[] temp;
        while (testcases-- > 0) {
            int n = Integer.parseInt(in.readLine());
            temp = in.readLine().split(" ");
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = Integer.parseInt(temp[i]);
            out.println(solve(array, n));
        }
        out.flush();
    }

    public static long solve(int[] array, int n) throws Exception {
        if (n == 1)
            return 0;

        int middle = (n-1) / 2;
        int leftLength = middle+1, rightLength = n-1-middle;
        int[] leftHalf = new int[leftLength];
        for (int i = 0; i < leftLength; i++)
            leftHalf[i] = array[i];
        int[] rightHalf = new int[rightLength];
        for (int i = 0; i < rightLength; i++)
            rightHalf[i] = array[middle+1+i];

        long inversions = solve(leftHalf, leftLength) + solve(rightHalf, rightLength);

        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k++] = leftHalf[i++];
            } else {
                array[k++] = rightHalf[j++];
                inversions += leftLength - i;
            }
        }
        while (i < leftLength)
            array[k++] = leftHalf[i++];
        while (j < rightLength)
            array[k++] = rightHalf[j++];

        return inversions;
    }
}
