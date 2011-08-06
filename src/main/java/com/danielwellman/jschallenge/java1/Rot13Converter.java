package com.danielwellman.jschallenge.java1;

import java.util.ArrayList;

public class Rot13Converter {
    private final IoFacade ioFacade;
    private final Encoder encoder;
    private final ArrayList<DecoderListener> listeners = new ArrayList<DecoderListener>();

    public Rot13Converter(IoFacade ioFacade, Encoder encoder) {
        this.ioFacade = ioFacade;
        this.encoder = encoder;
    }

    public void convert(String filename) {
        final String contents = ioFacade.readFile(filename);
        final String encoded = encoder.encode(contents);

        for (DecoderListener listener : listeners) {
            listener.messageDecoded(encoded);
        }
    }

    public void addListener(DecoderListener listener) {
        listeners.add(listener);
    }
}
