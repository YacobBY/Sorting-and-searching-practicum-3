package nl.hva.ict.ss.textsearch;
/*Yacob commentary:
Booyer moore original is van Sedgewick and Wayne page 772 en 769:
ALGORITHM 5.7 Boyer-Moore substring search (mismatched character heuristic
*/
public class BackwardsSearch {
    /**
     * Returns index of the right most location where <code>needle</code> occurs within <code>haystack</code>. Searching
     * starts at the right end side of the text (<code>haystack</code>) and proceeds to the first character (left side).
     *
     * @param needle the text to search for.
     * @param haystack the text which might contain the <code>needle</code>.
     * @return -1 if the <code>needle</code> is not found and otherwise the left most index of the first
     * character of the <code>needle</code>.
     */

    public static int searchComparisons;
    private final int R;     // the radix
    private int[] skipArr;     // the bad-character skip array


    public BackwardsSearch(String pat) {
        searchComparisons = 0;
        this.R = 256;

        // position of rightmost occurrence of c in the pattern
        skipArr = new int[R];
        //Set every possible character to -1
        for (int c = 0; c < R; c++) {
            skipArr[c] = -1;
        }
        int reverseCounter = 0;
        //Set every character to the number of letters it's last occurance from the first pattern character
        for (int j = pat.length() - 1; j >= 0; j--) {
            skipArr[pat.charAt(j)] = reverseCounter;
            System.out.println("letter " + pat.charAt(j) + " value = " + skipArr[pat.charAt(j)]);
            reverseCounter++;
        }
    }


    int findLocation(String needle, String haystack) {
        String pattern = needle;
        String text = haystack;
        int textlength = text.length();
        int patternLength = pattern.length();
        int amountToSkip = 0;
        //Begin aan het einde ipv begin                                    Amount to skip is subtracted ipv added
        for (int textIndex = textlength - patternLength; textIndex >= 0; textIndex -= amountToSkip) {
            amountToSkip = 0;
            //Reverse here
//

            for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
                System.out.println("Needle  " + pattern.charAt(patternIndex) + " Haystack   " + text.charAt(textIndex));
                System.out.println("Text index: " + textIndex + " Pattern index " + patternIndex);
                searchComparisons++;

                if (pattern.charAt(patternIndex) != text.charAt(textIndex+patternIndex)) {
                    amountToSkip =  (patternLength-1) - skipArr[text.charAt(textIndex + patternIndex)];
                    if (amountToSkip < 1) amountToSkip = 1;
                    System.out.println("Skip amount: "+ amountToSkip );
                    break;
                } else {
                    System.out.println("MATCH FOUND--------");

                }
            }
            System.out.println("amount of comparisons done is: "+searchComparisons);
            if (amountToSkip == 0) return textIndex;    // found
        }

        return -1;                       // not found
    }

    /**
     * Returns the number of character compares that where performed during the last search.
     *
     * @return the number of character comparisons during the last search.
     */
    int getComparisonsForLastSearch() {
        return 0;
    }
}


