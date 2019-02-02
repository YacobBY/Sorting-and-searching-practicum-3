package nl.hva.ict.ss.textsearch;

import java.util.regex.*;
public class TestClassYacob {

    public static void main(String[] args) {


        String regex = "()";

        Pattern pattern = Pattern.compile(regex);


        System.out.println(pattern.matcher("()"));




    }
}
