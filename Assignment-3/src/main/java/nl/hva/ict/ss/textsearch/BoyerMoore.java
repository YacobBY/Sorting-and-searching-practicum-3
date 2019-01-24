
package nl.hva.ict.ss.textsearch;
public class BoyerMoore
{
    private int[] right;
    private String pat;
    BoyerMoore(String pat)
    { // Compute skip table.
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1; // -1 for chars not in pattern
        for (int j = 0; j < M; j++) // rightmost position for
            right[pat.charAt(j)] = j; // chars in pattern
    }
    public int search(String txt)
    { // Search for pattern in txt.
        int tL = txt.length();
        int pL = pat.length();
        int skip;
        for (int i = 0; i <= tL-pL; i += skip)
        { // Does the pattern match the text at position i ?
            skip = 0;
            for (int j = pL-1; j >= 0; j--)
                if (pat.charAt(j) != txt.charAt(i+j))
                {
                    skip = j - right[txt.charAt(i+j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            if (skip == 0) return i; // found.
        }
        return tL; // not found.
    }
    public static void main(String[] args){
        String pat = "lolxd";
        String txt = "aaaaaaalolxdaaqwdasdqw";

        BoyerMoore boyermoore1 = new BoyerMoore(pat);

        int offset1 = boyermoore1.search(txt);

        // print results
        System.out.println("text:    " + txt);
        System.out.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            System.out.print(" ");
        System.out.println(pat);
        System.out.println();
//        System.out.println(" Total comparisons: " + searchComparisons);
    }// See page 769.
}