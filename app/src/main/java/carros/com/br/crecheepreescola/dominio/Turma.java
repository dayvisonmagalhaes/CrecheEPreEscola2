package carros.com.br.crecheepreescola.dominio;

import android.os.Parcel;
import android.os.Parcelable;

public class Turma implements Parcelable{

    private int id;
    private String nome;


    public Turma(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    protected Turma(Parcel in) {
        id = in.readInt();
        nome = in.readString();
    }

    public static final Creator<Turma> CREATOR = new Creator<Turma>() {
        @Override
        public Turma createFromParcel(Parcel in) {
            return new Turma(in);
        }

        @Override
        public Turma[] newArray(int size) {
            return new Turma[size];
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
