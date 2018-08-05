package com.cjf.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author:chenjinfeng
 * @date: 2018/8/4
 * @time: 11:52
 * @desc    学习channel
 */
/**
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。
 *                    Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 *
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 *
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 *
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 *
 */
public class TestChannel {

    //利用通道完成文件的复制（非直接缓冲区）
    @Test
    public void test1() {
        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fic = null;
        FileChannel foc = null;
        try {
            fis = new FileInputStream("d:\\testnio\\1.iso");
            fos = new FileOutputStream("d:\\testnio\\2.iso");

            fic= fis.getChannel();
            foc = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //将通道的数据写入缓冲区中
            while (fic.read(buffer) != -1) {
                buffer.flip();
                foc.write(buffer);
                buffer.clear();
            }

        } catch (Exception e) {

        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fic != null) {
                try {
                    fic.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (foc != null) {
                try {
                    foc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
        /**
         * 耗时:125406
         */
    }

    //普通的文件复制过程
    @Test
    public void test2() throws Exception {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("d:\\testnio\\1.iso");
        FileOutputStream fos = new FileOutputStream("d:\\testnio\\3.iso");

        BufferedInputStream bi = new BufferedInputStream(fis);
        BufferedOutputStream bo = new BufferedOutputStream(fos);

        int i = 0;
        while ((i = bi.read()) != -1) {
            bo.write(i);
        }

        bi.close();
        bo.close();
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
        /**
         * 耗时:254487
         */
    }

    //使用直接缓冲区来复制文件
    @Test
    public void test3() throws IOException {
        long start = System.currentTimeMillis();
        //开启通道
        FileChannel fiChannel = FileChannel.open(Paths.get("d:\\testnio\\1.iso"), StandardOpenOption.CREATE);
        FileChannel foChannel = FileChannel.open(Paths.get("d:\\testnio\\4.iso"), StandardOpenOption.READ, StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inMappedBuf = fiChannel.map(FileChannel.MapMode.READ_ONLY, 0, fiChannel.size());
        MappedByteBuffer outMappedBuf = foChannel.map(FileChannel.MapMode.READ_WRITE, 0, fiChannel.size());
        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        System.out.println(outMappedBuf.remaining());
        outMappedBuf.put(dst);

        fiChannel.close();
        foChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));
    }

    /**
     * 通道之间的传输数据
     *  //TODO 不清楚为什么这里使用transferTo复制大文件的时候，只复制了部分文件，然而transferFrom()复制了整个文件
     */
    @Test
    public void test4() throws IOException {
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("d:\\testnio\\1.iso"),StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("d:\\testnio\\4.iso"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

//		inChannel.transferTo(0L, inChannel.size(), outChannel); TODO ??????
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));

        /**
         * 耗费时间为：112568
         */
    }

    /**
     * 分散读取和聚集写入
     */
    @Test
    public void test5() {
        FileChannel channel1 = null;
        try {
            RandomAccessFile raf1 = new RandomAccessFile("d:\\testnio\\1.txt", "rw");

            //1. 获取通道
            channel1 = raf1.getChannel();

            //2. 分配指定大小的缓冲区
            ByteBuffer buf1 = ByteBuffer.allocate(100);
            ByteBuffer buf2 = ByteBuffer.allocate(1024);

            //3. 分散读取
            ByteBuffer[] bufs = {buf1, buf2};
            channel1.read(bufs);

            for (ByteBuffer byteBuffer : bufs) {
                byteBuffer.flip();
            }

            System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
            System.out.println("-----------------");
            System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

            //4. 聚集写入
            RandomAccessFile raf2 = new RandomAccessFile("d:\\testnio\\2.txt", "rw");
            FileChannel channel2 = raf2.getChannel();

            channel2.write(bufs);

        } catch (Exception e) {

        }finally {
            try {
                channel1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符集
     */
    @Test
    public void test6() {
        Charset ce = Charset.forName("gbk");
        //获取编码器
        CharBuffer cb = CharBuffer.allocate(1024);
        cb.put("陈金烽很帅! ");
        cb.flip();
        //编码
        ByteBuffer bbuf = ce.encode(cb);
        for (int i = 0; i < 12; i++) {
            System.out.println(bbuf.get());
        }
        //解码
        bbuf.flip();
        CharBuffer cb1 = ce.decode(bbuf);
        System.out.println(cb1.toString());
        System.out.println("------------------------------------------------------");

        Charset cs2 = Charset.forName("utf-8");
        bbuf.flip();
        CharBuffer cBuf3 = cs2.decode(bbuf);
        System.out.println(cBuf3.toString());
        /**
         * -77
         * -62
         * -67
         * -16
         * -73
         * -23
         * -70
         * -36
         * -53
         * -89
         * 33
         * 32
         * 陈金烽很帅!
         * ------------------------------------------------------
         * �½���˧!
         */
    }
}
