import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MatrixMulForkJoin {

    public int[][] multiply(MulWorkload mulWorkload) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MultiplyTask(mulWorkload, -1));
        return mulWorkload.c;
    }

    private class MultiplyTask extends RecursiveAction {

        private MulWorkload mwl;
        private int row;

        MultiplyTask(MulWorkload mulWorkload, int row) {
            this.mwl = mulWorkload;
            this.row = row;
        }

        @Override
        public void compute() {
            if (row == -1) {
                ArrayList<MultiplyTask> tasks = new ArrayList<>();
                for (int i = mwl.workerNum * mwl.a.length / mwl.workerSize; i < (mwl.workerNum + 1) * mwl.a.length
                        / mwl.workerSize; i++) {
                    tasks.add(new MultiplyTask(mwl, i));
                }
                invokeAll(tasks);
            } else {
                multiplyRowByColumn(mwl.a, mwl.b, mwl.c, row);
            }
        }

        void multiplyRowByColumn(int[][] a, int[][] b, int[][] c, int row) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    c[row][j] += a[row][k] * b[k][j];
                }
            }
        }

    }

}