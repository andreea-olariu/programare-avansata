public class Matrix {

    public int[][] createLatinSquare(int n) {
        int[][] latinSquare = new int[n][n];
        for(int i = 0; i < n; i++) {
            // every line starts with i + 1
            int value = i + 1;
            for(int j = 0; j < n; j++) {
                if(value == n) {
                    latinSquare[i][j] = value++;
                } else {
                    latinSquare[i][j] = value++ % n;
                }
            }
        }
        return latinSquare;
    }
    public void printSquareMatrix(int[][] m, int n) {
        if(n < 2000) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(m[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }

    public String getSymbolsFromLineOrColumn(int n, int k) {
        if(n < 2000) {
            String concString = "";
            for (int i = k; i < n + k; i++) {
                if (i == n) {
                    concString += i + " ";
                } else {
                    concString += i % n + " ";
                }
            }
            return concString;
        }
        return "";
    }
}
