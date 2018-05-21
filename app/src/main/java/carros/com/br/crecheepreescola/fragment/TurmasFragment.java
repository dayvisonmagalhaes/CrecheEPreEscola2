package carros.com.br.crecheepreescola.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.activity.Login;
import carros.com.br.crecheepreescola.activity.MainActivity;
import carros.com.br.crecheepreescola.adapter.ListaTurmaAdapter;
import carros.com.br.crecheepreescola.dominio.Turma;
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

public class TurmasFragment extends Fragment{

    List<Turma> turmas;
    BaseURL baseURL = new BaseURL();
    private static String BASE_URL = "";
    private int idProfessor = Login.idLogin;
    private static final String TAG = "TurmasFragment";

    RecyclerView listViewTurmas;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.turmas_fragment, container, false);

        turmas = new ArrayList<>();

        listViewTurmas = (RecyclerView) view.findViewById(R.id.listViewTurmas);

        //Configurando Layout manager para o listview
        //StaggeredGridLayoutManager mStaggeredGridManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        listViewTurmas.setLayoutManager(layoutManager);

        //criar o RecycleView adapter, antes disso vamos criar o layout para o list item

        BASE_URL = baseURL.getBaseUrl();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        IRetrofitCreche call = retrofit.create(IRetrofitCreche.class);

        Call<List<Turma>> turmaCall = call.getTurmas(idProfessor);

        turmaCall.enqueue(new Callback<List<Turma>>() {
            @Override
            public void onResponse(Call<List<Turma>> call, Response<List<Turma>> response) {

                int statusCode = response.code();

                List<Turma> turmasList = response.body();
                if (turmasList != null){
                    for (Turma turma : turmasList){
                        turmas.add(turma);
                        Log.d("Turmas" , "onResponse: " + turma.getNome() );
                    }
                }
                Log.d("Turmas" , "onResponse" + statusCode );

                ListaTurmaAdapter listaTurmaAdapter = new ListaTurmaAdapter(getContext(),turmasList);

                listViewTurmas.setAdapter(listaTurmaAdapter);
            }

            @Override
            public void onFailure(Call<List<Turma>> call, Throwable t) {

                Log.d("Turmas" , "onResponse" + t.getMessage() );
            }
        });


        return view;
    }
}
