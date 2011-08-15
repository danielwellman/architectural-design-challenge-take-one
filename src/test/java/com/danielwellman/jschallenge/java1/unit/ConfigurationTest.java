package com.danielwellman.jschallenge.java1.unit;

import com.danielwellman.jschallenge.java1.Configuration;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ConfigurationTest {

    public static final String TESTMODE_PROPERTY_NAME = "challenge.testmode";

    @Before
    public void clearSystemProperty() {
        System.clearProperty(TESTMODE_PROPERTY_NAME);
    }

    @Test
    public void defaultsToProduction() {
        String path = new Configuration().path();
        assertThat(path, is("production"));
    }

    @Test
    public void usesTestPathWhenPropertyPresent() {
        System.setProperty(TESTMODE_PROPERTY_NAME, "true");
        String path = new Configuration().path();
        assertThat(path, is("test_folder"));
    }
}
