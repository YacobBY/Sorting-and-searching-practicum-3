package nl.hva.ict.ss.textsearch;

import java.io.InputStream;
import java.util.Scanner;

public class LanguageDetector {
    private String content; // Once an instance is created this will hold the complete content of the file.

    public LanguageDetector(InputStream input) {
        Scanner sc = new Scanner(input);
        String docs;
        String code;
        //Dit geeft volgende docs stuk
        sc.useDelimiter("\\*/"); // EOF marker
        System.out.println(sc.next());


        System.out.println("-------------------------------------------------------------------------------------------------ASASAS");

        //Dit geeft volgende code stuk
        sc.useDelimiter("/\\*"); // EOF marker
        System.out.println(sc.next());


        sc.useDelimiter("\\*/"); // EOF marker
        System.out.println(sc.next());
    }
//    public String docsPrint (){
//
//       return content;
//    }

//    public String findNextDocs(String docs)



}
