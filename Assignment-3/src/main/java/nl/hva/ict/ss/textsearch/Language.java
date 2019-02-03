package nl.hva.ict.ss.textsearch;
public class Language {

    private String language;
    private String letters;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public Language(String language, String commonLetters){
        this.language = language;
        this.letters = commonLetters;

    }
}
