package nl.hva.ict.ss.textsearch;

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
            searchComparisons++;
            //Reverse here
//            for (int j = M-1; j >= 0; j--)
            for (int patternIndex = 0; patternIndex <= patternLength - 1; patternIndex++) {
                System.out.println("Needle letter is " + pattern.charAt(patternIndex) + " Haystack letter is " + text.charAt(textIndex));
                System.out.println("Current index is: " + textIndex + " pattern index is " + patternIndex);
                if (pattern.charAt(patternIndex) != text.charAt(textIndex+patternIndex)) {
                    searchComparisons++;

                    amountToSkip = Math.max(1, patternLength - skipArr[text.charAt(textIndex + patternIndex)]);
                    System.out.println(pattern.charAt(patternIndex) + " " + text.charAt(textIndex + patternIndex) + " To skip is: " + amountToSkip);
                    break;
                } else {
                    System.out.println("match found");

                }
            }
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


