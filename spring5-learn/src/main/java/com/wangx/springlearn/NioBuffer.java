package com.wangx.springlearn;

import java.nio.ByteBuffer;

/**
 * @author: wangxu
 * @date: 2021-02-20 13:50
 */
public class NioBuffer {
    public static void main(String[] args) {
        NioBuffer nioBuffer = new NioBuffer();
        nioBuffer.text1();
    }

    /**
     * 1. 缓冲区:在java IO中负责数据的存取.缓冲区就是数组.用于存储不同数据类型的数据
     * 根据数据类型不同(boolean),提供了不同的缓冲区:
     * ByteBuffer
     * CharBuffer
     * IntBuffer
     * ShortBuffer
     * LongBuffer
     * FloatBuffer
     * DoubleBuffer
     *
     * 上述缓冲区的管理方法几乎一致,通过allocate()获取缓冲区
     * 2.缓冲区存取数据的两个核心方法
     * put()
     * get()
     * 4.缓冲区中4个核心属性:
     * capacity : 容量,表示缓冲区最大容量(一点声明不能改变)
     * limit : 界限,表示缓冲区中可以操作数据的大小(limit,后面的数据是不可以进行读写)
     * position : 位置,表示缓冲区中正在操作数据的位置
     * position <= limit <= capacity
     */
    public void text1(){
        //分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.capacity());
        System.out.println(allocate.limit());
        System.out.println(allocate.position());
    }
}
