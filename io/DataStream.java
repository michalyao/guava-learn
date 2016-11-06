package io;

import java.io.*;

public class DataStream {
  static final String dataFile = "invoicedata";
  static final double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
  static final int[] units = {12, 8, 13, 29, 50};
  static final String[] descs =
      {"Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain"};

  public static void main(String[] args) throws IOException {
    DataInputStream in = null;
    DataOutputStream out = null;


    out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("outdx")));
    in = new DataInputStream(new BufferedInputStream(new FileInputStream("outd")));
    try {
      for (int i = 0; i < prices.length; i++) {
        out.writeDouble(prices[i]);
        out.writeInt(units[i]);
        out.writeUTF(descs[i]);
      }
      try {

        for (int i = 0; i < prices.length; i++) {
          double price = in.readDouble();
          System.out.println(price);
          int unit = in.readInt();
          String desc = in.readUTF();
          System.out.println(price + unit + desc);
        }
      } catch (EOFException e) {
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
}
