import cc.CreditCardService;
import cc.CreditCardServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
  public static void main(String[] args) {
    CreditCardService service = new CreditCardServiceImpl();
    Endpoint.publish("http://localhost:8080", service);
  }
}
