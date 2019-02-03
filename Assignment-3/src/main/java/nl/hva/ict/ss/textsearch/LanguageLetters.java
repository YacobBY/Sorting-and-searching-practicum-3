package nl.hva.ict.ss.textsearch;

public class LanguageLetters {

    private String language;
    private String letters;

    public LanguageLetters(String language, String commonLetters) {
        this.language = language;
        this.letters = commonLetters;

    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
