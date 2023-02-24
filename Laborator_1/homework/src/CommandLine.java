public class CommandLine {
    public void printIntArg(String arg) {
        int n = 0;
        try {
            n = Integer.parseInt(arg);
            System.out.println(n);
        } catch(NumberFormatException ex) {
            System.out.println("Invalid number!");
        }
    }
}
