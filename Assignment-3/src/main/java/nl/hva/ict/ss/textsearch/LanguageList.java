package nl.hva.ict.ss.textsearch;

import java.util.ArrayList;

public class LanguageList {
    public ArrayList<Language> languageList;

    public LanguageList() {
        //source: https://en.wikipedia.org/wiki/Letter_frequency
        languageList.add(new Language("English", "etaoinshrdlcumwfgypbvkjxqzüäößàâáåã"));
        languageList.add(new Language("French", "esaitnruoldcmpvéqfbghjàxzèêyçkûùâwî "));
        languageList.add(new Language("German", "ensriatdhulgcomwbfkzüvpäößjyxqéàèêç "));
        languageList.add(new Language("Spanish", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Portuguese", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Esperanto", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Italian", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Turkish", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Polish", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Dutch", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Icelandic", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Finnish", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));
        languageList.add(new Language("Czech", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö "));

    }

}