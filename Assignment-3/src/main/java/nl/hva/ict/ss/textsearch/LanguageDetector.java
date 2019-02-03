package nl.hva.ict.ss.textsearch;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageDetector {
    private String content; // Once an instance is created this will hold the complete content of the file.

    public LanguageDetector(InputStream input) {
        Scanner sc = new Scanner(input);
        sc.useDelimiter("\\Z"); // EOF marker
        content = (sc.next());
        String code  = content.toLowerCase();

        StringBuilder docs = new StringBuilder();

        Pattern commentFinder = Pattern.compile("(?s)/\\*(.)*?\\*/",Pattern.MULTILINE | Pattern.COMMENTS );
        Matcher matcher = commentFinder.matcher(code);
        Matcher matcher2 = commentFinder.matcher(code);

        while (matcher.find()) {
            docs.append(matcher.group());
        }
        while (matcher2.find()) {
            code = matcher.replaceAll("");
        }

        System.out.println(docs);
        System.out.println("-----------------------------");
        System.out.println(code);

    }

}


