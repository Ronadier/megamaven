package msg;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface MessageService {
  String addMessage(Message message);
  String removeMessage(Message message);
  List<Message> getMessagesByDate(Date date);
  List<Message> getMessagesBySender (String sender);
}
