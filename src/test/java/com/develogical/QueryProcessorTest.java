package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutMyTeam() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("PriyaDiella"));
    }

    @Test
    public void knowsAboutLargest() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 453, 26"), containsString("453"));
    }

    @Test
    public void knowsMathAdd() throws Exception {
        assertThat(queryProcessor.process("what is 5 plus 19"), containsString("24"));
    }

    @Test
    public void knowsMathMultiply() throws Exception {
        assertThat(queryProcessor.process("what is 8 multiplied by 10"), containsString("80"));
    }

    @Test
    public void knowsYearInWhichTheresaBecamePM() throws Exception {
        assertThat(queryProcessor.process("which year was Theresa May first elected as Prime Minister of Great Britain"), containsString("2016"));
    }

    @Test
    public void knowsNumbersBothSquareAndCube() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 836, 1000000, 210, 36"), containsString("1000000"));
    }


    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
