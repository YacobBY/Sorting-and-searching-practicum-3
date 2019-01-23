/******************************************************************************
 *  Compilation:  javac BoyerMoore.java
 *  Execution:    java BoyerMoore pattern text
 *  Dependencies: StdOut.java
 *
 *  Reads in two strings, the pattern and the input text, and
 *  searches for the pattern in the input text using the
 *  bad-character rule part of the Boyer-Moore algorithm.
 *  (does not implement the strong good suffix rule)
 *
 *  % java BoyerMoore abracadabra abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:               abracadabra
 *
 *  % java BoyerMoore rab abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:         rab
 *
 *  % java BoyerMoore bcara abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:                                   bcara
 *
 *  % java BoyerMoore rabrabracad abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:                        rabrabracad
 *
 *  % java BoyerMoore abacad abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern: abacad
 *
 ******************************************************************************/

/**
 *  The {@code BoyerMoore} class finds the first occurrence of a pattern string
 *  in a text string.
 *  <p>
 *  This implementation uses the Boyer-Moore algorithm (with the bad-character
 *  rule, but not the strong good suffix rule).
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/53substring">Section 5.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
package nl.hva.ict.ss.textsearch;

public class BoyerMoore {

    public static int searchComparisons;
    private final int R;     // the radix
    private int[] movementArray;     // the bad-character skip array

    private String pat;      // or as a string
    /**
     * Preprocesses the pattern string.
     *
     * @param pat the pattern string
     */

    public BoyerMoore(String pat) {
        searchComparisons = 0;
        this.R = 256;
        this.pat = pat;

        // position of rightmost occurrence of c in the pattern
        movementArray = new int[R];
        //Set every possible character to -1
        for (int c = 0; c < R; c++)
            movementArray[c] = -1;
        //Set every character to the number of letters it's last occurance from the first pattern character
        for (int j = 0; j < pat.length(); j++)
            movementArray[pat.charAt(j)] = j;
    }

    /**
     * Returns the index of the first occurrrence of the pattern string
     * in the text string.
     *
     * @param  txt the text string
     * @return the index of the first occurrence of the pattern string
     *         in the text string; n if no such match
     */
    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i+j)) {
                    searchComparisons++;
                    skip = Math.max(1, j - movementArray[txt.charAt(i+j)]);
                    break;
                }
            }
            if (skip == 0) return i;    // found
        }
        return n;                       // not found
    }
    /**
     * Takes a pattern string and an input string as command-line arguments;
     * searches for the pattern string in the text string; and prints
     * the first occurrence of the pattern string in the text string.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String pat = "lolxd";
        String txt = "aaaaaaalolxd";

        BoyerMoore boyermoore1 = new BoyerMoore(pat);

        int offset1 = boyermoore1.search(txt);

        // print results
        System.out.println("text:    " + txt);
        System.out.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            System.out.print(" ");
        System.out.println(pat);
        System.out.println();
        System.out.println(" Total comparisons: " + searchComparisons);
    }
}
