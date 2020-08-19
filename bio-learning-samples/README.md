#### BufferedInputStream read() 方法返回值

``` java
    public synchronized int read() throws IOException {
        if (pos >= count) {
            fill();
            if (pos >= count)
                return -1;
        }
        return getBufIfOpen()[pos++] & 0xff;
    }
```

首先宏观的看 `InputStream` 和 `Reader` 两个输入流的抽象类都定义了 read 接口而且都返回 int，一个是字节流，一个是字符流。我们知道字节用 byte 表示，字符用 char 表示。

在应用中我们一般用 `read()` 接口的返回值是-1 则表示已经读到文件尾（EOF）。

char 的取值范围本身不包含负数，所有用 int 的-1 表示文件读完没问题，但 byte 的取值范围-128 ~ 127，包含了-1，读取的有效数据范围就是-128~127，没办法用这个取值范围中的任何一个数字表示异常或者数据已经读完，所以接口如果直接使用 byte 作为返回值不可行，直接将 byte 强制类型转换成 int 也不行，因为如果读到一个 byte 的-1，转为 int 了也是-1，会被理解为文件已经读完。所以这里做了一个特殊处理 `return getBufIfOpen()[pos++] & 0xff`。

0xff 是 int 类型，二进制为 0000 0000 0000 0000 0000 0000 1111 1111。

上述的与运算实际上读取的 byte 先被强制转换成了 int，例如 byte 的 -1（最高位表示符号位，以补码的形式表示负数为：1111 1111）

转换为 int 之后的二进制 1111 1111 1111 1111 1111 1111 1111 1111

& 0xff 之后高位去 0，最后返回的结果是 0000 0000 0000 0000 0000 0000 1111 1111, 为 int 值为 256，其-128~-1 被转为 int 中 128~256 的正数表示。

& 0xff 之后高位去 0，最后返回的结果是 0000 0000 0000 0000 0000 0000 1111 1111, 为 int 值为 256，其-128~-1 被转为 int 中 128~256 的正数表示，这样解决了可以用-1 表示文件已经读完。

from：[BufferedInputStream 源码学习笔记 ](https://www.iteye.com/blog/zhhphappy-1562427) by zhhphappy <br>