package nl.hva.ict.ss.textsearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestClassYacob {

    public static void main(String[] args) {

        String str  = " .............???!!!2222   java 7  is good!     Java 8 is better.     Java 9 is the best?";

        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)      [^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher matchSentence = re.matcher(str);

        while (matchSentence.find()) {
            System.out.println(matchSentence.group());
        }

    }
}
