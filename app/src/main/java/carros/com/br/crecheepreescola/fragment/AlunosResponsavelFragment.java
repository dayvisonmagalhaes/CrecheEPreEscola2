package carros.com.br.crecheepreescola.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.activity.Aluno_Com_Prog_Activity;
import carros.com.br.crecheepreescola.activity.Alunos_Responsavel_Activity;
import carros.com.br.crecheepreescola.adapter.ListaAlunoAdapter;
import carros.com.br.crecheepreescola.dominio.Aluno;
import carros.com.br.crecheepreescola.interfacce.IRetrofitCreche;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dayvison_Not on 19/03/2018.
 */

public class AlunosResponsavelFragment extends Fragment{

    private static final String TAG = "AlunosFragment";
    private Button btnAlunoProfessor;
    private Button btnAlunoResponsavel;
    private int idResponsavel;
    RecyclerView listViewAlunos;
    List<Aluno> alunos;
    private static final String BASE_URL = "http://192.168.24.2:8080/WebServiceCreche/webresources/Creches/";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alunos_fragment, container, false);



        Alunos_Responsavel_Activity alunos_responsavel_activity = new Alunos_Responsavel_Activity();

        idResponsavel = alunos_responsavel_activity.obterIdResponsavel();

        Log.d("AlunosResponsFragment" , "ResponsavelID: " + idResponsavel );
//
        alunos = new ArrayList<>();

        listViewAlunos = (RecyclerView) view.findViewById(R.id.listViewAlunos);

        //Configurando Layout manager para o listview

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        listViewAlunos.setLayoutManager(layoutManager);

        //criar o RecycleView adapter, antes disso vamos criar o layout para o list item

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        IRetrofitCreche call = retrofit.create(IRetrofitCreche.class);

        Call<List<Aluno>> alunoCall = call.getAlunosResponsavel(idResponsavel);

        alunoCall.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {

                int statusCode = response.code();

                List<Aluno> alunosList = response.body();
//                if (alunosList != null){
//                    for (Aluno aluno : alunosList){
//                        alunos.add(aluno);
//                        Log.d("Alunos" , "onResponse: " + aluno.getNome() );
//                    }
//                }
                //Log.d("Alunos" , "onResponse" + statusCode );
                Log.d("CodTurma" ,"ID: " + idResponsavel );

                ListaAlunoAdapter listaAlunoAdapter = new ListaAlunoAdapter(getContext(),alunosList,idResponsavel);

                listViewAlunos.setAdapter(listaAlunoAdapter);
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {

                Log.d("Alunos" , "onResponse" + t.getMessage() );
            }
        });



        return view;
    }
}
