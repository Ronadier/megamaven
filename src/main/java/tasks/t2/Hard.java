package tasks.t2;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;

public class Hard {
  public static void main(String[] args) throws JSONException {
    ArrayList<String> forbiddenWords = new ArrayList<>();
    forbiddenWords.add("Ничего");
    forbiddenWords.add("Никакого");
    System.out.println(constructJSON("Ничего нельзя! Никакого праздника!",12, forbiddenWords).toString());
  }

  public static JSONObject constructJSON(String text, int n, ArrayList<String> forbiddenWords) throws JSONException {
    JSONObject json = new JSONObject();
    json.put("length", Light.textLenth(text));
    json.put("pure_length", Light.textLengthWithoutSpaces(text));
    json.put("origin_text", text);
    json.put("pure_text", replaceForbiddenWords(text, forbiddenWords));
    json.put("pure_short_text", getShortText(json.getString("pure_text"), n));
    return json;
  }

  public static String replaceForbiddenWords (String text, ArrayList<String> forbiddenWords) {
    for (String fb: forbiddenWords) {
      text = text.replaceAll(fb, "***");
    }
    return text;
  }

  public static String getShortText (String text, int n) {
    if (text.length() > n) {
      text = text.substring(0, n) + "...";
    }
    return text;
  }
}

//Для тех, кто хочет посложнее, анализатор текста должен вести себя несколько иначе. Он должен получать на вход три параметра: анализируемый текст, максимально допустимую длину, список запрещенных слов. Результатом работы этой функции должен быть JSON, в котором будут следующие поля:
//
//- "length" - длина строки
//- "pure_length" - длина строки без учета пробелов
//- "origin_text" - текст, полученный на входе
//- "pure_text" - текст, в котором все запрещенные слова из списка была заменены на три звездочки
//- "pure_short_text" - текст из pure_text, обрезанный на максимальном символе. Если этот символ не последний, надо это показать, добавив многоточие в конец.
//
//Пример:
//
//Дано:
//
//text: «Не забывайте о том, что все великие волшебники в истории в свое время были такими же, как мы, – школьниками. Если у них получилось, то получится и у нас», – Гарри Поттер.
//maxlen: 35
//forbidden_words: ["волшебники", "Гарри Поттер"]
//
//Результат функции:
//
//{
//"length":171,
//"pure_length":140
//"origin_text":"«Не забывайте о том, что все великие волшебники в истории в свое время были такими же, как мы, – школьниками. Если у них получилось, то получится и у нас», – Гарри Поттер."
//"pure_text":"«Не забывайте о том, что все великие *** в истории в свое время были такими же, как мы, – школьниками. Если у них получилось, то получится и у нас», – ***."
//"pure_short_text":"Не забывайте о том, что все великие..."
//}