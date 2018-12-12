package main;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class GaussElimination {
    //public int mode;

    public static void autoGauss(Matrix A) {
        int step = 0;
        int row = 0, col = 0;
        while (row < A.rows && col < A.cols) {
            System.out.print(row + " " + col + "\n");
            //step ++;
            //System.out.printf("Step = %d\n", step);
            //if(step > 10) return;
            //assert (A.getElement(row, col).denominator < 1000);
            /*判断行首是否为0，为0则交换两行，如果没有能交换的行，则将消元列指标右移*/
            if (A.getElement(row, col).isZero()) {
                int k;
                for (k = row + 1; k < A.rows; ++k)
                    if (!A.getElement(k, col).isZero()) {
                        A.exchangeTwoRows(row, k);
                        break;
                    }
                if (k == A.rows) {
                    col++;
                    continue;
                }
            }
            //assert (false);
            /*---------------------------------------------------------*/
            /*将当前行主元归一并将其余行加上当前行的系数倍*/
            if (!A.getElement(row, col).isOne()) A.changePivotToOne(row);
            for (int i = row + 1; i < A.rows; ++i) {
                if (A.getElement(i, col).isZero()) continue;
                Fraction temp = A.getElement(i, col).mul(new Fraction(-1, 1));
                if (!temp.isZero()) {
                    A.addOneRowToAnother(row, i, temp);
                    //if(row == 2) assert (false);
                }
            }
            row++;
            col++;
        }

        System.out.print(A);
        //assert (false);
        /*至此，右下消元完成，开始左上消元 */
        /*-------------------------------------------------------------*/
        row = A.rows - 1;
        //col = A.cols;
        step = 0;
        while (row >= 0) {
            //step ++;
            //System.out.printf("Step = %d\n", step);
            //if(step > 2) assert (false);
            int pivot = A.findPivot(row);
            if (pivot == -1) {
                if (A.extend_cols > A.cols) {
                    for (int i = A.cols; i < A.extend_cols; ++i)
                        if (!A.getElement(row, i).isZero()) {
                            System.out.println("No solution!");
                            return;
                        }
                }
                row--;
                continue;
            } //该行为0行，转到上一行
            for (int i = row - 1; i >= 0; --i) {
                Fraction temp = A.getElement(i, pivot).mul(new Fraction(-1, 1));
                if(!temp.isZero()) A.addOneRowToAnother(row, i, temp);
            }
            row--;
        }
        System.out.print(A);
    }


    public static void manualGauss(Matrix A) {
        System.out.println("Please choose your operation:");
        System.out.println("0 -- quit manual mode");
        System.out.println("1 -- exchange two rows");
        System.out.println("2 -- multiply one row with a coefficient and add it to another");
        System.out.println("3 -- change the pivot of one row to 1");
        Scanner cin = new Scanner(System.in);
        while (true) {
            int mode = cin.nextInt();
            switch (mode) {
                case 0:
                    cin.close();
                    return;
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
                default:
                    System.out.println("Please input a right command!");
            }
        }
    }
}
