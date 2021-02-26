import cc.CreditCardService;
import cc.CreditCardServiceImpl;
import msg.MessageService;
import msg.MessageServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
  public static void main(String[] args) {
    CreditCardService service = new CreditCardServiceImpl();
    MessageService service1 = new MessageServiceImpl();
    Endpoint.publish("http://localhost:8080", service1);
  }
}
