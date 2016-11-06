package io;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

import static java.nio.file.StandardOpenOption.*;

public class FileChannelTest {
  public static void main(String[] args) {
    Path file = Paths.get("xanadu.txt");

    String str = "I am here!\n";
    byte[] b = str.getBytes();
    ByteBuffer out = ByteBuffer.wrap(b);
    ByteBuffer copy = ByteBuffer.allocate(12);

    try (FileChannel channel = FileChannel.open(file, WRITE, READ)) {
      int nread;
      // 读需要读到空buffer中
      do {
        channel.read(copy);
      } while ((nread = channel.read(copy)) != -1 && copy.hasRemaining());

      channel.position(0);
      while (out.hasRemaining()) {
        channel.write(out);
      }
      out.rewind();
      long length = channel.size();
      channel.position(length-1);
      copy.flip();
      while (copy.hasRemaining())
        channel.write(copy);
      while (out.hasRemaining())
        channel.write(out);


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
