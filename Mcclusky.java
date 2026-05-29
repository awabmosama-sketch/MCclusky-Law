import java.util.*;

public class Mcclusky {

    // -- Global Variables -- //

    Scanner sc = new Scanner(System.in);

    Set<String> primeImplicant = new LinkedHashSet<>();

    ArrayList<String> LevelOneList = new ArrayList<>();
    ArrayList<String> LevelTwoList = new ArrayList<>();
    ArrayList<String> LevelThreeList = new ArrayList<>();
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

    // --Task 1: Standard Method Selection

    String StandardMethod() {
        int ch = 0;

        while (true) {
            System.out.println("Choose Your Standard Method(1.SOP/2.POS)");
            ch = sc.nextInt();
            if (ch == 1) {
                ST = "SOP";
                return "Sum of Product";
            } else if (ch == 2) {
                ST = "POS";
                return "Product of Sum";
            } else {
                System.out.println("Invalid Choice, Please Enter 1 or 2");
                continue;
            }

        }

    }

    // --Task 2: Variable Count Input

    int[] VariableCount() {
        int i = 1;
        int varCount = 16;
        int inputSignals;
        int[] inputArray = new int[varCount];
        while (varCount > 0) {
            System.out.println("Enter The Input Signal " + i + ", (1 or 0):");
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

    // --Task 3: Min Terms Generation

    String[] MinTerms() {
        int i = 0;
        String[] minTerms = new String[inputsSequence.length];
        for (i = 0; i < inputsSequence.length; i++) {
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

    // --Task 4: Setting the Expression

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
        } else if (ST.equals("POS")) {
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
        }
        for (String minTerm : minTermsList) {
            expression += FixTable.get(minTerm) + (ST.equals("SOP") ? " + " : " * ");
        }
        if (expression.length() >= 3) {
            return expression.substring(0, expression.length() - 3);
        }
        return expression;
    }

    // --Task 5: Number of Ones Counting

    String numberOfOnes() {
        String NoOfOnes = "";
        Map<String, String> FixTableInteger = new HashMap<>();
        FixTableInteger.put("m0", "0000");
        FixTableInteger.put("m1", "0001");
        FixTableInteger.put("m2", "0010");
        FixTableInteger.put("m3", "0011");
        FixTableInteger.put("m4", "0100");
        FixTableInteger.put("m5", "0101");
        FixTableInteger.put("m6", "0110");
        FixTableInteger.put("m7", "0111");
        FixTableInteger.put("m8", "1000");
        FixTableInteger.put("m9", "1001");
        FixTableInteger.put("m10", "1010");
        FixTableInteger.put("m11", "1011");
        FixTableInteger.put("m12", "1100");
        FixTableInteger.put("m13", "1101");
        FixTableInteger.put("m14", "1110");
        FixTableInteger.put("m15", "1111");

        for (String x : minTermsList) {
            NoOfOnes += FixTableInteger.get(x) + " , ";
            int NumberOfOnes = 0;
            int NumberOfZeros = 0;
            String bits = FixTableInteger.get(x);
            for (char c : bits.toCharArray()) {
                if (c == '1') {
                    NumberOfOnes++;
                } else if (c == '0') {
                    NumberOfZeros++;
                }
            }
            if (ST.equals("SOP")) {
                if (NumberOfOnes == 1) {
                    onesList1.add(x);
                } else if (NumberOfOnes == 2) {
                    onesList2.add(x);
                } else if (NumberOfOnes == 3) {
                    onesList3.add(x);
                } else if (NumberOfOnes == 4) {
                    onesList4.add(x);
                }
            } else if (ST.equals("POS")) {
                if (NumberOfZeros == 1) {
                    zerosList1.add(x);
                } else if (NumberOfZeros == 2) {
                    zerosList2.add(x);
                } else if (NumberOfZeros == 3) {
                    zerosList3.add(x);
                } else if (NumberOfZeros == 4) {
                    zerosList4.add(x);
                }
            }

            else {
                continue;
            }
            if (NoOfOnes.length() > 3) {
                NoOfOnes = NoOfOnes.substring(0, NoOfOnes.length() - 3) + "\n\n";
            }
        }

        return NoOfOnes.substring(0, NoOfOnes.length() - 3) + ("\n\n")
                + (ST.equals("SOP") ? "\nNo. Of Ones is 1: " + onesList1 + "\n" + "\nNo. Of Ones is 2: " + onesList2
                        + "\n" + "\nNo. Of Ones is 3: " + onesList3 + "\n" + "\nNo. Of Ones is 4: " + onesList4
                        : "\nNo. Of Zeros is 1: " + zerosList1 + "\n" + "\nNo. Of Zeros is 2: " + zerosList2 + "\n"
                                + "\nNo. Of Zeros is 3: " + zerosList3 + "\n" + "\nNo. Of Zeros is 4: " + zerosList4
                                + ("\n"));
    }

    // --Task 6: Level One

    String LevelOne() {
        StringBuilder CombinedMinTerm = new StringBuilder("");
        Map<String, String> FixTableInteger = new HashMap<>();
        FixTableInteger.put("m0", "0000");
        FixTableInteger.put("m1", "0001");
        FixTableInteger.put("m2", "0010");
        FixTableInteger.put("m3", "0011");
        FixTableInteger.put("m4", "0100");
        FixTableInteger.put("m5", "0101");
        FixTableInteger.put("m6", "0110");
        FixTableInteger.put("m7", "0111");
        FixTableInteger.put("m8", "1000");
        FixTableInteger.put("m9", "1001");
        FixTableInteger.put("m10", "1010");
        FixTableInteger.put("m11", "1011");
        FixTableInteger.put("m12", "1100");
        FixTableInteger.put("m13", "1101");
        FixTableInteger.put("m14", "1110");
        FixTableInteger.put("m15", "1111");

        boolean[] matched = new boolean[minTermsList.size()];

        for (int i = 0; i < minTermsList.size(); i++) {
            String x = minTermsList.get(i);
            String bits = FixTableInteger.get(x);
            for (int j = i + 1; j < minTermsList.size(); j++) {
                String y = minTermsList.get(j);
                String bits1 = FixTableInteger.get(y);
                int difference = 0;
                StringBuilder temp = new StringBuilder("");
                for (int k = 0; k < bits.length(); k++) {
                    if (bits.charAt(k) == bits1.charAt(k)) {
                        temp.append(bits.charAt(k));
                    } else {
                        difference++;
                        temp.append("x");
                    }
                }
                if (difference == 1) {
                    matched[i] = true;
                    matched[j] = true;
                    String combineds = temp.toString();
                    CombinedMinTerm.append("\n(").append(x).append(" , ").append(y).append(")->")
                            .append(temp.toString()).append("\n");
                    LevelOneList.add(combineds);
                }

            }
        }
        for (int i = 0; i < minTermsList.size(); i++) {
            if (!matched[i]) {
                String x = minTermsList.get(i);
                primeImplicant.add(FixTableInteger.get(x));
            }
        }
        return CombinedMinTerm.toString() + "\nLevel One Values Are : " + LevelOneList;
    }

    // -- Task 7: Level Two

    String LevelTwo() {
        StringBuilder CombinedLevelTwo = new StringBuilder("");
        boolean[] matched = new boolean[LevelOneList.size()];

        for (int i = 0; i < LevelOneList.size(); i++) {
            for (int j = i + 1; j < LevelOneList.size(); j++) {
                String x = LevelOneList.get(i);
                String y = LevelOneList.get(j);
                StringBuilder temp = new StringBuilder("");
                int difference = 0;
                for (int k = 0; k < x.length(); k++) {
                    if (x.charAt(k) == y.charAt(k)) {
                        temp.append(x.charAt(k));
                    } else {
                        difference++;
                        temp.append("x");
                    }
                }
                if (difference == 1) {
                    matched[i] = true;
                    matched[j] = true;
                    String Combined = temp.toString();
                    CombinedLevelTwo.append("(").append(x).append(",").append(y).append(")->").append(Combined)
                            .append("\n");
                    LevelTwoList.add(Combined);
                }
            }
        }
        for (int i = 0; i < LevelOneList.size(); i++) {
            if (!matched[i]) {
                primeImplicant.add(LevelOneList.get(i));
            }
        }
        Set<String> unique = new LinkedHashSet<>(LevelTwoList);
        LevelTwoList.clear();
        LevelTwoList.addAll(unique);

        return CombinedLevelTwo.toString() + "\nLevelTwo Values Are:" + LevelTwoList;
    }

    // --Task 8: Level Three

    String LevelThree() {
        StringBuilder CombinedLevelThree = new StringBuilder("");
        boolean[] matched = new boolean[LevelTwoList.size()];

        for (int i = 0; i < LevelTwoList.size(); i++) {
            for (int j = i + 1; j < LevelTwoList.size(); j++) {
                String x = LevelTwoList.get(i);
                String y = LevelTwoList.get(j);
                StringBuilder temp = new StringBuilder("");
                int difference = 0;
                for (int k = 0; k < x.length(); k++) {
                    if (x.charAt(k) == y.charAt(k)) {
                        temp.append(x.charAt(k));
                    } else {
                        difference++;
                        temp.append("x");
                    }
                }
                if (difference == 1) {
                    matched[i] = true;
                    matched[j] = true;
                    String Combined = temp.toString();
                    CombinedLevelThree.append("(").append(x).append(",").append(y).append(")->").append(Combined)
                            .append("\n");
                    LevelThreeList.add(Combined);
                }
            }
        }
        for (int i = 0; i < LevelTwoList.size(); i++) {
            if (!matched[i]) {
                primeImplicant.add(LevelTwoList.get(i));
            }
        }
        Set<String> unique = new LinkedHashSet<>(LevelThreeList);
        LevelThreeList.clear();
        LevelThreeList.addAll(unique);

        primeImplicant.addAll(LevelThreeList);

        return CombinedLevelThree.toString() + "\nLevel Three Values Are :" + LevelThreeList;
    }

    String SetLastExpression(String Pattern) {
        char[] vars = { 'A', 'B', 'C', 'D' };

        if (ST.equals("SOP")) {
            StringBuilder sopResult = new StringBuilder();
            for (int i = 0; i < Pattern.length(); i++) {
                char c = Pattern.charAt(i);
                if (c == '0') {
                    sopResult.append(vars[i]).append("'");
                } else if (c == '1') {
                    sopResult.append(vars[i]);
                } else {
                    continue;
                }
            }
            return sopResult.toString();
        } else {
            StringBuilder posResult = new StringBuilder("(");
            for (int i = 0; i < Pattern.length(); i++) {
                char c = Pattern.charAt(i);
                if (c == '0') {
                    posResult.append(vars[i]).append(" + ");
                } else if (c == '1') {
                    posResult.append(vars[i]).append("' + ");
                } else {
                    continue;
                }
                if (posResult.length() >= 3) {
                    posResult.setLength(posResult.length() - 3);
                }

            }
            posResult.append(")");
            return posResult.toString();
        }
    }

    String BeforeLastExpression(ArrayList<String> primeLists) {
        if (primeLists.isEmpty())
            return "No Implicants Found !";

        StringBuilder expression = new StringBuilder();
        for (String implicant : primeLists) {
            expression.append(SetLastExpression(implicant));
            expression.append(ST.equals("SOP") ? "+" : "*");
        }
        if (expression.length() > 0) {
            expression.setLength(expression.length() - 1);
        }
        return expression.toString() + " ";
    }

    // Task 9: The Covering System


    private Map<String, String> getMintermBinaryMap() {
        Map<String, String> map = new HashMap<>();
        map.put("m0", "0000");
        map.put("m1", "0001");
        map.put("m2", "0010");
        map.put("m3", "0011");
        map.put("m4", "0100");
        map.put("m5", "0101");
        map.put("m6", "0110");
        map.put("m7", "0111");
        map.put("m8", "1000");
        map.put("m9", "1001");
        map.put("m10", "1010");
        map.put("m11", "1011");
        map.put("m12", "1100");
        map.put("m13", "1101");
        map.put("m14", "1110");
        map.put("m15", "1111");
        return map;
    }

 
    private boolean matchesPattern(String mintermBits, String pattern) {
        for (int i = 0; i < 4; i++) {
            char p = pattern.charAt(i);
            if (p != 'x' && p != mintermBits.charAt(i))
                return false;
        }
        return true;
    }

   
    private Map<String, List<String>> buildCoverageMap() {
        Map<String, String> binMap = getMintermBinaryMap();
        Map<String, List<String>> coverage = new LinkedHashMap<>();

        for (String pi : primeImplicant) {
            List<String> covered = new ArrayList<>();
            for (String mt : minTermsList) {
                String bits = binMap.get(mt);
                if (bits != null && matchesPattern(bits, pi)) {
                    covered.add(mt);
                }
            }
            if (!covered.isEmpty()) {
                coverage.put(pi, covered);
            }
        }
        return coverage;
    }

    
    private Set<String> findMinimalCover() {
        Map<String, List<String>> coverage = buildCoverageMap();
        if (coverage.isEmpty())
            return new LinkedHashSet<>();

        Set<String> essential = new LinkedHashSet<>();
        Set<String> uncoveredMinterms = new LinkedHashSet<>(minTermsList);

       
        boolean changed;
        do {
            changed = false;
            Map<String, Integer> mintermFreq = new HashMap<>();
            for (List<String> list : coverage.values()) {
                for (String mt : list) {
                    mintermFreq.put(mt, mintermFreq.getOrDefault(mt, 0) + 1);
                }
            }
            // Minterms that appear only once -> essential
            for (Map.Entry<String, Integer> e : mintermFreq.entrySet()) {
                if (e.getValue() == 1) {
                    String minterm = e.getKey();
                    for (Map.Entry<String, List<String>> entry : coverage.entrySet()) {
                        if (entry.getValue().contains(minterm)) {
                            String pi = entry.getKey();
                            essential.add(pi);
                            // Remove all minterms covered by this essential PI
                            uncoveredMinterms.removeAll(entry.getValue());
                            changed = true;
                            break;
                        }
                    }
                }
            }
            // Remove essential PIs and all minterms they cover from the coverage map
            Iterator<Map.Entry<String, List<String>>> it = coverage.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<String>> entry = it.next();
                if (essential.contains(entry.getKey())) {
                    it.remove();
                    continue;
                }
                entry.getValue().removeIf(mt -> !uncoveredMinterms.contains(mt));
                if (entry.getValue().isEmpty())
                    it.remove();
            }
        } while (changed && !uncoveredMinterms.isEmpty());

        if (uncoveredMinterms.isEmpty()) {
            return essential;
        }

        // Solve set cover for remaining minterms and PIs using recursion
        List<Map.Entry<String, List<String>>> remaining = new ArrayList<>(coverage.entrySet());
        Set<String> best = new LinkedHashSet<>();
        solveCover(remaining, new LinkedHashSet<>(), new LinkedHashSet<>(uncoveredMinterms), best);
        essential.addAll(best);
        return essential;
    }


    private void solveCover(List<Map.Entry<String, List<String>>> remaining,
                            Set<String> selected,
                            Set<String> uncovered,
                            Set<String> bestSolution) {
        if (uncovered.isEmpty()) {
            if (bestSolution.isEmpty() || selected.size() < bestSolution.size()) {
                bestSolution.clear();
                bestSolution.addAll(selected);
            }
            return;
        }
        if (selected.size() >= (bestSolution.isEmpty() ? Integer.MAX_VALUE : bestSolution.size()))
            return;
        if (remaining.isEmpty())
            return;

     
        Map.Entry<String, List<String>> first = remaining.get(0);
        Set<String> newUncovered = new LinkedHashSet<>(uncovered);
        newUncovered.removeAll(first.getValue());
        Set<String> newSelected = new LinkedHashSet<>(selected);
        newSelected.add(first.getKey());
        List<Map.Entry<String, List<String>>> rest = remaining.subList(1, remaining.size());
        solveCover(rest, newSelected, newUncovered, bestSolution);
        solveCover(rest, selected, uncovered, bestSolution);
    }

   
    private String getMinimalExpression() {
        if (minTermsList.isEmpty()) {
            return (ST.equals("SOP")) ? "0" : "1";
        }
        Set<String> minimalPIs = findMinimalCover();
        if (minimalPIs.isEmpty())
            return (ST.equals("SOP")) ? "0" : "1";

        StringBuilder expr = new StringBuilder();
        for (String pi : minimalPIs) {
            expr.append(SetLastExpression(pi));
            expr.append(ST.equals("SOP") ? " + " : " * ");
        }
        // Remove trailing operator
        if (expr.length() >= 3) {
            expr.setLength(expr.length() - 3);
        }
        return expr.toString();
    }

 
    public void runMinimization() {
        System.out.println("=== Quine-McCluskey Minimizer ===");
        StandardMethod();
        VariableCount();
        MinTerms();
        if (minTermsList.isEmpty()) {
            System.out.println("No minterms to minimize.");
            System.out.println("Expression = " + ((ST.equals("SOP")) ? "0" : "1"));
            return;
        }
        System.out.println("\n--- Original Expression ---");
        System.out.println(SettingExpression());
        System.out.println("\n--- Grouping by Number of Ones/Zeros ---");
        System.out.println(numberOfOnes());
        System.out.println("\n--- Level 1 Combinations ---");
        System.out.println(LevelOne());
        System.out.println("\n--- Level 2 Combinations ---");
        System.out.println(LevelTwo());
        System.out.println("\n--- Level 3 Combinations ---");
        System.out.println(LevelThree());
        System.out.println("\n--- All Prime Implicants ---");
        for (String pi : primeImplicant) {
            System.out.println(pi + " -> " + SetLastExpression(pi));
        }
        System.out.println("\n--- Minimal Expression ---");
        System.out.println(getMinimalExpression());
    }

    public static void main(String[] args) {
        Mcclusky mc = new Mcclusky();
        mc.runMinimization();
    }

}