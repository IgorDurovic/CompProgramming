/**
 * Created by xen0phile on 12/21/15.
 */
public class lcs {
    public static void main(String[] args){
        int[] seq1 = new int[]{1, 3, 8, 4, 6, 5, 8};
        int[] seq2 = new int[]{6, 3, 2, 1, 4, 6, 5};

        int[][] length = new int[seq1.length][seq2.length + 1];

        for(int i = seq2.length - 1; i >= 0; i--){
            if(seq2[i] == seq1[seq1.length - 1]){
                length[seq1.length - 1][i] = 1;
                break;
            }
        }

        for(int i = seq1.length - 2; i >= 0; i--){
            int max = 0;
            for(int j = seq2.length - 1; j >= 0; j--){
                if(length[i + 1][j] > max){
                    max = length[i + 1][j];
                }
                if(seq1[i] == seq2[j] && length[i + 1][j + 1] + 1 > max){
                    max = length[i + 1][j + 1] + 1;
                }

                length[i][j] = max;
            }
        }

        System.out.println(length[0][0]);
    }
}
