package tasks.t2;

public class Light {
  public static void main(String[] args) {
    textFunction("Аб          рака дабра", 5);
  }

  public static void textFunction (String text, int n) {
    System.out.println("Количество символов в тексте: " + textLenth(text));
    System.out.println("Количество символов d тексте без пробелов: " + textLengthWithoutSpaces(text));
    if (isEven(text)) {
      System.out.println("Количество символов чётное");
    } else {
      System.out.println("Количество символов нечётное");
    }
    if (isLengthMoreN(text, n)) {
      System.out.println("Длина текста превышает N на " + (text.length() - n) +" символов");
    }
  }

  public static int textLenth (String text) {
    return text.length();
  }

  public static int textLengthWithoutSpaces (String text) {
    text = text.replaceAll("\\s", "");
    return text.length();
  }

  public static boolean isEven (String text) {
    return text.length() % 2 == 0;
  }

  public static boolean isLengthMoreN (String text, int n) {
    return text.length() > n;
  }
}
