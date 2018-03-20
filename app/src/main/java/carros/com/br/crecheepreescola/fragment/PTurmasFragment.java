package carros.com.br.crecheepreescola.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.activity.Aluno_Com_Prog_Activity;

/**
 * Created by Dayvison_Not on 19/03/2018.
 */

public class PTurmasFragment extends Fragment{

    private static final String TAG = "PTurmasFragment";

    private Button btnTurmasTest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.p_turmas_fragment, container, false);

        btnTurmasTest = (Button) view.findViewById(R.id.btnTurmas);

       btnTurmasTest.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //Toast.makeText(getActivity(),"Testando", Toast.LENGTH_LONG).show();

               Intent intent;
               intent = new Intent(getActivity(), Aluno_Com_Prog_Activity.class);
               startActivity(intent);
           }
       });
        return view;
    }
}
