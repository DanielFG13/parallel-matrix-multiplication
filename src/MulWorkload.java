import java.io.Serializable;
import java.rmi.RemoteException;

public class MulWorkload implements Runnable, Task<int[][]>, Serializable {

    private static final long serialVersionUID = 1L;

    int[][] a, b, c;
    WorkerIF worker;
    int workerNum;
    int workerSize;

    public MulWorkload(int[][] aa, int[][] b, int workerNum, WorkerIF worker, int workerSize) {
        this.worker = worker;
        int rowSize = ((workerNum + 1) * aa.length / workerSize) - (workerNum * aa.length / workerSize);
        this.a = new int[rowSize][aa.length];
        this.b = b;
        this.c = new int[rowSize][aa.length];
        this.workerNum = workerNum;
        this.workerSize = workerSize;

        //Realiza una matriz a parcial
        for (int j = 0, i = workerNum * aa.length / workerSize; i < (workerNum + 1) * aa.length
                / workerSize; i++, j++) {
            this.a[j] = aa[i];
        }
    }

    @Override
    public void run() {
        try {
            c = worker.execute(this);
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public int[][] execute() {
        System.out.println("Calculando matriz...");
        return new MatrixMulForkJoin().multiply(this);
    }
}