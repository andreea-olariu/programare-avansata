public class Main {
    public static void main(String[] args) {
        Problems prob = new Problems();
        prob.cycleGraphProblem(5);
        try {
            int n = Integer.parseInt(args[0]);
            int d = Integer.parseInt(args[1]);
            prob.regularGraphProblems(n, d);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}