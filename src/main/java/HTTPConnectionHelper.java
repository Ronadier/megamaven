import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTTPConnectionHelper {
  public static void main(String[] args) throws IOException {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpUriRequest httpGet = new HttpGet("https://reqres.in/api/users/2");
    try (CloseableHttpResponse responseGet = httpclient.execute(httpGet)) {
      HttpEntity entityGet = responseGet.getEntity();
      System.out.println(EntityUtils.toString(entityGet));
    } catch (IOException e) {
      e.printStackTrace();
    }

    HttpPost httpPost = new HttpPost("https://reqres.in/api/users");
    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("name", "morpheus"));
    params.add(new BasicNameValuePair("job", "leader"));
    httpPost.setEntity(new UrlEncodedFormEntity(params));
    try (CloseableHttpResponse responsePost = httpclient.execute(httpPost)) {
      HttpEntity entityPost = responsePost.getEntity();
      System.out.println(EntityUtils.toString(entityPost));
    } catch (IOException e) {
      e.printStackTrace();
    }
    httpclient.close();
  }
}
