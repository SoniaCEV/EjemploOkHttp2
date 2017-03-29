package com.example.alumnos.ejemplookhttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient client;
    private ListView listLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new OkHttpClient();

        listLibros = (ListView) findViewById(R.id.listLibros);

        Hilo hilo = new Hilo();
        hilo.execute("http://smgformacion.net/libros");

    }

    public String getLibros(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public class Hilo extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            String url = params[0];
            String json = "";
            try {
                json = getLibros(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return json;
        }

        @Override
        protected void onPostExecute(String json) {
            //txtLibros.setText(json);

            ResultadoBean resultadoBean = ResultadoBean.fromJson(json);

            if(resultadoBean.getResultado()==0) {
                ArrayAdapter<LibroBean> adapter = new ArrayAdapter<LibroBean>(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        resultadoBean.getLibros());

                listLibros.setAdapter(adapter);
            }else{
                Toast.makeText(MainActivity.this, "No hay resultado", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
