public class LambdaTest {
  public static void main(String[] args) {
    Runnable r = () -> {
        System.out.println("lambda runnable");
    };

    List<Person> lists = new ArrayList<Person>;

    // target typing 可以省略 lambda 表达式中第一部分参数列表的类型声明
    Collections.sort(lists, (person1, person2) -> {
       person1.getAge().compareTo(person2.getAge());
    };)  



  }
}

class Person {
  private String name;
  private int age;
  private int id;
}