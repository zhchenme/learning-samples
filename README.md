### nio-learn-samples

#### Channel

`Channel` 和 `Stream` 的区别：

 - `Channel` 是可读切可写的，`Stream` 只可读或可写
 - `Channel` 可异步读写
 - `Channel` 总是从 `Buffer` 中读写

`Channel` 常用的实现类：`FileChannel`、`DatagramChannel`（UDP）、`SocketChannel`（TCP）、`ServerSocketChannel`（TCP）

#### Buffer

使用 `Buffer` 读写数据步骤：

 1. 将数据写入 `Buffer`
 2. 调用 `flip()` 方法，从写模式切换到读模式
 3. 从 `Buffer` 中读数据
 4. 调用 `clear()` 或 `compact` 方法，清空 `Buffer`

`Buffer` 3 个重要属性：

 - capacity：`Buffer` 分配内存大小
 - position：
    - 写模式：初始为 0，随着数据被写入 `Buffer` 会指向下一个将要写入数据的位置
    - 读模式：当从写模式切换到读模式，指向 0 位置，随着数据从 `Buffer` 中读取会指向下一个将要读取数据的位置
 - limit：
    - 写模式：可以将多少数据写入 `Buffer`，写模式下等于 capacity
    - 读模式：当从写模式切换到读模式，表示 `Buffer` 中还有多少数据可以读取，因此读模式下等于 position

关系：position <= limit <= capacity

向 `Buffer` 中写数据：

 1. 从 `Channel` 向 `Buffer` 中写数据，例如：`int bytesRead = inChannel.read(buf);`
 2. 自定义向 `Buffer` 中写数据，例如：`buf.put(127);`
 
从 `Buffer` 中读数据：
 1. 将 `Buffer` 中的数据写入 `Channel`，例如：`int bytesWritten = inChannel.write(buf);`
 2. 通过 `get()` 方法获取，例如：`byte aByte = buf.get(); `
 
一些方法：

flip()：从写模式切换到读模式

``` java
    public final Buffer flip() {
        limit = position;
        position = 0;
        mark = -1;
        return this;
    }
```

rewind()：重置 `position` 属性为 0，可以重新读取 `Buffer` 中的内容
 
``` java
    public final Buffer rewind() {
        position = 0;
        mark = -1;
        return this;
    }
```

clear()：清空 `Buffer` 数据，可用于后续数据读入，此时 `piositoin = 0`，`limit = capacity`，PS：数据并非真正的被清空，只是重置一些属性用于表明 `Buffer` 可再次写入数据

``` java
    public final Buffer clear() {
        position = 0;
        limit = capacity;
        mark = -1;
        return this;
    }
```

compact()：将 `Buffer` 中未读的数据复制到 `Buffer` 头，此时 `position = capacity - position`，`limit = capacity`

`HeapByteBuffer` 代码如下：

``` java
    public ByteBuffer compact() {

        System.arraycopy(hb, ix(position()), hb, ix(0), remaining());
        position(remaining());
        limit(capacity());
        discardMark();
        return this;
    }

    public final int remaining() {
        return limit - position;
    }
```

mark() & reset()：通过 `mark()` 进行标记，调用 `reset()` 方法时回到标记位置

``` java
    public final Buffer mark() {
        mark = position;
        return this;
    }

    public final Buffer reset() {
        int m = mark;
        if (m < 0)
            throw new InvalidMarkException();
        position = m;
        return this;
    }
```

from：[Java NIO](http://tutorials.jenkov.com/java-nio/buffers.html) <br>
 
 