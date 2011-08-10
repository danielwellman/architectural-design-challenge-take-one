package com.danielwellman.jschallenge.java1;

import java.util.ArrayList;

public class Rot13Converter {
    private final IoReader ioReader;
    private final Encoder encoder;
    private final ArrayList<DecoderListener> listeners = new ArrayList<DecoderListener>();

    public Rot13Converter(IoReader ioReader, Encoder encoder) {
        this.ioReader = ioReader;
        this.encoder = encoder;
    }

    public void convert(String filename) {
        final String contents = ioReader.readFile(filename);
        final String encoded = encoder.encode(contents);

        for (DecoderListener listener : listeners) {
            listener.messageDecoded(encoded);
        }
    }

    public void addListener(DecoderListener listener) {
        listeners.add(listener);
    }
}
