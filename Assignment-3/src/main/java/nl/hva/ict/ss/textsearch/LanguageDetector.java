package nl.hva.ict.ss.textsearch;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageDetector {
    private String content; // Once an instance is created this will hold the complete content of the file.
    private String code;
    private String docs;
    private int letterCount[];

    public LanguageDetector(InputStream input) {
        Scanner sc = new Scanner(input);
        sc.useDelimiter("\\Z"); // EOF marker
        content = (sc.next());
        separateDocsFromCode();
//        alphabetCounter();

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

    public void methodCounter(){
//public|private|protected|static|final|native|synchronized|abstract|transient|if|while|for
//remove alle zinnen met public|static|void|if|for|while TOT het  eerste "(" teken in die zin
        //(while|for|do|if|public|static|private|protected)
        //   (while|for|do|if|public|static|private|protected)(.*?)(\()(.*?)(\(|;)   (converteer dit nog wel ff naar java)
        Pattern nontMethodCall = Pattern.compile("(?s)/\\*(.)*?\\*/", Pattern.MULTILINE | Pattern.COMMENTS);


    }







    public void alphabetCounter() {
        ArrayList<String> characters = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        int totalLetters = 0;
        String lettersInCountingOrder = "";
        //Makes array with 123 slots, only 97 to 122 will be used
        letterCount = new int[123];
        for (int i = 0; i < 123; i++) {
            letterCount[i] = 0; // -1 for chars not in pattern
//            System.out.println(letterCount[i]);
        }
        for (int i = 'a'; i <= 'z'; i++) {
            Pattern letterPattern = Pattern.compile("" + (char) i, Pattern.MULTILINE | Pattern.COMMENTS);
            Matcher letterMatcher = letterPattern.matcher(docs);
            while (letterMatcher.find()) {
                letterCount[i]++;
            }
            System.out.println(letterCount[i]);
        }

        while (true) {
            int biggestNumber = 0;
            int biggestIndex = 0;
            for (int i = 0; i < 123; i++) {
                if (letterCount[i] > biggestNumber) {
                    biggestIndex = i;
                    biggestNumber = letterCount[i];
                }
            }

            if (biggestNumber > 0) {
                totalLetters += biggestNumber;
                characters.add("" + (char) biggestIndex);
                count.add(biggestNumber);
                lettersInCountingOrder += "" + (char) biggestIndex;

                letterCount[biggestIndex] = 0;
                System.out.println(lettersInCountingOrder);
            } else {
//                System.out.println(lettersInCountingOrder);
                break;
            }
        }
        System.out.println(totalLetters);
        LanguageList langTemp = new LanguageList();
        LanguageList langFinal = new LanguageList();

        System.out.println(langTemp.languageLettersList.size());
        ArrayList<LanguageLetters> languageList = langTemp.languageLettersList;
        ArrayList<LanguageLetters> finalList = langFinal.languageLettersList;

        ArrayList<LanguageLetters> toRemove = new ArrayList<>();
        //while there are languageList left
        int listCounter = 0;
        int langsize = languageList.size();
        while (toRemove.size() < langsize) {
            for (LanguageLetters language : languageList) {
                if (language.getLetters().charAt(listCounter) != lettersInCountingOrder.charAt(listCounter)) {
                    System.out.println("Next letter is: " + lettersInCountingOrder.charAt(listCounter));
                    System.out.println("removing " + language.getLanguage());
                    toRemove.add(language);
                }
            }
            //Copies language list with entries inside of it into the final list
            finalList.clear();
            finalList.addAll(languageList);

            languageList.removeAll(toRemove);

            listCounter++;
            if (languageList.size() < 1) {

                System.out.println("Languages left: ");
                for (LanguageLetters language : finalList) {
                    System.out.println(language.getLanguage());
                }
                break;
            }
        }
        System.out.println("Now printing all characters with their percentage of occurance");
        for (int i = 0; i < characters.size(); i++) {

            Double c = Double.valueOf(count.get(i));
            Double total = Double.valueOf(totalLetters);
            System.out.println(characters.get(i) + " occurred " + (c / total) * 100 + "%");
        }
    }


}
//a = 97
//z = 122
