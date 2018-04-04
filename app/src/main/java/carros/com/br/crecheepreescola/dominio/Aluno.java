package carros.com.br.crecheepreescola.dominio;

import android.os.Parcel;
import android.os.Parcelable;

public class Aluno implements Parcelable  {

    private int id;
    private String nome;

    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    protected Aluno(Parcel in) {
        id = in.readInt();
        nome = in.readString();
    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in);
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nome);
    }
}
