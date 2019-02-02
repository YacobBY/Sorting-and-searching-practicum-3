package nl.hva.ict.ss.textsearch;

import java.io.InputStream;
import java.util.Scanner;

public class LanguageDetector {

    public StringBuilder docs = new StringBuilder();

    public LanguageDetector(InputStream input) {
        docs.append("");
        Scanner sc = new Scanner(input);

        StringBuilder docs = new StringBuilder();
        StringBuilder code = new StringBuilder();


        //Dit geeft code tot begin comments
        addComments(input);
////        addComments(input);
////        System.out.println(docs);

        //Dit geeft tot eind comments
//        sc.useDelimiter("\\*/"); // EOF marker
////        System.out.println(sc.next());
//        docs.append(sc.next());

        System.out.println(docs);

    }
        public void addComments(InputStream input){
            Scanner sc = new Scanner(input);
            sc.useDelimiter("\\*/"); // EOF marker
            docs.append(sc.next());
        }
}



