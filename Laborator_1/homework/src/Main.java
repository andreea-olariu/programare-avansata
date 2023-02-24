public class Main {
    public static void main(String[] args) {
        // PROBLEMA 1
        CommandLine cl = new CommandLine();
        cl.printIntArg(args[0]);

        // PROBLEMA 2
        int n = 30_000;
        long start = System.currentTimeMillis();
        Matrix m = new Matrix();
        int[][] latinSquare = m.createLatinSquare(n);
        m.printSquareMatrix(latinSquare, n);

        // PROBLEMA 3
        System.out.println(m.getSymbolsFromLineOrColumn(n, 3));
        long end = System.currentTimeMillis();
        System.out.println("Calcularea latinSquare a durat " + (end - start) + " milisecunde");

        //PROBLEMA 4
            // javac Main.java
            // java Main 4
    }
}