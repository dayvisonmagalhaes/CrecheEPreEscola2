package carros.com.br.crecheepreescola.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import carros.com.br.crecheepreescola.R;

/**
 * Created by Dayvison_Not on 19/03/2018.
 */

public class MsgFragment extends Fragment{

    private static final String TAG = "AlunosFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.msg_fragment, container, false);

        return view;
    }
}
