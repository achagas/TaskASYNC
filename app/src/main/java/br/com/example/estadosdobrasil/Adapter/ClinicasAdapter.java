package br.com.example.estadosdobrasil.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.example.estadosdobrasil.Model.Clinica;
import br.com.example.estadosdobrasil.R;

public class ClinicasAdapter extends BaseAdapter {

    List<Clinica> clinicaList;
    Activity activity;

    public ClinicasAdapter(List<Clinica> clinicaList, Activity activity) {
        this.clinicaList = clinicaList;
        this.activity = activity;
    }

    public int getCount(){
        return clinicaList.size();
    }

    public Clinica getItem(int position){
        return clinicaList.get(position);
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = activity.getLayoutInflater().inflate(R.layout.list_clinicas, parent, false);

        Clinica clinica = getItem(position);

        TextView nameClinica = view.findViewById(R.id.tv_name_clinica);

        nameClinica.setText(clinica.getNome_fantasia());

        return view;
    }
}
