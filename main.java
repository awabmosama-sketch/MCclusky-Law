import java.util.*;
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
        System.out.println("List Of Number's: " + m.numberOfOnes());
        System.out.println("\nThe Different Bits Are\n: " + m.LevelOne());
        System.out.println("\nLevel Two Value Are:\n" + m.LevelTwo());
        System.out.println("\nLevel Three Value Are:\n" + m.LevelThree());
        
        ArrayList<String> FinalList = new ArrayList<>(m.primeImplicant);
        System.out.println("\nThe Simflified Expression Is :" + m.BeforeLastExpression(FinalList));
    }
}
