package br.com.example.estadosdobrasil;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.example.estadosdobrasil.Model.Clinica;
import static br.com.example.estadosdobrasil.R.drawable.ic_action_favorite_off;
import static br.com.example.estadosdobrasil.R.drawable.ic_action_favorite_on;

public class Details extends AppCompatActivity {
    Clinica clinica;
    String linkPhoto;
    final String TAG = "Details";
    int value = 0;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        context = this.getApplicationContext();
        Intent intent = getIntent();
        clinica = intent.getParcelableExtra("clinica");

        linkPhoto = "https://pouppe.websiteseguro.com/evosaude/sistema/fotos/"+clinica.getUniq_id()+'/'+clinica.getFoto();

        ImageView iv_foto = findViewById(R.id.iv_details_foto);
        TextView tv_razaoSocial = findViewById(R.id.tv_details_razaoSocial);
        TextView tv_descricao = findViewById(R.id.tv_details_descricao);

        Picasso.with(this).load(linkPhoto).into(iv_foto);
        tv_razaoSocial.setText(clinica.getRazao_social());
        tv_descricao.setText(clinica.getDescricao());

        final FloatingActionButton fab = findViewById(R.id.fab_favoritar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value == 0){
                    value = 1;
                    fab.setImageResource(ic_action_favorite_on);
                    new setFavorite(context).execute();

                    Toast.makeText(Details.this, "Favoritado!", Toast.LENGTH_SHORT).show();
                }else {
                    value = 0;
                    fab.setImageResource(ic_action_favorite_off);
                    Toast.makeText(Details.this, "Desfavoritado!", Toast.LENGTH_SHORT).show();

                }

                //verificar se a clinica existe na lista
                //se existir setar a imagem do botao para favorito on
                //se clicar no botao favorito a clinica deve ser removida da lista de favoritos e a imagem do botao setada para favorito off
                //se NAO existir setar a imagem do botao para favorito off
                //se clicar no botao favorito a clinica deve ser adicionada a lista de favoritos e a imagem do botao setada para favorito on


            }
        });
    }

    class setFavorite extends AsyncTask<Void, Void, Void> {

        setFavorite(Context context){
            context = context;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            clinica.setNome_fantasia(clinica.getNome_fantasia());
            clinica.setDescricao(clinica.getDescricao());
            clinica.setFoto(linkPhoto);

            ClinicaDataBase.getInstance(context).getDao().insert(clinica);
            Log.d(TAG, "inseriu (teoricamente)");

            List<Clinica> clinicas = ClinicaDataBase.getInstance(context).getDao().getAllclinica();

            Log.d(TAG, "Mostrar Lista");
            for(Clinica c : clinicas){
                Log.d(TAG, "-->" + c.toString());
            }
            return null;
        }
    }



}

