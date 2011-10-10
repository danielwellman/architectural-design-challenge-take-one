package com.danielwellman.jschallenge.java1;

import java.util.ArrayList;
import java.util.Collection;

public class ConverterApplication {
    private final Encoder encoder;
    private final Collection<EncoderListener> listeners = new ArrayList<EncoderListener>();

    public ConverterApplication(Encoder encoder) {
        this.encoder = encoder;
    }

    public void addListener(EncoderListener listener) {
        listeners.add(listener);
    }

    public void convert(InputReader inputFile) {
        final String contents = inputFile.read();
        final String encoded = encoder.encode(contents);

        for (EncoderListener listener : listeners) {
            listener.messageEncoded(encoded);
        }
    }
}
