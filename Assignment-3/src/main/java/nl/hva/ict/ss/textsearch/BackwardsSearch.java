package nl.hva.ict.ss.textsearch;

public class BackwardsSearch {
    /**
     * Returns index of the right most location where <code>needle</code> occurs within <code>haystack</code>. Searching
     * starts at the right end side of the text (<code>haystack</code>) and proceeds to the first character (left side).
     * @param needle the text to search for.
     * @param haystack the text which might contain the <code>needle</code>.
     * @return -1 if the <code>needle</code> is not found and otherwise the left most index of the first
     * character of the <code>needle</code>.
     */

    private final int R;     // the radix
    private int[] right;     // the bad-character skip array

    private char[] pattern;  // store the pattern as a character array
    private String pat;      // or as a string
    private int searchComparisons = 0;
    public BackwardsSearch(String pat) {

        this.R = 256;
        this.pat = pat;

        // position of rightmost occurrence of c in the pattern
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pat.length(); j++)
            right[pat.charAt(j)] = j;
    }










    int findLocation(String needle, String haystack) {
        return -1;
    }

    /**
     * Returns the number of character compares that where performed during the last search.
     * @return the number of character comparisons during the last search.
     */
    int getComparisonsForLastSearch() {
        return 0;
    }
}


