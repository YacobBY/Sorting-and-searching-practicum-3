package nl.hva.ict.ss.textsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoyerMooreTest {

    /*template
     @Test
    public void search() {
        BoyerMoore boy = new BoyerMoore("");

        assertEquals("".length(),boy.search(""));

    }
     */

    @Test
    public void search() {
        BoyerMoore boy = new BoyerMoore("needle");

        assertEquals("whatisinhereohitsa".length(),boy.search("whatisinhereohitsaneedleow"));

    }

    @Test
    public void endOfSearch(){
        BoyerMoore boy = new BoyerMoore("word");

        assertEquals("thistextcontainsa".length(),boy.search("thistextcontainsaword"));
    }

    @Test
    public void beginOfSearch(){
        BoyerMoore boy = new BoyerMoore("this");

        assertEquals("".length(),boy.search("thistextcontainsaword"));
    }

    @Test
    public void middleOfSearch(){
        BoyerMoore boy = new BoyerMoore("b");

        assertEquals("aaaa".length(),boy.search("aaaabaaaa"));
    }

    @Test
    public void bigMiddleOfSearch(){
        BoyerMoore boy = new BoyerMoore("nes");

        assertEquals( "Thisstringcontainsalotlotlotoftextlikeaveryseriouslylargeamountoftextthesearchengi".length(),boy.search("Thisstringcontainsalotlotlotoftextlikeaveryseriouslylargeamountoftextthesearchengineswillhavetoperformalotofcomparisonsinordertofindthewordthatishiddenwithinthistext"));
    }



}