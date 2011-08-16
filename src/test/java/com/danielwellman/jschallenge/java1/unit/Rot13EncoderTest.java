package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.app.Rot13Encoder;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Rot13EncoderTest {

    private final Rot13Encoder encoder = new Rot13Encoder();

    @Test
    public void convertsASingleCharacterByAdding13Mod26AsciiPositions() {
        assertThat(encoder.encode("A"), is("N"));
        assertThat(encoder.encode("a"), is("n"));
    }

    @Test
    public void wrapsConversionAfterZ() {
        assertThat(encoder.encode("N"), is("A"));
        assertThat(encoder.encode("n"), is("a"));
    }

    @Test
    public void convertsSeveralCharactersInAString() {
        assertThat(encoder.encode("ABC"), is("NOP"));
        assertThat(encoder.encode("dog"), is("qbt"));
    }

    @Test
    public void doesNotConvertSpaces() {
        assertThat(encoder.encode(" "), is(" "));
        assertThat(encoder.encode("  "), is("  "));
    }

    @Test
    public void doesNotConvertPunctuation() {
        assertThat(encoder.encode("."), is("."));
        assertThat(encoder.encode("!"), is("!"));
        assertThat(encoder.encode("["), is("["));
    }

    @Test
    public void doesNotConvertTheEmptyString() {
        assertThat(encoder.encode(""), is(""));
    }
}
