package com.yuehua.datastructure.sparsearray;

/**
 * @author yuehualiu
 * @version 1.0
 * @description: 稀疏数组
 * @date 2022/9/27 10:11 下午
 */
public class SparseArray {
    public static void main(String[] args) {

        // 11 * 11 的二维数组
        int chessArr1[][] = new int[11][11];
        // 第二行第三列
        chessArr1[1][2] = 1;
        // 第三行第四列
        chessArr1[2][3] = 2;
        // 第五行第六列
        chessArr1[4][5] = 2;
        System.out.println("原始数组");
        int rowCount = 0;
        int lie = 0;
        for (int[] row : chessArr1) {

            for (int data : row) {
                if (rowCount == 0) {
                    lie++;
                }
                System.out.printf("%d\t", data);
            }
            rowCount++;
            System.out.println();
        }
        System.out.println("行数 " + rowCount);
        System.out.println("列数 " + lie);
        int[][] ints = array2SparseArray(chessArr1, rowCount, lie);
        System.out.println("数组转稀疏数组");
        for (int[] row : ints) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        int[][] ints1 = sparseArray2Array(ints);
        System.out.println("稀疏数组转二维数组");
        for (int[] row : ints1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /***
     * @description: 二维数组转稀疏数组
     * @param: [chessArray]
     * @return: int[]
     * @author yuehualiu
     * @date: 2022/9/27 10:30 下午
     */
    public static int[][] array2SparseArray(int[][] chessArray, int rowCount, int lie) {
        // 稀疏数组的第一行第一列是二维数组的行，第一行第二列是二维数组的列数
        // 稀疏数组第一行第三列是二维数组的非0元素个数
        // 稀疏数组的行数是 原数组的个数加一
        // 获取稀疏数组的行数
        // 元素总数
        int sum = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < lie; j++) {
                int item = chessArray[i][j];
                if (item != 0) {
                    sum++;
                }
            }
        }
        System.out.println("元素总数 " + sum);
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = rowCount;
        sparseArray[0][1] = lie;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < lie; j++) {
                int item = chessArray[i][j];
                if (item != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = item;
                }
            }
        }
        System.out.println("稀疏数组 ");
        for (int[] ints : sparseArray) {
            for (int data : ints) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return sparseArray;
    }
    /***
     * @description: 稀疏数组转二维数组
     * @param: [chessArray, rowCount, lie]
     * @return: int[][]
     * @author yuehualiu
     * @date: 2022/9/27 11:07 下午
     */
    public static int[][] sparseArray2Array(int[][] chessArray) {
       int row =  chessArray[0][0];
       int lie =  chessArray[0][1];
       int sum = chessArray[0][2];

       int array[][] = new int[row][lie];

        for (int i = 1; i < chessArray.length; i++) {
            for (int j = 0; j < 3; j++) {
               int x = chessArray[i][0];
               int y = chessArray[i][1];
               int value = chessArray[i][2];
               array[x][y]=value;
            }
        }
        System.out.println("恢复的二维数组 ");
        for (int[] ints : array) {
            for (int data : ints) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return array;
    }


}
