import spi.HelloService;

import java.util.ServiceLoader;

public class Main {
  public static void main(String[] args) {
    ServiceLoader<HelloService> helloServiceLoader = ServiceLoader.load(HelloService.class);
    helloServiceLoader.forEach(HelloService::hello);
  }
}
