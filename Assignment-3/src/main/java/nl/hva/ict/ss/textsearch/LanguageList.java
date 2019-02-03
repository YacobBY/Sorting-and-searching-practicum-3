package nl.hva.ict.ss.textsearch;

import java.util.ArrayList;

public class LanguageList {
    public ArrayList<Language> languageList;

    public LanguageList() {
        //source: https://en.wikipedia.org/wiki/Letter_frequency
        languageList.add(new Language("English", "etaoinshrdlcumwfgypbvkjxqzüäößàâáåã"));
        languageList.add(new Language("French", "esaitnruoldcmpvéqfbghjàxzèêyçkûùâwî"));
        languageList.add(new Language("German", "ensriatdhulgcomwbfkzüvpäößjyxqéàèêç"));
        languageList.add(new Language("Spanish", "eaosrnidltcmupbgvyqóíhfájzéñxúwükäö"));
        languageList.add(new Language("Portuguese", "aeosridmntculpvgqbfhãôâçzêjéóxúíáàõ"));
        languageList.add(new Language("Esperanto", "aieonlsrtkjudmpvgfbcĝĉŭzŝhĵĥqãôâçêé"));
        languageList.add(new Language("Italian", "eaionlrtscdpumvgzfbhàqèúwíyjkxòĝĉŭŝ"));
        languageList.add(new Language("Turkish", "aeinrlkdımytusobüşzcghçğvpöfjàqèúwí"));
        languageList.add(new Language("Swedish", "eanrtsildomkgvhfupäbcåöyjxwzqıüşçğà"));
        languageList.add(new Language("Polish", "aieonwrszcdyklmtpłujbgóęhśćżąńfźvxä"));
        languageList.add(new Language("Dutch", "enatirodslgvhkmubpwjzcfxyqłóęśćżąńź"));
        languageList.add(new Language("Danish", "erntaidslogkmfvbuphåøæjycwzxqóíáéñú"));
        languageList.add(new Language("Icelandic", "arniestulðgmkfvohádíþjbóyæpöéúýxåøc"));
        languageList.add(new Language("Finnish", "aintesloukämrvjhpydögbcfwzxqåðáíþóæ"));
        languageList.add(new Language("Czech", "aeonitvsrldkmupízjhěyýábcžšéčřůgfúx"));
    }
}