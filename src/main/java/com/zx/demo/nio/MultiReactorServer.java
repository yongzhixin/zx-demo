package com.zx.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiReactorServer {

    ServerSocketChannel serverSocket;
    AtomicInteger next = new AtomicInteger(0);
    Selector[] selectors = new Selector[2];
    SubReactor[] subReactors = null;

    MultiReactorServer() throws IOException {
        selectors[0] = Selector.open();
        selectors[1] = Selector.open();
        serverSocket = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocket.socket().bind(address);
        serverSocket.configureBlocking(false);
        SelectionKey sk = serverSocket.register(selectors[0], SelectionKey.OP_ACCEPT);
        sk.attach(new AcceptorHandler());
        subReactors = new SubReactor[]{new SubReactor(selectors[0]), new SubReactor(selectors[1])};
    }

    public void start() {
        new Thread(subReactors[0]).start();
        new Thread(subReactors[1]).start();
    }

    class SubReactor implements Runnable {
        final Selector selector;

        public SubReactor(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    selector.select();
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        dispatch(key);
                    }
                    keys.clear();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void dispatch(SelectionKey key) {
            Runnable handler = (Runnable) key.attachment();
            if (handler != null) {
                handler.run();
            }
        }

    }

    class AcceptorHandler implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel channel = serverSocket.accept();
                if (channel != null) {
                    new MultiIOHandler(selectors[1], channel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

class MultiIOHandler implements Runnable {

    final SocketChannel channel;
    final SelectionKey key;

    static ExecutorService POOL = Executors.newFixedThreadPool(8);

    MultiIOHandler(Selector selector, SocketChannel channel) throws IOException {
        this.channel = channel;
        this.channel.configureBlocking(false);
        this.key = this.channel.register(selector, 0);
        key.attach(this);
        key.interestOps(SelectionKey.OP_READ);
        selector.wakeup();

    }

    @Override
    public void run() {
        POOL.submit(() -> asyncRun());
    }

    void asyncRun() {

    }
}