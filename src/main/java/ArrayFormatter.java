import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayFormatter {
  public static void main(String[] args) {
    List<String> text = new ArrayList<>(Arrays.asList("apple banana  something", "orange", "banana", "kiwi strawberry blueberry"));

    text = formatter(text);
    text.forEach(System.out::println);
  }

  public static List<String> formatter (List<String> someText) {
    if (someText.size() < 1) {
      return someText;
    }
    List<String> result = new LinkedList<>();
    for (String text : someText) {
      String[] splittedText = text.split("\\s+");
      for (String spltText : splittedText) {
        result.add(spltText);
      }
    }
    return result;
  }
}
