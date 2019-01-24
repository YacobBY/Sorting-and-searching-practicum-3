package nl.hva.ict.ss.textsearch;

public class BoyerMoore {
    private int[] right;
    private String pat;

    BoyerMoore(String pat) { // Compute skip table.
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1; // -1 for chars not in pattern
        for (int j = 0; j < M; j++) { // rightmost position for
            right[pat.charAt(j)] = j; // chars in pattern
            System.out.println("letter " + pat.charAt(j) + " value = " + right[pat.charAt(j)]);
        }
    }

    public static void main(String[] args) {
        String pat = "needle";
        String txt = "whereistheaaaaneedleinthishaystack";

        BoyerMoore boyermoore1 = new BoyerMoore(pat);

        int offset1 = boyermoore1.search(txt);
        System.out.println(offset1);
        // print results
        System.out.println("text:    " + txt);
        System.out.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            System.out.print(" ");
        System.out.println(pat);
        System.out.println();
//        System.out.println(" Total comparisons: " + searchComparisons);
    }// See page 769.

    public int search(String txt) { // Search for pattern in txt.
        int tL = txt.length();
        int pL = pat.length();
        int skip;
        for (int i = 0; i <= tL - pL; i += skip) { // Does the pattern match the text at position i ?
            skip = 0;

            for (int j = pL - 1; j >= 0; j--) {

                System.out.println("Skipped "+skip);
                System.out.println("needle: " + pat.charAt(j) + " Haystack: " + txt.charAt(i+j));
                System.out.println("Current index is: " + i + " pattern index is " + j);
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    //counter++
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    System.out.println("Skip amount is: "+ skip );
                    break;
                }
                else {
                    System.out.println(j);
                }
            }
            if (skip == 0) return i; // found.
        }
        return tL; // not found.
    }
}