package main;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            ArrayList<Fraction> matrix=new ArrayList<Fraction>();
            System.out.print("Welcome to our Guass Elimination Program!\n");
            System.out.print("For quit, please input 'q'.\n");

            //输入矩阵
            System.out.print("Please input the number of rows of your matrix:");
            String inp = "q";
            inp = scan.next();
            if(inp.equals("q")) break;
            int rows = Integer.parseInt(inp);
            System.out.print("\nPlease input the number of columns of the left matrix:");
            if(scan.hasNext()) inp = scan.next();
            else {
                System.out.println("Bye!");
                continue;
            };
            int cols = Integer.parseInt(inp);
            System.out.print("\nPlease input the number of total columns:");
            if(scan.hasNext()) inp = scan.next();

            int total_cols = Integer.parseInt(inp);
            System.out.print("\nPlease input the " + rows + "*" + total_cols + " matrix:\n");
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < total_cols; ++j) {
                    if(scan.hasNext()) inp = scan.next();
                    matrix.add(new Fraction(inp));
                }
            }
            Matrix m = new Matrix(rows, cols, total_cols, matrix);


            //输入模式
            //GaussElimination GE;

            System.out.print("Please enter a number to choose you mode, "
                    + "0 for auto and 1 for manual.\n");
            int mode = scan.nextInt();
            while (mode != 0 && mode != 1) {
                System.out.print("Please input 0 or 1!\n");
                mode = scan.nextInt();
            }

            //进行Gauss消元
            if(mode == 0) GaussElimination.autoGauss(m);
            else {
                System.out.println("Please choose your operation:");
                System.out.println("0 -- quit manual mode");
                System.out.println("1 -- exchange two rows");
                System.out.println("2 -- multiply one row with a coefficient and add it to another");
                System.out.println("3 -- change the pivot of one row to 1");
                //Scanner scan = new Scanner(System.in);
                boolean flag = true;
                while (flag) {
                    mode = scan.nextInt();
                    switch (mode) {
                        case 0:
                            flag = false;
                            break;
                        case 1:
                            System.out.println("Please input the two rows you want to exchange:");
                            int i = scan.nextInt();
                            int j = scan.nextInt();
                            m.exchangeTwoRows(i, j);
                            break;
                        case 2:
                            System.out.println("Please input the source row and the coefficient:");
                            int src = scan.nextInt();
                            inp = scan.next();
                            Fraction cof = new Fraction(inp);
                            System.out.println("Please input the target row:");
                            int dst = scan.nextInt();
                            m.addOneRowToAnother(src, dst, cof);
                            break;
                        case 3:
                            System.out.println("Please input the row whose pivot you want to change:");
                            int x = scan.nextInt();
                            m.changePivotToOne(x);
                            break;
                        default:
                            System.out.println("Please input a right command!");
                    }
                }
            }

        }
        scan.close();
    }
}
