import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
public class Mcclusky {
    Scanner sc = new Scanner(System.in);
    //--Task 1: Standard Method Selection
    String StandardMethod() {
        int ch = 0;
        System.out.println("Choose Your Standard Method(1.SOP/2.POS)");
        ch = sc.nextInt();

        switch (ch) {
            case 1:
                return "Sum of Product";
            case 2:
                return "Product of Sum";
            default:
                System.out.println("Invalid Choice");
                return "Invalid";
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
        return inputArray;
    }
}