package tasks;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.time.LocalTime;

public class task1l {
  static final LocalTime twentyThreeHour = LocalTime.of(23,59, 59, 999999999);
  static final LocalTime fiveHour = LocalTime.of(4,59, 59, 999999999);
  static final LocalTime tenHour = LocalTime.of(9,59, 59, 999999999);
  static final LocalTime seventeenHour = LocalTime.of(16,59, 59, 999999999);
  static final String username = "Погромист";


  public static void main(String[] args) {
    LocalTime time = LocalTime.now();

    System.out.println("System time: " + time);
    partOfday(time);

    System.out.println("Time from API: " + getApiTime());
    partOfday(getApiTime());
  }

  public static void partOfday(LocalTime time) {
    if (time.isBefore(fiveHour) || time.equals(fiveHour)) {
      System.out.println("Доброй ночи, " + username);
    } else if (time.isBefore(tenHour) || time.equals(tenHour)) {
      System.out.println("Доброе утро, " + username);
    }  else if (time.isBefore(seventeenHour) || time.equals(seventeenHour)) {
      System.out.println("Добрый день, " + username);
    } else if (time.isBefore(twentyThreeHour) || time.equals(twentyThreeHour)){
      System.out.println("Добрый вечер, " + username);
    } else {
      throw new IllegalArgumentException("Неизвестное время дня. Текущее время: " + time);
    }
  }

  public static LocalTime getApiTime() {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet("http://worldtimeapi.org/api/timezone/Europe/Moscow");
    try (CloseableHttpResponse responseGet = httpclient.execute(httpGet)) {
      HttpEntity entityGet = responseGet.getEntity();
      JSONObject json = new JSONObject(EntityUtils.toString(entityGet));
      LocalTime apiTime = LocalTime.parse(json.getString("datetime").split("T")[1].split("\\+")[0]);
      return apiTime;
    } catch (IOException | JSONException e) {
      e.printStackTrace();
    }
    return null;
  }

}


//Итак, стартуем с небольшой задачки. В каждом языке программирования есть способ получить текущее время.
//
//        Предлагаю написать программу, которая приветствует Вас следующим образом:
//
//        C 00 часов до 04 часов включительно программа при запуске пишет - "Доброй ночи, {username}"
//        С 05 часов до 09 часов включительно программа при запуске пишет - "Доброе утро, {username}"
//        С 10 часов до 16 часов включительно программа при запуске пишет - "Добрый день, {username}"
//        С 17 часов до 23 часов включительно программа при запуске пишет - "Добрый вечер, {username}"
//
//        Само собой, {username} должен заменяться на Ваше имя.