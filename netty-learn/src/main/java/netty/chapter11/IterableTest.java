package netty.chapter11;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * created by cjf 21:17 2018/11/24
 * <p>
 * 迭代器模式
 */
public class IterableTest {


    public static void main(String[] args) {
        ByteBuf header = Unpooled.wrappedBuffer(new byte[]{1, 2, 3});
        ByteBuf body = Unpooled.wrappedBuffer(new byte[]{4, 5, 6});

        ByteBuf merge = merge(header, body);
        merge.forEachByte(value -> {
            System.out.println(value);
            return true;
        });


    }

    /**
     * 可以实现内存的零拷贝
     */
    public static ByteBuf merge(ByteBuf header, ByteBuf body) {
        CompositeByteBuf byteBuf = ByteBufAllocator.DEFAULT.compositeBuffer(2);
        byteBuf.addComponent(true, header);
        byteBuf.addComponent(true, body);

        return byteBuf;
    }
}
