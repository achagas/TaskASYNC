package br.com.example.estadosdobrasil.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Clinica implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String descricao;
    private String foto;
    private String uniq_id;
    private String id_estabelecimento;
    private String razao_social;
    private String nome_fantasia;
    private String cnpj_cpf;
    private String contato;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;
    private String numero;
    private String bairro;
    private String id_cidade;
    private String id_estado;
    private String cep;
    private String nmcidade;
    private String nmestado;
    private String pais;
    private String status;
    private String segmento;
    private String beneficios;
    private String total_likes;

    public Clinica(){}

    protected Clinica(Parcel in) {
        descricao = in.readString();
        foto = in.readString();
        uniq_id = in.readString();
        id_estabelecimento = in.readString();
        razao_social = in.readString();
        nome_fantasia = in.readString();
        cnpj_cpf = in.readString();
        contato = in.readString();
        telefone = in.readString();
        celular = in.readString();
        email = in.readString();
        endereco = in.readString();
        numero = in.readString();
        bairro = in.readString();
        id_cidade = in.readString();
        id_estado = in.readString();
        cep = in.readString();
        nmcidade = in.readString();
        nmestado = in.readString();
        pais = in.readString();
        status = in.readString();
        segmento = in.readString();
        beneficios = in.readString();
        total_likes = in.readString();
    }

    public static final Creator<Clinica> CREATOR = new Creator<Clinica>() {
        @Override
        public Clinica createFromParcel(Parcel in) {
            return new Clinica(in);
        }

        @Override
        public Clinica[] newArray(int size) {
            return new Clinica[size];
        }
    };



    // Getter Methods
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFoto() {
        return foto;
    }

    public String getUniq_id() {
        return uniq_id;
    }

    public String getId_estabelecimento() {
        return id_estabelecimento;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    public String getContato() {
        return contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getId_cidade() {
        return id_cidade;
    }

    public String getId_estado() {
        return id_estado;
    }

    public String getCep() {
        return cep;
    }

    public String getNmcidade() {
        return nmcidade;
    }

    public String getNmestado() {
        return nmestado;
    }

    public String getPais() {
        return pais;
    }

    public String getStatus() {
        return status;
    }

    public String getSegmento() {
        return segmento;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public String getTotal_likes() {
        return total_likes;
    }

    @Override
    public String toString() {
        return " nome_fantasia=" + nome_fantasia + "\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descricao);
        dest.writeString(foto);
        dest.writeString(uniq_id);
        dest.writeString(id_estabelecimento);
        dest.writeString(razao_social);
        dest.writeString(nome_fantasia);
        dest.writeString(cnpj_cpf);
        dest.writeString(contato);
        dest.writeString(telefone);
        dest.writeString(celular);
        dest.writeString(email);
        dest.writeString(endereco);
        dest.writeString(numero);
        dest.writeString(bairro);
        dest.writeString(id_cidade);
        dest.writeString(id_estado);
        dest.writeString(cep);
        dest.writeString(nmcidade);
        dest.writeString(nmestado);
        dest.writeString(pais);
        dest.writeString(status);
        dest.writeString(segmento);
        dest.writeString(beneficios);
        dest.writeString(total_likes);
    }

    // Setter Methods

   public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setUniq_id(String uniq_id) {
        this.uniq_id = uniq_id;
    }

    public void setId_estabelecimento(String id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setId_cidade(String id_cidade) {
        this.id_cidade = id_cidade;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNmcidade(String nmcidade) {
        this.nmcidade = nmcidade;
    }

    public void setNmestado(String nmestado) {
        this.nmestado = nmestado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public void setTotal_likes(String total_likes) {
        this.total_likes = total_likes;
    }
}
