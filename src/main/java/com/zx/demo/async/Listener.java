package com.zx.demo.async;

import java.util.concurrent.Future;

public interface Listener<F extends Future<?>> {

    void operationComplete(F future) throws Exception;

}
