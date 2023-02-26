public class CycleGraph extends Graph {
    public CycleGraph(int _n) {
        this.n = _n;
        this.adjacencyMatrix = new Matrix(this.n, this.n);
        setAdjacencyMatrix();
    }
    void setAdjacencyMatrix() {
        for(int i = 1; i < this.n - 1; i++) {
            this.adjacencyMatrix.elements[i][i-1] = 1;
            this.adjacencyMatrix.elements[i][i+1] = 1;
        }
        this.adjacencyMatrix.elements[0][1] = 1;
        this.adjacencyMatrix.elements[0][this.n-1] = 1;

        this.adjacencyMatrix.elements[this.n-1][this.n-2] = 1;
        this.adjacencyMatrix.elements[this.n-1][0] = 1;
    }


}
