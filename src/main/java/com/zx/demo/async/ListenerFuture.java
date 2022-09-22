package com.zx.demo.async;

import java.util.concurrent.Future;

public interface ListenerFuture<V> extends Future<V> {

    public void addListener(Listener<? extends Future<? super V>>... listener);

}
