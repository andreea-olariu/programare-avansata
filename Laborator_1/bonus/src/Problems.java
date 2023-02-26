public class Problems {
    public void cycleGraphProblem(int n) {
        System.out.println("PROBLEMA 1....");
        CycleGraph cycleGraph = new CycleGraph(n);
        System.out.println("A este...");
        cycleGraph.adjacencyMatrix.printMatrix();

        try {
            Matrix m = cycleGraph.adjacencyMatrix.multiply(cycleGraph.adjacencyMatrix.elements, n, n);
            System.out.println("A^2 este...");
            m.printMatrix();

            int counter = 3;
            while(counter++ <= cycleGraph.n) {
                m = cycleGraph.adjacencyMatrix.multiply(m.elements, n, n);
                System.out.println("A^" + counter + " este...");
                m.printMatrix();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void regularGraphProblems(int n, int degree) {
        System.out.println("\nPROBLEMA 2....");
        RegularGraph regGraph = new RegularGraph(n, degree);
        regGraph.adjacencyMatrix.printMatrix();
    }
}
