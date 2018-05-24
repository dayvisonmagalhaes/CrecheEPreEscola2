package carros.com.br.crecheepreescola.service;

import android.content.Context;
import android.view.View;
import android.widget.RadioGroup;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.dominio.Diario;

/**
 * Created by Dayvison_Not on 21/03/2018.
 */

public class BaseURL {



    private final String BASE_URL = "http://192.168.254.6:8080/WebServiceCreche/webresources/Creches/";


    public String getBaseUrl() {
        return BASE_URL;
    }
}
