package lt.gao.test;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;





public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



   TextView mTextViewResult = findViewById(R.id.gao);
    OkHttpClient client = new OkHttpClient();
    String url = "https://kakao.lt";

    Request request = new Request.Builder()
            .url(url)
            .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                final String myResponse = response.body().string();

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextViewResult.setText(myResponse);
                    }
                });
            }
        }
    });






/*


RequestQueue queue = Volley.newRequestQueue(this);

    StringRequest stringRequest = new StringRequest(Request.Method.GET, adresas,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    gao.setText("Response is: "+ response.substring(0,500));

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            gao.setText("That didn't work!");
        }
    });

    queue.add(stringRequest);







    try {

        URL myUrl = new URL(adresas);
        HttpURLConnection connection =(HttpURLConnection)
                myUrl.openConnection();
    } catch (MalformedURLException e)
    {
        e.printStackTrace();
    } catch (IOException e)
    {
e.printStackTrace();
        gao.setText("erroras tipo");
    }

*/

} // End of OnCreate

} // End Of Class


