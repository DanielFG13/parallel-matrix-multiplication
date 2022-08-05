import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MatrixMulForkJoinConcurrente {

    public Matrix multiply(Matrix a, Matrix b) {
        Matrix result = new Matrix(a.getNumOfRows(), b.getNumOfCols());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MultiplyTask(a, b, result, -1));
        return result;
    }

    private class MultiplyTask extends RecursiveAction {

        private Matrix a, b, result;
        private int row;

        MultiplyTask(Matrix a, Matrix b, Matrix result, int row) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.row = row;
        }

        @Override
        public void compute() {
            if (row == -1) {
                ArrayList<MultiplyTask> tasks = new ArrayList<>();
                for (int row = 0; row < a.getNumOfRows(); row++) {
                    tasks.add(new MultiplyTask(a, b, result, row));
                }
                invokeAll(tasks);
            } else {
                multiplyRowByColumn(a, b, result, row);
            }
        }

        void multiplyRowByColumn(Matrix a, Matrix b, Matrix c, int row) {
            for (int j = 0; j < b.getNumOfCols(); j++) {
                for (int k = 0; k < a.getNumOfCols(); k++) {
                    c.setValue(row, j, (c.getValue(row, j) +  a.getValue(row, k)* b.getValue(k, j)));
                }
            }
        }

    }

}