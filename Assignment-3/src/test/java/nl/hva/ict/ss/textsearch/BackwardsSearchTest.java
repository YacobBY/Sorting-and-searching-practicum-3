package nl.hva.ict.ss.textsearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackwardsSearchTest {
    protected BackwardsSearch searchEngine;

    @Before
    public void setup() {

    }

    @Test
    public void largeSearch(){
        BackwardsSearch back = new BackwardsSearch("word");

        assertEquals("thistextcontainsa".length(),back.findLocation("word","thistextcontainsaword"));
    }

    @Test
    public void beginOfSearch(){
        BackwardsSearch back = new BackwardsSearch("this");

        assertEquals("".length(),back.findLocation("this","thistextcontainsaword"));
    }

    @Test
    public void middleOfSearch(){
        BackwardsSearch back = new BackwardsSearch("b");

        assertEquals("aaaa".length(),back.findLocation("b","aaaabaaaa"));
    }



    @Test
    public void search() {
        BackwardsSearch back = new BackwardsSearch("needle");

        assertEquals("whatisinhereohitsa".length(),back.findLocation("needle","whatisinhereohitsaneedleow"));

    }



    @Test
    public void findSingleOccurrence() {
        BackwardsSearch back = new BackwardsSearch("needle");


        assertEquals("whereisthe".length(), back.findLocation("needle","whereistheneedleinthishaystack"));
    }
    //needle
    //"whereistheneedleinthishaystack");
    @Test
    public void cantFindOccurrence() {
        int index = searchEngine.findLocation("needle", "thereisnothinginthishaystack");

        assertEquals(-1, index);
    }


}