package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.O;

public class FIOTest {
  public static void main(String[] args) throws IOException {
    System.out.println(System.getProperty("file.encoding"));

    Path file = Paths.get("xanadu.txt");
    System.out.println(file.getFileName());
    System.out.println(file.toAbsolutePath().getRoot());
    BasicFileAttributes basicFileAttributes =
        Files.readAttributes(file, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
    Stream.of(basicFileAttributes).forEach(attr -> System.out.println(attr.lastModifiedTime()));


    byte[] buf;
    buf = Files.readAllBytes(file);

    Path out = Paths.get("newFile");
    Files.write(out, buf, StandardOpenOption.TRUNCATE_EXISTING);

//    try (BufferedReader reader = Files.newBufferedReader(file, Charset.defaultCharset())) {
//      String line = null;
//      while ((line = reader.readLine()) != null) {
//        System.out.println(line);
//      }
//    }


    try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(10);
      while (sbc.read(byteBuffer) > 0) {
        byteBuffer.rewind();
        System.out.print(Charset.forName(System.getProperty("file.encoding")).decode(byteBuffer));
        byteBuffer.flip();
      }
    }

  }
}
