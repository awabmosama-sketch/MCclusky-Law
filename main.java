public class main {
    public static void main(String[] args) {
        Mcclusky m = new Mcclusky();
        System.out.println("You have chosen: " + m.StandardMethod());
        int[] inputSignals = m.VariableCount();
        System.out.println("Input Signals:");
        for (int i = 0; i < inputSignals.length; i++) {
            System.out.println("Input " + (i + 1) + ": " + inputSignals[i]);
        }
    }
}
