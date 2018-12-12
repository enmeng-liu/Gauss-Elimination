package main;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class GaussElimination {
    //public int mode;

    public static void init() {
        System.out.print("Welcome to our Guass Elimination Program!\n");
        System.out.print("Please enter a number to choose you mode, 0 for auto and 1 for manual.\n");
        System.out.print("For quit, please input 'q'.\n");
    }

    public static void autoGauss(Matrix A) {
        int row = 0, col = 0;
        while (row < A.m && col < A.n && !A.isEchelon()) {
            /*判断行首是否为0，为0则交换两行，如果没有能交换的行，则将消元列指标右移*/
            if (!A.getElement(row, col).isZero()) {
                int k;
                for (k = row + 1; k < A.m; ++k)
                    if (!A.getElement(k, col).isZero()) {
                        A.exchangeTwoRows(row, k);
                        break;
                    }
                if (k == A.m - 1) {
                    col++;
                    continue;
                }
            }
            /*---------------------------------------------------------*/
            /*将当前行主元归一并将其余行加上当前行的系数倍*/
            if(!A.getElement(row,col).isOne())A.changePivotToOne(row);
            for (int i = row + 1; i < A.m; ++i) {
                Fraction temp = A.getElement(i, col).mul(new Fraction(-1,1));
                if (!temp.isZero()) {
                    A.addOneRowToAnother(row, i, temp);
                }
            }
            row++;
            col++;
        }
        /*至此，右下消元完成，开始左上消元 */
        /*-------------------------------------------------------------*/
        row = A.m;
        col = A.n;
        while(row >= 0 && !A.isReducedEchelon()) {
            int pivot = A.findPivot();
            if(pivot == -1) {row --; continue;} //该行为0行，转到上一行
            for(int i = row - 1; i >= 0; --i) {
                Fraction temp = A.getElement(i, pivot).mul(new Fraction(-1,1));
                A.addOneRowToAnother(row, i, temp);
            }
            System.out.print(A);
    }


    public static void manualGauss (Matrix A){
            System.out.println("Please choose your operation:");
            System.out.println("1 -- exchange two rows");
            System.out.println("2 -- multiply one row with a coefficient and add it to another");
            System.out.println("3 -- change the pivot of one row to 1");
            Scanner cin = new Scanner(System.in);
            while (true) {
                int mode = cin.nextInt();
                if(mode == 'q') return;
                switch (mode) {
                    case 1:
                        System.out.println("Please input the two rows you want to exchange:");
                        int i = cin.nextInt();
                        int j = cin.nextInt();
                        A.exchangeTwoRows(i, j);
                        break;
                    case 2:
                        System.out.println("Please input the source row and the coefficient:");
                        int src = cin.nextInt();
                        String inp = cin.next();
                        Fraction cof = new Fraction(inp);
                        System.out.println("Please input the target row:");
                        int dst = cin.nextInt();
                        A.addOneRowToAnother(src, dst, cof);
                        break;
                    case 3:
                        System.out.println("Please input the row whose pivot you want to change:");
                        int x = cin.nextInt();
                        A.changePivotToOne(x);
                        break;
                    default: System.out.println("Please input a right command!");
                }
            }
            cin.close();
        }
}
