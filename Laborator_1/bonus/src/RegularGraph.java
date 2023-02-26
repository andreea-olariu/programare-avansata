import java.util.Arrays;
import java.util.Random;

public class RegularGraph extends Graph {
    private final int degree;

    RegularGraph(int _n, int _d) {
        this.degree = _d;
        this.n = _n;
        this.adjacencyMatrix = new Matrix(this.n, this.n);
        setAdjacencyMatrix();
    }

    void setAdjacencyMatrix() {
        if (n < degree + 1 || n * degree % 2 != 0) {
            System.out.println("Nu exista un graf regulat cu aceste grade..");
        } else {
            boolean valid = false;
            build:
            while (!valid) {
                Random rand = new Random();
                for (int i = 0; i < this.n; i++) {
                    int sum = 0;
                    for (int k = 0; k < this.n; k++)
                        if (this.adjacencyMatrix.elements[i][k] == 1) sum++;
                    if (this.n - i - 1 < this.degree - sum || sum > this.degree) {
                        for(int[] row : this.adjacencyMatrix.elements)
                            Arrays.fill(row, 0);
                        continue build;
                    }
                    while (sum < this.degree) {
                        int j = rand.nextInt(n);
                        while (this.adjacencyMatrix.elements[i][j] == 1 || j <= i)
                            j = rand.nextInt(n);
                        this.adjacencyMatrix.elements[i][j] = 1;
                        this.adjacencyMatrix.elements[j][i] = 1;
                        sum++;
                    }
                }
                valid = true;
            }
        }
    }
}
