package cc;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface CreditCardService {

  void add(CreditCard creditCard);
  String del(CreditCard creditCard);
  void delAll();
  List<CreditCard> getAll();
}