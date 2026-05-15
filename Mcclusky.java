import java.util.*;
public class Mcclusky{

    //-- Global Variables--//

    Scanner sc = new Scanner(System.in);

    ArrayList<String> LevelOneList = new ArrayList<>();

    ArrayList<String> LevelTwoList = new ArrayList<>();

    ArrayList<String> minTermsList = new ArrayList<>();

    String ST = "";

    int[] inputsSequence = new int[16];

    ArrayList<String> onesList1 = new ArrayList<>();
    ArrayList<String> onesList2 = new ArrayList<>();
    ArrayList<String> onesList3 = new ArrayList<>();
    ArrayList<String> onesList4 = new ArrayList<>();
    ArrayList<String> zerosList1 = new ArrayList<>();
    ArrayList<String> zerosList2 = new ArrayList<>();
    ArrayList<String> zerosList3 = new ArrayList<>();
    ArrayList<String> zerosList4 = new ArrayList<>();

    boolean[] p1 = {true,true,true,false};
    boolean[] p2 = {true,true,false,true};
    boolean[] p3 = {true,false,true,true};
    boolean[] p4 = {false,true,true,true};
    
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
    return expression.substring(0, expression.length() - 3) + ("\n\n");
    }

     //--Task 5: Number of Ones Counting

    String numberOfOnes(){
    String NoOfOnes = "";
    Map<String, String> FixTableInteger = new HashMap<>();
    FixTableInteger.put("m0","0000");
    FixTableInteger.put("m1","0001");
    FixTableInteger.put("m2","0010");
    FixTableInteger.put("m3","0011");
    FixTableInteger.put("m4","0100");
    FixTableInteger.put("m5","0101");
    FixTableInteger.put("m6","0110");
    FixTableInteger.put("m7","0111");
    FixTableInteger.put("m8","1000");
    FixTableInteger.put("m9","1001");
    FixTableInteger.put("m10","1010");
    FixTableInteger.put("m11","1011");
    FixTableInteger.put("m12","1100");
    FixTableInteger.put("m13","1101");
    FixTableInteger.put("m14","1110");
    FixTableInteger.put("m15","1111");

    for (String x : minTermsList){
        NoOfOnes += FixTableInteger.get(x) + " , ";
        int NumberOfOnes = 0;
        int NumberOfZeros = 0;
        String bits = FixTableInteger.get(x);
    for (char c : bits.toCharArray()){
            if (c == '1') {
                NumberOfOnes++;
            }else if(c == '0'){
                NumberOfZeros++;
            }
        }        
                 if (ST.equals("SOP")){ 
                    if (NumberOfOnes == 1){
                        onesList1.add(x);
                    } else if (NumberOfOnes == 2){
                        onesList2.add(x);
                    } else if (NumberOfOnes == 3){
                        onesList3.add(x);
                    } else if (NumberOfOnes == 4){
                        onesList4.add(x);
                    }
                } else if (ST.equals("POS")){
                    if (NumberOfZeros == 1){
                        zerosList1.add(x);
                    } else if (NumberOfZeros == 2){
                        zerosList2.add(x);
                    } else if (NumberOfZeros == 3){
                        zerosList3.add(x);
                    } else if (NumberOfZeros == 4){
                        zerosList4.add(x);
                    }
                }
            
         else {
            continue;
        }
    }

    return NoOfOnes.substring(0, NoOfOnes.length() - 3)+("\n\n") + (ST.equals("SOP") ? "\nNo. Of Ones is 1: " + onesList1 +"\n" + "\nNo. Of Ones is 2: " + onesList2 +"\n" + "\nNo. Of Ones is 3: " + onesList3 +"\n" + "\nNo. Of Ones is 4: " + onesList4 : "\nNo. Of Zeros is 1: " + zerosList1 +"\n" + "\nNo. Of Zeros is 2: " + zerosList2 +"\n" + "\nNo. Of Zeros is 3: " + zerosList3 +"\n" + "\nNo. Of Zeros is 4: " + zerosList4 + ("\n"));
    }

    //--Task 6: Level One

    String LevelOne(){
        StringBuilder CombinedMinTerm = new StringBuilder("");

        Map<String, String> FixTableInteger = new HashMap<>();

    FixTableInteger.put("m0","0000");
    FixTableInteger.put("m1","0001");
    FixTableInteger.put("m2","0010");
    FixTableInteger.put("m3","0011");
    FixTableInteger.put("m4","0100");
    FixTableInteger.put("m5","0101");
    FixTableInteger.put("m6","0110");
    FixTableInteger.put("m7","0111");
    FixTableInteger.put("m8","1000");
    FixTableInteger.put("m9","1001");
    FixTableInteger.put("m10","1010");
    FixTableInteger.put("m11","1011");
    FixTableInteger.put("m12","1100");
    FixTableInteger.put("m13","1101");
    FixTableInteger.put("m14","1110");
    FixTableInteger.put("m15","1111");
      for(String x : minTermsList) {
        String bits = FixTableInteger.get(x);
        for (String y : minTermsList){
            if (x.equals(y) || minTermsList.indexOf(y) <= minTermsList.indexOf(x)) {
                continue;
            }
            String bits1 = FixTableInteger.get(y);
            int difference = 0;
            StringBuilder temp = new StringBuilder("");
            for(int i = 0;i < bits.length();i++){
                
                if (bits.charAt(i) == bits1.charAt(i)){
                    temp.append(bits.charAt(i));
                }else{
                    difference++;
                    temp.append("x");
                }
            }
            if(difference == 1){
                String combineds = temp.toString();
                CombinedMinTerm.append("\n(").append(x).append(" , ").append(y).append(")").append("->").append(temp.toString()).append("\n");
                LevelOneList.add(combineds);
            }
                
        }
      }
        return CombinedMinTerm.toString()+"\nLevel One Values Are : "+LevelOneList;
    }
    
    //-- Task 7: Level Two

    String LevelTwo(){
        StringBuilder CombinedLevelTwo = new StringBuilder("");
        LevelTwoList.clear();

        for(int i = 0;i < LevelOneList.size();i++){
            for(int j = i+1;j < LevelOneList.size();j++){
                String x = LevelOneList.get(i);
                String y = LevelOneList.get(j);
                StringBuilder temp = new StringBuilder("");
                int difference = 0;
                for(int k = 0;k < x.length();k++){
                    if(x.charAt(k) == y.charAt(k)){
                        temp.append(x.charAt(k));
                    }else{
                        difference++;
                        temp.append("x");
                    }
                }
                if(difference == 1){
                    String Combined = temp.toString();
                    CombinedLevelTwo.append("(").append(x).append(",").append(y).append(")->").append(Combined).append("\n");
                    LevelTwoList.add(Combined);
                }
            }
        }
        
        return CombinedLevelTwo.toString() + "\nLevelTwo Values Are:" +LevelTwoList;
    }
}

