import java.util.*;
public class Mcclusky {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> minTermsList = new ArrayList<>();
    String ST = "";
    int[] inputsSequence = new int[16];
    //--Task 1: Standard Method Selection
    String StandardMethod() {
        int ch = 0;
        

        while (true) {
            System.out.println("Choose Your Standard Method(1.SOP/2.POS)");
            ch = sc.nextInt();
            if (ch == 1){
                ST = "SOP";
                return "Sum of Product";
            } else if (ch == 2){
                ST = "POS";
                return "Product of Sum";
            } else{
                System.out.println("Invalid Choice, Please Enter 1 or 2");
                continue;
            }
            
        }
           
    }
    //--Task 2: Variable Count Input
    int[] VariableCount() {
        int i = 1;
        int varCount = 16;
        int inputSignals;
        int[] inputArray = new int[varCount];
        while (varCount > 0) {
            System.out.println("Enter The Input Signal " + i + " :");
            inputSignals = sc.nextInt();
            if (inputSignals == 1 || inputSignals == 0) {
                varCount--;
                inputArray[i - 1] = inputSignals;
                i++;
            } else {
                System.out.println("Invalid Input, Please Enter 1 or 0");
                continue;
            }
    
        }
        this.inputsSequence = inputArray;
        return inputArray;
    }
    //--Task 3: Min Terms Generation
    String[] MinTerms(){
        
        int i = 0;
        String[] minTerms = new String[inputsSequence.length];
       for ( i = 0; i < inputsSequence.length; i++) {
    if (ST.equals("SOP") && inputsSequence[i] == 1) {
        minTerms[i] = "m" + i;
        minTermsList.add(minTerms[i]);
    } else if (ST.equals("POS") && inputsSequence[i] == 0) {
        minTerms[i] = "m" + i;
        minTermsList.add(minTerms[i]);
    } else {
        minTerms[i] = " ";
        continue;
    }
}
        return minTerms;
    }
    //--Task 4: Setting the Expression
    String SettingExpression() {
        String expression = "";
        Map<String, String> FixTable = new HashMap<>();
        if (ST.equals("SOP")) {
        FixTable.put("m0", "A'B'C'D'");
        FixTable.put("m1", "A'B'C'D");
        FixTable.put("m2", "A'B'CD'");
        FixTable.put("m3", "A'B'CD");
        FixTable.put("m4", "A'BC'D'");
        FixTable.put("m5", "A'BC'D");
        FixTable.put("m6", "A'BCD'");
        FixTable.put("m7", "A'BCD");
        FixTable.put("m8", "AB'C'D'");
        FixTable.put("m9", "AB'C'D");
        FixTable.put("m10", "AB'CD'");
        FixTable.put("m11", "AB'CD");
        FixTable.put("m12", "ABC'D'");
        FixTable.put("m13", "ABC'D");
        FixTable.put("m14", "ABCD'");
        FixTable.put("m15", "ABCD");
        }else if (ST.equals("POS")) {
        FixTable.put("m0", "(A+B+C+D)");
        FixTable.put("m1", "(A+B+C+D')");
        FixTable.put("m2", "(A+B+C'+D)");
        FixTable.put("m3", "(A+B+C'+D')");
        FixTable.put("m4", "(A+B'+C+D)");
        FixTable.put("m5", "(A+B'+C+D')");
        FixTable.put("m6", "(A+B'+C'+D)");
        FixTable.put("m7", "(A+B'+C'+D')");
        FixTable.put("m8", "(A'+B+C+D)");
        FixTable.put("m9", "(A'+B+C+D')");
        FixTable.put("m10", "(A'+B+C'+D)");
        FixTable.put("m11", "(A'+B+C'+D')");
        FixTable.put("m12", "(A'+B'+C+D)");
        FixTable.put("m13", "(A'+B'+C+D')");
        FixTable.put("m14", "(A'+B'+C'+D)");
        FixTable.put("m15", "(A'+B'+C'+D')");
    }    for (String minTerm : minTermsList) {
        expression += FixTable.get(minTerm) + (ST.equals("SOP") ? " + " : " * ");
    }
    return expression.substring(0, expression.length() - 3);
    }
}