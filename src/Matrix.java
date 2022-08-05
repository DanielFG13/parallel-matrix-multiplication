import java.util.Random;

public class Matrix {

    final int[][] array;
    final int numRows;
    final int numCols;

    Matrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        array = new int[numRows][numCols];
    }

    public int getNumOfRows() {
        return numRows;
    }

    public int getNumOfCols() {
        return numCols;
    }

    public int getValue(int row, int col) {
        return array[row][col];
    }

    public void setValue(int row, int col, int value) {
        array[row][col] = value;
    }

    public void setRandomValues() {
        Random random = new Random();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                this.array[i][j] = random.nextInt(100) + 1;
            }
        }
    }

    public void printMatrix(String message) {
        System.out.println("-------" + message +  "--------");
        for (int i = 0; i < numRows; i++) {
            System.out.print("|");
            for (int j = 0; j < numCols; j++) {
                System.out.print(" " + this.array[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("--------------");
    }

}


