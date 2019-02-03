package nl.hva.ict.ss.textsearch;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageDetector {
    private String content; // Once an instance is created this will hold the complete content of the file.
    private String code;
    private String docs;
    private int letterCount[];
    private String commonLetters;

    public LanguageDetector(InputStream input) {
        Scanner sc = new Scanner(input);
        sc.useDelimiter("\\Z"); // EOF marker
        content = (sc.next());
        separateDocsFromCode();
        alphabetCounter();
        commonLetters = "";
    }

    public void separateDocsFromCode() {
        code = content.toLowerCase();
        StringBuilder docsBuilder = new StringBuilder();
        Pattern commentFinder = Pattern.compile("(?s)/\\*(.)*?\\*/", Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher matcher = commentFinder.matcher(code);
        Matcher matcher2 = commentFinder.matcher(code);
        while (matcher.find()) {
            docsBuilder.append(matcher.group());
        }
        while (matcher2.find()) {
            code = matcher.replaceAll("");
        }
        docs = docsBuilder.toString();
//        System.out.println(docs);
//        System.out.println("-----------------------------");
//        System.out.println(code);
    }

    public void alphabetCounter() {
        //Makes array with 123 slots, only 97 to 122 will be used
        letterCount = new int[123];
        for (int i = 0; i < 123; i++) {
            letterCount[i] = 0; // -1 for chars not in pattern
//            System.out.println(letterCount[i]);
        }
        System.out.println("----------------------");
        for (int i = 'a'; i <= 'z'; i++) {
            Pattern letterPattern = Pattern.compile("" + (char) i, Pattern.MULTILINE | Pattern.COMMENTS);
            Matcher letterMatcher = letterPattern.matcher(docs);

            while (letterMatcher.find()) {
                letterCount[i]++;
            }
            System.out.println(letterCount[i]);
        }
        while (true) {
            int biggestIndex = 0;
            for (int i = 0; i < 123; i++) {
                System.out.println(letterCount[i]);
                if (letterCount[i] > biggestIndex) {
                    biggestIndex = i;
                }
            }


            if (letterCount[biggestIndex] >0 ){
                System.out.println(commonLetters);
                commonLetters+= ""+(char)biggestIndex;
                letterCount[biggestIndex] = 0;
            }

            else {
                System.out.println(commonLetters);
                break;
            }
        }

    }


}
//a = 97
//z = 122
