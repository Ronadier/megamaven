package msg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@XmlRootElement
public class Message {
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Message message1 = (Message) o;
    return Objects.equals(sender, message1.sender) && Objects.equals(message, message1.message) && Objects.equals(date, message1.date);
  }

  public Message() {
  }

  @Override
  public int hashCode() {
    return Objects.hash(sender, message, date);
  }

  protected @Getter @Setter String sender;
  private @Getter @Setter String message;
  protected @Getter @Setter Date date;
}
