package msg;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(endpointInterface = "msg.MessageService")
public class MessageServiceImpl implements MessageService{
  private List<Message> messages = new ArrayList<>();
  @Override
  public String addMessage(Message message) {
    messages.add(message);
    return "готовенько, добавлено";
  }

  @Override
  public String removeMessage(Message message) {
    if (!messages.contains(message)) {
      return "няма уваходу";
    }
    messages.remove(message);
    return "удолил";
  }

  @Override
  public List<Message> getMessagesByDate(Date date) {
    if (messages.size() == 0) {
      return null;
    }
    List<Message> result = new ArrayList<>();
    for (Message message : messages) {
      if (message.date.equals(date)) {
        result.add(message);
      }
    }
    return result;
  }

  @Override
  public List<Message> getMessagesBySender(String sender) {
    if (messages.size() == 0) {
      return null;
    }
    List<Message> result = new ArrayList<>();
    for (Message message : messages) {
      if (message.sender.equals(sender)) {
        result.add(message);
      }
    }
    return result;
  }
}
