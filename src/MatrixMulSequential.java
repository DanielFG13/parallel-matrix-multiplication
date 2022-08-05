public class MatrixMulSequential {

    public Matrix multiply(Matrix a, Matrix b) {
        Matrix result = new Matrix(a.getNumOfRows(), b.getNumOfCols());
        for (int i = 0; i < a.getNumOfRows(); i++) {
            for (int j = 0; j < b.getNumOfCols(); j++) {
                for (int k = 0; k < a.getNumOfCols(); k++) {
                    result.setValue(i, j, (result.getValue(i, j) +  a.getValue(i, k) * b.getValue(k, j)));
                }
            }
        }
        return result;
    }

}
