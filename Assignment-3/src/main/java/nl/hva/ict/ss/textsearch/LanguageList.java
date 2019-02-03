package nl.hva.ict.ss.textsearch;

import java.util.ArrayList;

public class LanguageList {
    public ArrayList<LanguageLetters> languageLettersList = new ArrayList<>();

    public LanguageList() {
        //source: https://en.wikipedia.org/wiki/Letter_frequency
        languageLettersList.add(new LanguageLetters("English", "etaoinshrdlcumwfgypbvkjxqzüäößàâáåã"));
        languageLettersList.add(new LanguageLetters("French", "esaitnruoldcmpvéqfbghjàxzèêyçkûùâwî"));
        languageLettersList.add(new LanguageLetters("German", "ensriatdhulgcomwbfkzüvpäößjyxqéàèêç"));
        languageLettersList.add(new LanguageLetters("Spanish", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö"));
        languageLettersList.add(new LanguageLetters("Portuguese", "aeosridmntculpvgqbfhãôâçzêjéóxúíáàõ"));
        languageLettersList.add(new LanguageLetters("Esperanto", "aieonlsrtkjudmpvgfbcĝĉŭzŝhĵĥqãôâçêé"));
        languageLettersList.add(new LanguageLetters("Italian", "eaionlrtscdpumvgzfbhàqèúwíyjkxòĝĉŭŝ"));
        languageLettersList.add(new LanguageLetters("Turkish", "aeinrlkdımytusobüşzcghçğvpöfjàqèúwí"));
        languageLettersList.add(new LanguageLetters("Swedish", "eanrtsildomkgvhfupäbcåöyjxwzqıüşçğà"));
        languageLettersList.add(new LanguageLetters("Polish", "aieonwrszcdyklmtpłujbgóęhśćżąńfźvxä"));
        languageLettersList.add(new LanguageLetters("Dutch", "enatirodslgvhkmubpwjzcfxyqłóęśćżąńź"));
        languageLettersList.add(new LanguageLetters("Danish", "erntaidslogkmfvbuphåøæjycwzxqóíáéñú"));
        languageLettersList.add(new LanguageLetters("Icelandic", "arniestulðgmkfvohádíþjbóyæpöéúýxåøc"));
        languageLettersList.add(new LanguageLetters("Finnish", "aintesloukämrvjhpydögbcfwzxqåðáíþóæ"));
        languageLettersList.add(new LanguageLetters("Czech", "aeonitvsrldkmupízjhěyýábcžšéčřůgfúx"));
    }
}