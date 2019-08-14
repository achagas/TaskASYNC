package br.com.example.estadosdobrasil;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.example.estadosdobrasil.Adapter.ClinicasAdapter;
import br.com.example.estadosdobrasil.Model.Clinica;
import br.com.example.estadosdobrasil.Util.NetworkUtil;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";
    ProgressBar progressBarLoading;
    TextView txTextoExibido;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txTextoExibido = findViewById(R.id.tv_texto_exibido);
        progressBarLoading = findViewById(R.id.pb_loading);
        listview = (ListView)  findViewById(R.id.lv_lista_clinicas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_web_service:
                callWebService();
                break;
            case R.id.menu_clear:
                clearText();
                break;
            case R.id.menu_evo:
                callWebServiceEvo();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void callWebServiceEvo() {
        URL url = NetworkUtil.buildUrlEvo();
        MinhaAsyncTask task = new MinhaAsyncTask();
        task.execute(url);
    }

    public void callWebService(){
        Log.d(TAG, "method call web service");
        URL url = NetworkUtil.buildUrl("stf");
        MinhaAsyncTask task = new MinhaAsyncTask();
        task.execute(url);
    }

    public void mostrarLoading(){
        txTextoExibido.setVisibility(View.GONE);
        progressBarLoading.setVisibility(View.VISIBLE);
    }

    public void esconderLoading(){
        txTextoExibido.setVisibility(View.GONE);
        progressBarLoading.setVisibility(View.GONE);
    }

    public void clearText(){
        Log.d(TAG, "method call Clear Text");
        txTextoExibido.setText("");
    }

    public ListView listarClinicas(List<Clinica> a){

        ClinicasAdapter adapter = new ClinicasAdapter(a, this);
        listview.setAdapter(adapter);
        return listview;
    }

    class MinhaAsyncTask extends AsyncTask<URL, Void, List<Clinica>>{

        @Override
        protected List<Clinica> doInBackground(URL... urls) {
            URL url = urls[0];
            Log.d(TAG, "url utilizada: " + url.toString());
            String json = null;
            try {
                json = NetworkUtil.getResponseFromHttpUrl(url);
                Log.d(TAG, "async task retorno: " + json);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //ArrayList<Clinica> clinicas = new ArrayList<Clinica>();
            TypeToken<List<Clinica>> token = new TypeToken<List<Clinica>>() {};
            List<Clinica> clinicas = new Gson().fromJson(json.toString(), token.getType());
            //return new Gson().fromJson(json.toString(), Clinica.class);
            return clinicas;
        }

        @Override
        protected void onPreExecute() {
            mostrarLoading();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Clinica> s) {
            esconderLoading();
            if(s == null) {
                txTextoExibido.setText("Houve um erro");
            }else{
                listarClinicas(s);
                //txTextoExibido.setText(s.toString());
            }
        }
    }
}
