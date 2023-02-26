public class Matrix {
    private int rows;
    private int cols;
    public int[][] elements;
    Matrix(int _n, int _m) {
        this.rows = _n;
        this.cols = _m;
        this.elements = new int[this.rows][this.cols];
    }

    public Matrix multiply(int[][] second, int n, int m) throws Exception {
        // n = nr de linii ale matricei second
        // m = nr de coloane ale matricei second

        if(this.cols != n) {
            throw new Exception("Nu se poate face inmultirea");
        }
        Matrix result = new Matrix(this.rows, m);
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < this.cols; k++) {
                    result.elements[i][j] += elements[i][k] * second[k][j];
                }
            }
        }
        return result;
    }
    public void printMatrix() {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                System.out.print(this.elements[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
