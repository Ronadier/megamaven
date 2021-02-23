import org.testng.*;
import org.testng.annotations.Test;

public class ConsumerTest {
  private Consumer consumer = new Consumer();

  @Test
  public void testConsumer() {
    consumer.addTask("Task1", 1);
    consumer.addTask("Task2", 0);
    consumer.addTask("Task3", 3);
    consumer.addTask("Task4", 2);

    Assert.assertEquals("Task3", consumer.getTask());
    Assert.assertEquals("Task4", consumer.getTask());
    Assert.assertEquals("Task1", consumer.getTask());
    Assert.assertEquals("Task2", consumer.getTask());
    Assert.assertEquals(null, consumer.getTask());
  }
}
