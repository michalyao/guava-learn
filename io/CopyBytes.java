package io;

import java.io.*;

public class CopyBytes {
  public static void main(String[] args) throws IOException {
//    FileInputStream in = null;
//    FileOutputStream out = null;

    FileReader in = null;
    FileWriter out = null;
    try {
      in = new FileReader("xanadu.txt");
      out = new FileWriter("out.txt");
      int c;
      // 如果是用 read()方法，那么返回的是一个字节
      // 如果使用 read(b) 方法，那么返回的字节缓存到 buf 中
      byte[] buf = new byte[8];
      char[] cbuf = new char[8];
      while ((c = in.read()) != -1) {
        out.write(c);
      }
    } finally {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
  }

//  private static int personalBuf(byte[] b, int off, int len) {
//    if (b == null)
//      throw new RuntimeException();
//    else if (off < 0 || len < 0 || len > b.length - off)
//      throw new IndexOutOfBoundsException();
//    else if (len == 0)
//      return 0;
//
//    int c = read();
//    if (c == -1)
//      return -1;
//    b[off] = (byte) c;
//    int i = 1
//    for (; i < len; i++) {
//      c = read();
//      if (c == -1)
//        break;
//      b[off + i] = (byte) c;
//    }
//
//    return i;
//  }
}
