package com.cjf.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author:chenjinfeng
 * @date: 2018/8/3
 * @time: 21:49
 * @desc    学习缓冲区
 */
/**
 * 一、缓冲区（Buffer）：在 Java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 *
 * 根据数据类型不同（boolean 除外），提供了相应类型的缓冲区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法：
 * put() : 存入数据到缓冲区中
 * get() : 获取缓冲区中的数据
 *
 * 三、缓冲区中的四个核心属性：
 * capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit : 界限，表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
 * position : 位置，表示缓冲区中正在操作数据的位置。
 *
 * mark : 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到 mark 的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 四、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中
 * 直接缓冲区：通过 allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 */
public class TestBuffer {

    @Test
    public void test1() {
        String str = "abcde";
        //1.分配一个指定大小的buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("------------------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        /**
         * 0
         * 1024
         * 1024
         */
        //2.利用 put() 存入数据到缓冲区中
        System.out.println("---------------put--------------");
        buffer.put(str.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        /**
         * 5
         * 1024
         * 1024
         */
        //3.切换到读数据模式
        System.out.println("--------------flip--------------");
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        /**
         * 0
         * 5
         * 1024
         */
        //4.利用 get() 读取缓冲区中的数据
        System.out.println("--------------get--------------");
        byte[] des = new byte[buffer.limit()];
        buffer.get(des);
        System.out.println(new String(des));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        /**
         * abcde
         * 5
         * 5
         * 1024
         */
        //5.rewind() 可重复读
        System.out.println("---------------rewind-----------------");
        buffer.rewind();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        /**
         * 0
         * 5
         * 1024
         */
        //6.清空缓冲区：clear() 但是缓冲区中的数据依然存在，但是处于“被遗忘”状态
        buffer.clear();

        System.out.println("-----------------clear()----------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println((char)buffer.get());
        /**
         * 0
         * 1024
         * 1024
         * a
         */
    }

    @Test
    public void test2() {
        String str = "abcde";
        //定义一个bytebuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //写数据到buffer
        buffer.put(str.getBytes());
        //切换到读模式
        buffer.flip();
        //读到一个字节数组中
        byte[] des = new byte[buffer.limit()];
        buffer.get(des,0,2);
        System.out.println(new String(des));
        System.out.println(buffer.position());
        //定义一个标记
        buffer.mark();
        buffer.get(des,2,2);
        //恢复到mark位置
        buffer.reset();
        System.out.println(new String(des));
        System.out.println(buffer.position());
        //判断缓冲区中是否还有剩余数据
        if(buffer.hasRemaining()){
            //获取缓冲区中可以操作的数量
            System.out.println(buffer.remaining());
        }
        /**
         * ab
         * 2
         * abcd
         * 2
         * 3
         */
    }

    @Test
    public void test3() {
        //分配直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        //判断是否是直接缓冲区
        System.out.println(buffer.isDirect());
        /**
         * true
         */
    }
}
