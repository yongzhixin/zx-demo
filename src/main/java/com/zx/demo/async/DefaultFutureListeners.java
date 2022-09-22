package com.zx.demo.async;

import java.util.ArrayList;
import java.util.List;

public final class DefaultFutureListeners {

    private List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public List<Listener> listeners() {
        return listeners;
    }

}
