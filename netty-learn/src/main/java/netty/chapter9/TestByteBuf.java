package netty.chapter9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author cjf 2021/1/25 13:10
 */
public class TestByteBuf {

    public static void main(String[] args) {
        System.out.println(512 >>> 4);

        ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;

//        //1、第一次分配4097内存
//        ByteBuf byteBuf = allocator.heapBuffer(4097);
//
//        //2、第二次分配4097内存
//        allocator.heapBuffer(4098);
//
//        //3、第三次分配4096
//        allocator.heapBuffer(4096);


        //1、第一次分配4097内存
        ByteBuf byteBuf = allocator.heapBuffer(14);

        allocator.heapBuffer(15);

        //2、第二次分配4097内存
        allocator.heapBuffer(17);

        //3、第三次分配4096
        allocator.heapBuffer(500);

        allocator.heapBuffer(1000);


    }
}
