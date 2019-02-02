package nl.hva.ict.ss.textsearch;

import java.io.InputStream;
import java.util.Scanner;

public class LanguageDetector {
    private String content; // Once an instance is created this will hold the complete content of the file.

    public LanguageDetector(InputStream input) {
        Scanner sc = new Scanner(input);

        StringBuilder docs = new StringBuilder();
        StringBuilder code = new StringBuilder();
        String niks;

        //Dit geeft code tot begin comments
        sc.useDelimiter("/\\*"); // EOF marker
         niks= sc.next();
//        System.out.println("aaaa");
//        System.out.println(sc.next());

        //Dit geeft tot eind comments
        sc.useDelimiter("\\*/"); // EOF marker
//        System.out.println(sc.next());
        docs.append(sc.next());

        System.out.println(docs);

    }
        public String addComments(String input){
            Scanner sc = new Scanner(input);
            sc.useDelimiter("\\*/"); // EOF marker

       return  sc.next();
        }

//    public String docsPrint (){
//
//       return content;
//    }

//    public String findNextDocs(String docs)


}
