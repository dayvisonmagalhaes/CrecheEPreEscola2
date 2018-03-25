package carros.com.br.crecheepreescola.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.activity.Diario_Comun_Calendario_Msg_Activity;
import carros.com.br.crecheepreescola.activity.Diario_Msg_Activity;

/**
 * Created by Dayvison_Not on 19/03/2018.
 */

public class AlunosFragment extends Fragment{

    private static final String TAG = "AlunosFragment";
    private Button btnAlunoProfessor;
    private Button btnAlunoResponsavel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aluno_fragment, container, false);

        btnAlunoProfessor = (Button) view.findViewById(R.id.btnAlunoProfessor);

        btnAlunoProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Diario_Msg_Activity.class);
                startActivity(intent);
            }
        });

//        btnAlunoResponsavel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), AlunosFragment.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }
}
