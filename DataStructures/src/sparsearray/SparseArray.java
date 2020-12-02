package sparsearray;

/**
 * @author chenzk
 * @create 2020-12-01 17:17
 */
public class SparseArray {
    public static void main(String[] args) {
        int rowNum = 11;
        int columnNum = 11;

        int[][] chessArr1 = new int[rowNum][columnNum];
        //黑子代表1，蓝子代表2
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][6] = 2;
        //输出原始的二维数组数列
        System.out.println("原始的二维数组：");
        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for(int i = 0;i < rowNum;i++){
            for(int j = 0;j < columnNum;j++){
                if(chessArr1[i][j] != 0) {sum++;}
            }
        }

        int[][] sparseArr1 = new int[sum + 1][3];
        sparseArr1[0][0] = chessArr1.length;
        sparseArr1[0][1] = chessArr1[0].length;
        sparseArr1[0][2] = sum;
        int count=0;
        for(int i = 0;i < rowNum;i++){
            for(int j = 0;j < columnNum;j++){
                if(chessArr1[i][j] != 0) {
                    count++;
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("转换后的稀疏二维数组：");
        for(int[] row : sparseArr1){
            for(int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
