public class main {
    public static void main(String[] args) {
        Mcclusky m = new Mcclusky();
        System.out.println("You have chosen: " + m.StandardMethod());
        int[] inputSignals = m.VariableCount();
        System.out.println("Input Signals:");
        String[] MinTerms = m.MinTerms();
        System.out.println("Min Terms:");
        for (int i = 0; i < MinTerms.length; i++) {
            System.out.println("Input " + (i + 1) + ": " + MinTerms[i]);
        }
        System.out.println("Expression: " + m.SettingExpression());
    }
}
