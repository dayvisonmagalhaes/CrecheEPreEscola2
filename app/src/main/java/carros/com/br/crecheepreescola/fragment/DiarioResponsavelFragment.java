package carros.com.br.crecheepreescola.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.dominio.Diario;
import carros.com.br.crecheepreescola.interfacce.IRetrofitCreche;
import carros.com.br.crecheepreescola.service.BaseURL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dayvison_Not on 19/03/2018.
 */

public class DiarioResponsavelFragment extends Fragment{

    private static final String TAG = "DiarioFragment";
    private int idAluno = 1;//precisa recuperar esse ID através da lista de alunos (tela anterior)
    private int idResponsavel = 2;//igualmente
    BaseURL baseURL = new BaseURL();
    private static String BASE_URL = "";
   // private static final String BASE_URL = "http://192.168.43.37:8080/WebServiceCreche/webresources/Creches/";

    private TextView tituloInicial;
    private TextView respPresenca;
    private TextView respMamadeira;
    private TextView respLancheManha;
    private TextView respAlmoco;
    private TextView respLancheTarde;
    private TextView respJantar;
    private TextView respRemedio;
    private TextView respObsRemedio;
    private TextView respParticipacao;
    private TextView respSono;
    private TextView respTempoSono;
    private TextView respEvacuacao;
    private TextView respResumoDia;


    public DiarioResponsavelFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diario_fragment_responsavel, container, false);


        tituloInicial = (TextView) view.findViewById(R.id.tituloInicial);
        respPresenca = (TextView) view.findViewById(R.id.respPresenca);
        respMamadeira = (TextView) view.findViewById(R.id.respMamadeira);
        respLancheManha = (TextView) view.findViewById(R.id.respLancheManha);
        respAlmoco = (TextView) view.findViewById(R.id.respAlmoco);
        respLancheTarde = (TextView) view.findViewById(R.id.respLancheTarde);
        respJantar = (TextView) view.findViewById(R.id.respJantar);
        respRemedio = (TextView) view.findViewById(R.id.respRemedio);
        respObsRemedio = (TextView) view.findViewById(R.id.respObsRemedio);
        respParticipacao = (TextView) view.findViewById(R.id.respParticipacao);
        respSono = (TextView) view.findViewById(R.id.respSono);
        respTempoSono = (TextView) view.findViewById(R.id.respTempoSono);
        respEvacuacao = (TextView) view.findViewById(R.id.respEvacuacao);
        respResumoDia = (TextView) view.findViewById(R.id.respResumoDia);


        consultarDiario();



        return view;
    }

    private void consultarDiario() {

        BASE_URL = baseURL.getBaseUrl();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        IRetrofitCreche call = retrofit.create(IRetrofitCreche.class);

        Call<Diario> diarioCall = call.getDiarios(idAluno,idResponsavel);

       diarioCall.enqueue(new Callback<Diario>() {
           @Override
           public void onResponse(Call<Diario> call, Response<Diario> response) {

               if (response.isSuccessful()){

                   Diario getDiario = response.body();

                   tituloInicial.setText(getDiario.getNome());
                   respPresenca.setText(getDiario.getPresenca());
                   respMamadeira.setText(getDiario.getMamadeira());
                   respLancheManha.setText(getDiario.getLancheManha());
                   respAlmoco.setText(getDiario.getAlmoco());
                   respLancheTarde.setText(getDiario.getLancheTarde());
                   respJantar.setText(getDiario.getJantar());
                   respRemedio.setText(getDiario.getRemedios());
                   respObsRemedio.setText(getDiario.getObsRemedios());
                   respParticipacao.setText(getDiario.getParticipacao());
                   respSono.setText(getDiario.getSono());
                   respTempoSono.setText(getDiario.getTempoSono());
                   respEvacuacao.setText(getDiario.getEvacuacao());
                   respResumoDia.setText(getDiario.getResumoDia());

                   Toast.makeText(getActivity(), "Diário de: " + getDiario.getNome() + " recuperado com sucesso!", Toast.LENGTH_LONG).show();
               }
           }

           @Override
           public void onFailure(Call<Diario> call, Throwable t) {

               Toast.makeText(getActivity(), "Caiu no ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
           }
       });




    }
}
