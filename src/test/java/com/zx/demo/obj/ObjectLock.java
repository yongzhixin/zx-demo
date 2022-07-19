package com.zx.demo.obj;

import com.itlgl.java.util.ByteUtils;
import junit.framework.TestCase;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.nio.ByteOrder;
import java.util.concurrent.TimeUnit;

public class ObjectLock extends TestCase {

    private Integer amount = 0;// 整型字段占用4个字节

    private int[] arr = new int[10];

    public void increase() {
        synchronized (this) {
            amount++;
        }
    }

    public String hexHash() {
        int hashCode = this.hashCode();
        byte[] bytes = ByteUtils.fromInt(hashCode);
        return ByteUtils.toHex(bytes);
    }

    public String binaryHash() {
        int hashCode = this.hashCode();
        byte[] bytes = ByteUtils.fromInt(hashCode);
        StringBuffer sb = new StringBuffer();
        for (byte b : bytes) {
//sb.append(ByteUtils.)
        }
        return sb.toString();
    }

    public void printSelf() {
        System.out.println(VM.current().details());

        String printable = ClassLayout.parseInstance(this).toPrintable();
        System.out.println(printable);
        int hashCode = this.hashCode();// 会撤销偏向锁
        System.out.println(hashCode);
        printable = ClassLayout.parseInstance(this).toPrintable();
        System.out.println(printable);
    }

    public void testPrint() {
        try {
            TimeUnit.SECONDS.sleep(5);// JVM 偏向锁是延时启用，默认为4000毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ObjectLock lock = new ObjectLock();
        lock.printSelf();

        System.out.println(ByteOrder.nativeOrder());
    }

}
