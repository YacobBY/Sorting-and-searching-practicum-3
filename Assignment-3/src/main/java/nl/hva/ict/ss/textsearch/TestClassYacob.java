package nl.hva.ict.ss.textsearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestClassYacob {

    public static void main(String[] args) {

        String str  = " asdasdas /*asdadadadsadasd*/ saasdadada";

        Pattern rePhone = Pattern.compile("/\\*[a-z]*\\*/" );
        Matcher matchPhone = rePhone.matcher(str);

        while (matchPhone.find()) {

            System.out.println(matchPhone.group());
        }
    }
}
