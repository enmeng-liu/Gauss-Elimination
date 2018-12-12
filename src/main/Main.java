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
            if(scan.hasNext()) inp = scan.next();
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
            else GaussElimination.manualGauss(m);

        }
        scan.close();
    }
}
