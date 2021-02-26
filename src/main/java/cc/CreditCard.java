package cc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@AllArgsConstructor
@XmlRootElement
public class CreditCard {
  private @Getter @Setter int number;
  private @Getter @Setter String embossedName;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CreditCard that = (CreditCard) o;
    return number == that.number && Objects.equals(embossedName, that.embossedName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, embossedName);
  }

  public CreditCard() {
  }
}