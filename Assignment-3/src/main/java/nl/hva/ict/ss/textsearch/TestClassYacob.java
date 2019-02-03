package nl.hva.ict.ss.textsearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestClassYacob {

    public static void main(String[] args) {

        String str  = "wwwwww/*asdadadadsa\ndasd ****/zzzzzzzz    /*asdadadadsadasd*/";
        
        Pattern commentFinder = Pattern.compile("/\\*[a-z$&+,:;=?@#|'<>.^*()%!-]*\\*/" );
        Matcher matchPhone = commentFinder.matcher(str);

        while (matchPhone.find()) {
            System.out.println(matchPhone.group());
            System.out.println(matchPhone.replaceAll("asdadasd"));

            Pattern reDate = Pattern.compile("([0-9]{1,2}/) ([0-9]{1,2}/) ([0-9]{4})", Pattern.MULTILINE | Pattern.COMMENTS);

        }
    }
}
