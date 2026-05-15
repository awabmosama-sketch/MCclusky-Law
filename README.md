# Quine-McCluskey (Tabular Method) Simplifier

A robust Java implementation of the **Quine-McCluskey algorithm** used to minimize Boolean expressions. This tool automates the process of finding Prime Implicants through a multi-level grouping method, supporting both **SOP** and **POS** forms for up to 4 variables ($A, B, C, D$).

---

## 🚀 Features

*   **Dual Mode Logic:** Supports **Sum of Products (SOP)** for minterms and **Product of Sums (POS)** for maxterms.
*   **Automated Weight Grouping:** Groups terms by the number of high bits (ones) or low bits (zeros).
*   **Iterative Reduction:** 
    *   **Level 1-3 Processing:** Systematically compares binary strings and introduces "Don't Care" ($x$) markers for differing bits.
    *   **Prime Implicant Identification:** Tracks unmatched terms throughout the levels to ensure no prime implicant is lost.
*   **Algebraic Output:** Converts final binary patterns back into human-readable Boolean notation (e.g., $AB' + CD$).

---

## 🛠️ How It Works

The program follows the standard Tabular Minimization workflow:

1.  **Method Selection:** Choose between SOP or POS minimization.
2.  **Signal Input:** Provide 16 input signals (0 or 1) representing the truth table result for each minterm ($m_0$ to $m_{15}$).
3.  **Binary Mapping:** The code maps minterm indices to 4-bit binary strings using an internal `FixTable`.
4.  **Tabular Reduction:** 
    *   The algorithm compares terms across groups.
    *   If two terms differ by exactly one bit, they are combined, and that bit is replaced with an `x`.
5.  **Final Expression:** The `BeforeLastExpression` method compiles the remaining prime implicants into the simplified Boolean result.

---

## 📂 Code Structure

| Method | Task | Description |
| :--- | :--- | :--- |
| `StandardMethod()` | Task 1 | User chooses between SOP (1) or POS (2). |
| `VariableCount()` | Task 2 | Collects the 16 truth table outputs. |
| `MinTerms()` | Task 3 | Identifies which minterms are active based on the method. |
| `SettingExpression()`| Task 4 | Maps minterms to their initial variables (A, B, C, D). |
| `numberOfOnes()` | Task 5 | Groups binary strings by weight for comparison. |
| `LevelOne/Two/Three`| Task 6/7 | Performs the recursive reduction logic. |
| `SetLastExpression()`| Final | Formats the final simplified prime implicants. |

---

## 💻 Usage

### Prerequisites
*   **Java Development Kit (JDK) 8+**

### Execution
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/yourusername/mcclusky-simplifier.git](https://github.com/yourusername/mcclusky-simplifier.git)
