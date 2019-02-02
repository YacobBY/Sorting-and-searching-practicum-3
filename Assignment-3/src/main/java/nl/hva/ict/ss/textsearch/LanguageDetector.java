package nl.hva.ict.ss.textsearch;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageDetector {
    private String content; // Once an instance is created this will hold the complete content of the file.

    public LanguageDetector(InputStream input) {
        Scanner sc = new Scanner(input);
        StringBuilder docs = new StringBuilder();
        sc.useDelimiter("78"); // EOF marker
        docs.append(sc.next());

        String str  = "wwwwww/*asdadadadsa\ndasd ****/zzzzzzzz    /****asdadadadsadasd*/";

        Pattern commentFinder = Pattern.compile("/\\*[a-z$&+,:;=?@#|'<>.^*()%!\\w\\d\\s\\t\\n\\r-]*\\*/" );
        Matcher matchPhone = commentFinder.matcher(str);

        while (matchPhone.find()) {
            System.out.println(matchPhone.group());
            System.out.println("--------------------------------------");
         

        }
    }
//    Pattern reDate = Pattern.compile("([0-9]{1,2}/) ([0-9]{1,2}/) ([0-9]{4})", Pattern.MULTILINE | Pattern.COMMENTS);
//String str  = docs.toString();
//    String text = str.replace("\n", "").replace("\r", "");
//        System.out.println(text);
}


