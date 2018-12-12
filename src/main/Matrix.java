package main;
import java.util.ArrayList;
import java.util.Vector;

public class Matrix {
    /**
     * num of rows and cols of the matrix
     */
    public int rows;
    public int cols;

    /**
     * elements of the matrix, which is constructed by Vector
     */
    private Vector <Vector<Fraction>> elements = new Vector<>();

    /**
     * num of cols of the extended matrix
     */
    public int extend_cols;

    /**
     * @apiNote constructor of the matrix (unused)
     * @param rows: num of rows
     * @param extend_cols: num of cols of extended matrix
     */
    public Matrix(int rows, int cols, int extend_cols){
        this.rows = rows;
        this.cols = cols;
        this.extend_cols = extend_cols;
    }

    /**
     * @apiNote constructor of the matrix whose elements are passed by ArrayList
     * @param rows: num of rows
     * @param extend_cols: num of cols of extended matrix
     * @param fractions: num of elements to be passed
     */
    public Matrix(int rows, int cols, int extend_cols, ArrayList<Fraction> fractions){
        this(rows, cols, extend_cols);
        int size = fractions.size();
        assert (rows * extend_cols) == size;
        int index = 0;
        for (int row = 0; row < rows; row++){
            Vector<Fraction> newRow = new Vector<>();
            for (int col = 0; col < extend_cols; col++){
                newRow.add(fractions.get(index++));
            }
            elements.add(newRow);
        }
    }

    /**
     * @apiNote exchange the elements of two rows
     * @param row1: the first row
     * @param row2: the second row
     */
    public void exchangeTwoRows(int row1, int row2){
        for (int col = 0; col < extend_cols; col++){
            Fraction temp = elements.get(row1).get(col);
            elements.get(row1).set(col, elements.get(row2).get(col));
            elements.get(row2).set(col, temp);
        }
        System.out.println("exchange row " + row1 + " and row " + row2);
        System.out.println(this.toString());
    }

    /**
     * @apiNote multiple the elements of srcRow by frac and add them to elements in dstRow
     * @param srcRow: the source row to be multiplied by frac
     * @param dstRow: the dst row to be added to
     * @param frac: the constant frac
     */
    public void addOneRowToAnother(int srcRow, int dstRow, Fraction frac){
        for (int col = 0; col < extend_cols; col++){
            Fraction tempFrac = elements.get(srcRow).get(col).mul(frac);
            elements.get(dstRow).set(col, elements.get(dstRow).get(col).add(tempFrac));
        }
        System.out.println("multiple row " + srcRow + " by " + frac + " and add it to row " + dstRow);
        System.out.println(this.toString());
    }

    /**
     * @apiNote multiple the elements in row by frac
     * @param row: the row to be multiplied by frac
     * @param frac: a constant frac
     */
    public void oneRowMul(int row, Fraction frac){
        for (int col = 0; col < extend_cols; col++){
            elements.get(row).set(col, elements.get(row).get(col).mul(frac));
        }
    }

    /**
     * @apiNote output the element of matrix
     */
    @Override
    public String toString(){
        String outputStr = "";
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < extend_cols; col++){
                outputStr += elements.get(row).get(col).toString();
                outputStr += " ";
            }
            outputStr += "\n";
        }
        return outputStr;
    }

    /**
     * @apiNote judge the matrix is in Row-Echelon form or not
     */
    public boolean isEchelon(){
        int pivotColIndex = findPivot(0);
        if (pivotColIndex == -1)
            return false;
        for (int row = 1; row < rows; row++){
            int tempPivotColIndex = findPivot(row);
            if (tempPivotColIndex == -1 || tempPivotColIndex <= pivotColIndex){
                return false;
            }
            if (!elements.get(row).get(tempPivotColIndex).isOne())
                return false;
            pivotColIndex = tempPivotColIndex;
        }
        return true;
    }

    /**
     * @apiNote judge the matrix is in Reduced-Echelon form or not
     */
    public boolean isReducedEchelon(){
        if (!isEchelon())
            return false;
        for (int row = 0; row < rows; row++){
            int pivot = findPivot(row);
            assert pivot != -1;
            if (!elements.get(row).get(pivot).isOne())
                return false;
            for (int row1 = 0; row1 < rows; row1++){
                if (row1 != row && !elements.get(row1).get(pivot).isZero())
                    return false;
            }
        }
        return true;
    }

    /**
     * @apiNote change the pivot to 1 in row
     * @param row: the row those pivot to be changed to 1
     */
    public void changePivotToOne(int row){
        int pivot = findPivot(row);
        if (pivot == -1){
            System.out.println("Warning: the row has no pivot");
            return;
        }
        Fraction pivotFrac = elements.get(row).get(pivot);
        for (int col = 0; col < extend_cols; col++){
            if (!elements.get(row).get(col).isZero()){
                elements.get(row).set(col, elements.get(row).get(col).div(pivotFrac));
            }
        }
        System.out.println("Divide all the elements in row " + row + " by " + pivotFrac.toString() + " and we change the pivot of row " + row + " to 1");
        System.out.println(this.toString());
    }

    /**
     * @apiNote get the element in (row, col)
     * @param row: the row id
     * @param col: the col id
     */
    public Fraction getElement(int row, int col){
        return elements.get(row).get(col);
    }

    /**
     * @apiNote return the pivot of row, if it doesn't exist, return -1
     * @param row: the row id
     */
    public int findPivot(int row){
        int pivot = -1;
        for (int col = 0; col < cols; col++){
            if (!elements.get(row).get(col).isZero()){
                pivot = col;
                return pivot;
            }
        }
        return pivot;
    }


}