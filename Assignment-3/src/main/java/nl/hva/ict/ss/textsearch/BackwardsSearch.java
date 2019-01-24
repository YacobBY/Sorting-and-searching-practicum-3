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

    public static int searchComparisons;
    private final int R;     // the radix
    private int[] movementArray;     // the bad-character skip array



    public BackwardsSearch(String pat) {
        searchComparisons = 0;
        this.R = 256;


        // position of rightmost occurrence of c in the pattern
        movementArray = new int[R];
        //Set every possible character to -1
        for (int c = 0; c < R; c++) {
            movementArray[c] = -1;
        }
        int reverseCounter = 0;
        //Set every character to the number of letters it's last occurance from the first pattern character
        for (int j = pat.length() - 1; j >= 0; j--) {
            movementArray[pat.charAt(j)] = reverseCounter;
            System.out.println("letter " + pat.charAt(j) + " value = " + movementArray[pat.charAt(j)]);
            reverseCounter++;
        }
    }



    int findLocation(String needle, String haystack) {
        int textlength = haystack.length();
        int patternLength = needle.length();
        int amountToSkip = 0;
        //Zolang I kleiner is dan de string - needle length (als needle niet uit de max string length gaat)
        //i is de "begin index" van elke comparison
//        for (int i = 0; i <= textlength - patternLength; i += amountToSkip) {
        for (int textIndex = textlength - patternLength; textIndex >= 0; textIndex -= amountToSkip) {
            amountToSkip = 0;
            searchComparisons++;
            //Reverse here
            for (int patternIndex = patternLength - 1; patternIndex >= 0; patternIndex--) {
                System.out.println("Needle letter is " + needle.charAt(patternIndex) + " Haystack letter is " + haystack.charAt(textIndex ));
                System.out.println("Current index is: "+ textIndex + " pattern index is " + patternIndex);
                if (needle.charAt(patternIndex) != haystack.charAt(textIndex )) {

                    searchComparisons++;
                    amountToSkip = Math.max(1, patternIndex - movementArray[haystack.charAt(textIndex + patternIndex)]);
                    System.out.println(needle.charAt(patternIndex) + " "+    haystack.charAt(textIndex + patternIndex) + " Amount to skip is: " + amountToSkip);
                    break;
                }
                else {
                    System.out.println("match found");
                }
            }
            if (amountToSkip == 0) return textIndex;    // found
        }
        return -1;                       // not found
    }

    /**
     * Returns the number of character compares that where performed during the last search.
     * @return the number of character comparisons during the last search.
     */
    int getComparisonsForLastSearch() {
        return 0;
    }
}


