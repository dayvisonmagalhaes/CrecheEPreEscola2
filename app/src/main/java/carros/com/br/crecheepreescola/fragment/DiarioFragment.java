package carros.com.br.crecheepreescola.fragment;


import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.dominio.Diario;
import carros.com.br.crecheepreescola.interfacce.IRetrofitCreche;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiarioFragment extends Fragment {

    private static final String BASE_URL = "http://192.168.0.115:8080/WebServiceCreche/webresources/Creches/";
    Diario diario = null;//             http://localhost:8080/WebServiceCreche/webresources/Creches/Diario/inserir
    SimpleDateFormat dateFormat;
    Date data;
    private Button btnSalvarDiario;
    private TextView tvTituloInicialNome;
    private RadioGroup groupPresenca;
    private RadioGroup groupMamadeira;
    private RadioGroup groupLancheManha;
    private RadioGroup groupAlmoco;
    private RadioGroup groupLancheTarde;
    private RadioGroup groupJantar;
    private RadioGroup groupRemedio;
    private EditText obsRemedio;
    private RadioGroup groupParticipacao;
    private RadioGroup groupSono;
    private EditText SonoTempo;
    private RadioGroup groupEvacuacao;
    private EditText resumoDiaET;
    private LinearLayout linearLayoutBtnSalvar;
    private LinearLayout linearLayoutDiario;

    public DiarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diario_fragment, container, false);


        btnSalvarDiario = (Button) view.findViewById(R.id.salvarDiario);
        tvTituloInicialNome = (TextView) view.findViewById(R.id.tituloInicial);
        groupPresenca = (RadioGroup) view.findViewById(R.id.groupPresenca);
        groupMamadeira = (RadioGroup) view.findViewById(R.id.groupMamadeira);
        groupLancheManha = (RadioGroup) view.findViewById(R.id.groupLancheManha);
        groupAlmoco = (RadioGroup) view.findViewById(R.id.groupAlmoco);
        groupLancheTarde = (RadioGroup) view.findViewById(R.id.groupLancheTarde);
        groupJantar = (RadioGroup) view.findViewById(R.id.groupJantar);
        groupRemedio = (RadioGroup) view.findViewById(R.id.groupRemedio);
        obsRemedio = (EditText) view.findViewById(R.id.obsRemedio);
        groupParticipacao = (RadioGroup) view.findViewById(R.id.groupParticipacao);
        groupSono = (RadioGroup) view.findViewById(R.id.groupSono);
        SonoTempo = (EditText) view.findViewById(R.id.sonoTempo);
        groupEvacuacao = (RadioGroup) view.findViewById(R.id.groupEvacuacao);
        resumoDiaET = (EditText) view.findViewById(R.id.resumoDiaET);
        linearLayoutDiario = (LinearLayout) view.findViewById(R.id.linearLayoutDiario);
        linearLayoutBtnSalvar = (LinearLayout) view.findViewById(R.id.linearLayoutBtnSalvar);

        groupPresenca.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (groupPresenca.getCheckedRadioButtonId()) {
                    case R.id.radioSim:
                        linearLayoutDiario.setVisibility(View.VISIBLE);
                        linearLayoutBtnSalvar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radioNao:
                        linearLayoutDiario.setVisibility(View.INVISIBLE);
                        linearLayoutBtnSalvar.setVisibility(View.INVISIBLE);
                }
            }
        });

        groupRemedio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (groupRemedio.getCheckedRadioButtonId()) {
                    case R.id.radioRemedioSim:
                        obsRemedio.setVisibility(View.VISIBLE);

                        break;
                    case R.id.radioRemedioNao:
                        obsRemedio.setVisibility(View.INVISIBLE);

                }
            }
        });
        groupSono.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (groupSono.getCheckedRadioButtonId()) {
                    case R.id.radioSonoSim:
                        SonoTempo.setVisibility(View.VISIBLE);

                        break;
                    case R.id.radioSonoNao:
                        SonoTempo.setVisibility(View.INVISIBLE);

                }
            }
        });

        btnSalvarDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diario = new Diario();
                diario.setPresenca(onRadioGroupPresenca(view));
                diario.setMamadeira(onRadioGroupMamadeira(view));
                diario.setData(obterDataAtual());
                diario.setLancheManha(onRadioGroupLancheManha(view));
                diario.setAlmoco(onRadioGroupAlmoco(view));
                diario.setLancheTarde(onRadioGroupLancheTarde(view));
                diario.setJantar(onRadioGroupJantar(view));
                diario.setRemedios(onRadioGroupRemedios(view));
                diario.setObsRemedios(obsRemedio.getText().toString());
                diario.setParticipacao(onRadioGroupParticipacao(view));
                diario.setSono(onRadioGroupSono(view));
                diario.setTempoSono(SonoTempo.getText().toString());
                diario.setEvacuacao(onRadioGroupEvacuacao(view));
                diario.setResumoDia(resumoDiaET.getText().toString());
                diario.setAlunoId(1);//AINDA EM TESTES, POIS ESSE "idAluno" SERÁ CAPTURADO VIA "getIntent" DA TELA ANTERIOR (AlunosFragment)

                salvarDiario();
               // Log.i("Data", diario.getData());
                Log.i("Diario: ", diario.toString());
                //Toast.makeText(getActivity(), "Data: " + diario.getData(), Toast.LENGTH_LONG).show();
               // Toast.makeText(getActivity(), "Diário: " + diario.toString(), Toast.LENGTH_LONG).show();
            }


        });

        return view;
    }

//
    private void salvarDiario() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        IRetrofitCreche call = retrofit.create(IRetrofitCreche.class);


        retrofit2.Call<Boolean> diarioCall = call.postDiario(diario);

        diarioCall.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Toast.makeText(getActivity(), "Salvo com sucesso", Toast.LENGTH_LONG).show();
                closefragment();

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

                Toast.makeText(getActivity(), "Caiu no ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }


    public String onRadioGroupPresenca(View view) {

        String presenca = "";

        switch (groupPresenca.getCheckedRadioButtonId()) {
            case R.id.radioSim:
                presenca = "Sim";
                break;
            case R.id.radioNao:
                presenca = "Não";
        }
        return presenca;
    }

    public String onRadioGroupMamadeira(View view) {

        String mamadeira = "Ainda não foi informado!";

        switch (groupMamadeira.getCheckedRadioButtonId()) {
            case R.id.radioMamadeiraNaoAceitou:
                mamadeira = "Não aceitou";
                break;
            case R.id.radioMamadeiraMenosMetade:
                mamadeira = "Menos da metade";
                break;
            case R.id.radioMamadeiraMetade:
                mamadeira = "Metade";
                break;
            case R.id.radioMamadeiraMaisDaMetade:
                mamadeira = "Mais da metade";
        }
        return mamadeira;
    }

    public String onRadioGroupLancheManha(View view) {

        String lancheManha = "Ainda não foi informado!";

        switch (groupLancheManha.getCheckedRadioButtonId()) {
            case R.id.radioLancheNaoAceitou:
                lancheManha = "Não aceitou";
                break;
            case R.id.radioLancheMenosMetade:
                lancheManha = "Menos da metade";
                break;
            case R.id.radioLancheMetade:
                lancheManha = "Metade";
                break;
            case R.id.radioLancheMaisDaMetade:
                lancheManha = "Mais da metade";
        }
        return lancheManha;
    }

    public String onRadioGroupAlmoco(View view) {

        String almoco = "Ainda não foi informado!";

        switch (groupAlmoco.getCheckedRadioButtonId()) {
            case R.id.radioAlmocoNaoAceitou:
                almoco = "Não aceitou";
                break;
            case R.id.radioAlmocoMenosMetade:
                almoco = "Menos da metade";
                break;
            case R.id.radioAlmocoMetade:
                almoco = "Metade";
                break;
            case R.id.radioAlmocoMaisDaMetade:
                almoco = "Mais da metade";
        }
        return almoco;
    }

    public String onRadioGroupLancheTarde(View view) {

        String lancheTarde = "Ainda não foi informado!";

        switch (groupLancheTarde.getCheckedRadioButtonId()) {
            case R.id.radioLancheTardeNaoAceitou:
                lancheTarde = "Não aceitou";
                break;
            case R.id.radioLancheTardeMenosMetade:
                lancheTarde = "Menos da metade";
                break;
            case R.id.radioLancheTardeMetade:
                lancheTarde = "Metade";
                break;
            case R.id.radioLancheTardeMaisDaMetade:
                lancheTarde = "Mais da metade";
        }
        return lancheTarde;
    }

    public String onRadioGroupJantar(View view) {

        String jantar = "Ainda não foi informado!";

        switch (groupJantar.getCheckedRadioButtonId()) {
            case R.id.radioJantarNaoAceitou:
                jantar = "Não aceitou";
                break;
            case R.id.radioJantarMenosMetade:
                jantar = "Menos da metade";
                break;
            case R.id.radioJantarMetade:
                jantar = "Metade";
                break;
            case R.id.radioJantarMaisDaMetade:
                jantar = "Mais da metade";
        }
        return jantar;
    }

    public String onRadioGroupRemedios(View view) {

        String remedios = "Ainda não foi informado!";

        switch (groupRemedio.getCheckedRadioButtonId()) {
            case R.id.radioRemedioSim:
                remedios = "Sim";
                break;
            case R.id.radioRemedioNao:
                remedios = "Não";
                break;
        }
        return remedios;
    }

    public String onRadioGroupParticipacao(View view) {

        String participacao = "Ainda não foi informado!";

        switch (groupParticipacao.getCheckedRadioButtonId()) {
            case R.id.radioParticNaoAceitou:
                participacao = "Não participou";
                break;
            case R.id.radioParticMenosMetade:
                participacao = "Pouco";
                break;
            case R.id.radioParticNormal:
                participacao = "Normal";
                break;
            case R.id.radioParticExcelente:
                participacao = "Excelente";
        }
        return participacao;
    }

    public String onRadioGroupSono(View view) {

        String Sono = "Ainda não foi informado!";

        switch (groupSono.getCheckedRadioButtonId()) {
            case R.id.radioSonoSim:
                Sono = "Sim";
                break;
            case R.id.radioSonoNao:
                Sono = "Não";
                break;

        }
        return Sono;
    }

    public String onRadioGroupEvacuacao(View view) {

        String evacuacao = "Ainda não foi informado!";

        switch (groupEvacuacao.getCheckedRadioButtonId()) {
            case R.id.radioEvacNao:
                evacuacao = "Não evacuou";
                break;
            case R.id.radioEvacPouco:
                evacuacao = "Pouco";
                break;
            case R.id.radioEvacNormal:
                evacuacao = "Normal";
                break;
            case R.id.radioEvacMuito:
                evacuacao = "Muito";
        }
        return evacuacao;
    }

    public String obterDataAtual() {

        dateFormat = new SimpleDateFormat("dd-MM-yyy");
        data = new Date();
        String dataFormatada = dateFormat.format(data);

        return dataFormatada;

    }

    private void closefragment() {
        getActivity().finish();
    }


}
