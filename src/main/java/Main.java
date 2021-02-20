public class Main {
  public static void main(String[] args) {
    Consumer consumer = new Consumer();
    consumer.addTask("Task1", 1);
    consumer.addTask("Task2", 0);
    consumer.addTask("Task3", 3);
    consumer.addTask("Task4", 2);

    System.out.println(consumer.getTask());
    System.out.println(consumer.getTask());
    System.out.println(consumer.getTask());
    System.out.println(consumer.getTask());
  }
}
