package cc;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "cc.CreditCardService")
public class CreditCardServiceImpl implements CreditCardService {
  private List<CreditCard> cards = new ArrayList<>();
  @Override
  public void add(CreditCard creditCard) {
    cards.add(creditCard);
  }

  @Override
  public String del(CreditCard creditCard) {
    if (cards.contains(creditCard)) {
      cards.remove(creditCard);
      return "чёт удалили";
    }
    return "Няма уваходу";
  }

  @Override
  public void delAll() {
    cards.removeAll(cards);
  }

  public List<CreditCard> getAll() {
    return cards;
  }
}