package com.zx.demo.aync;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class DefaultListenerFunture<V> extends FutureTask<V> implements ListenerFuture<V> {

    public DefaultFutureListeners listeners = new DefaultFutureListeners();

    public DefaultListenerFunture(Callable<V> callable) {
        super(callable);
    }

    public DefaultListenerFunture(Runnable runnable, V result) {
        super(runnable, result);
    }

    @Override
    public void addListener(Listener<? extends Future<? super V>>... listeners) {
        for (Listener<? extends Future<? super V>> listener : listeners) {
            this.listeners.addListener(listener);
        }
    }

    @Override
    protected void done() {
        super.done();
        List<Listener> listeners = this.listeners.listeners();
        for (int i = 0; i < listeners.size(); i++) {
            notifyListener0(this, listeners.get(i));
        }
    }

    public void notifyListener0(Future f, Listener l) {
        try {
            l.operationComplete(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
