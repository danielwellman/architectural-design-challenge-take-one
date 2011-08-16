package com.danielwellman.jschallenge.java1;

import java.util.ArrayList;
import java.util.Collection;

public class ConverterApplication {
    private final Encoder encoder;
    private final Collection<DecoderListener> listeners = new ArrayList<DecoderListener>();

    public ConverterApplication(Encoder encoder) {
        this.encoder = encoder;
    }

    public void addListener(DecoderListener listener) {
        listeners.add(listener);
    }

    public void convert(InputReader inputFile) {
        final String contents = inputFile.read();
        final String encoded = encoder.encode(contents);

        for (DecoderListener listener : listeners) {
            listener.messageDecoded(encoded);
        }
    }
}
