package impl;

import spi.HelloService;

public class HelloServiceImpl implements HelloService {
  @Override
  public void hello() {
    System.out.println("hello world!");
  }
}
