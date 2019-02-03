package nl.hva.ict.ss.textsearch;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageDetector {
    private String content; // Once an instance is created this will hold the complete content of the file.

    public LanguageDetector(InputStream input) {
        Scanner sc = new Scanner(input);
        StringBuilder fullCode = new StringBuilder();
        sc.useDelimiter("\\A"); // EOF marker
        fullCode.append(sc.next());
        String str  = fullCode.toString().toLowerCase();

        String docs = "";
        String code = "";
        //ONLINE TEST REGEX: \/\*.+?(?=\*\/)

        Pattern commentFinder = Pattern.compile("(?s)/\\*(.)*?\\*/",Pattern.MULTILINE | Pattern.COMMENTS );
        Matcher matcher = commentFinder.matcher(str);

        while (matcher.find()) {
           fullCode.append(matcher.group());
        }
        System.out.println(fullCode);

    }

}


