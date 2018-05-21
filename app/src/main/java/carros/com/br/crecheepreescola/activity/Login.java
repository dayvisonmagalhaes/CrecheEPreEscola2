package carros.com.br.crecheepreescola.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.dominio.Pessoa;
import carros.com.br.crecheepreescola.interfacce.IRetrofitCreche;
import carros.com.br.crecheepreescola.service.BaseURL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    private static String BASE_URL = "";
    BaseURL baseURL = new BaseURL();
    EditText etEmail, etSenha;
    Button btnLogar;
    String email = "";
    String senha = "";
    public Pessoa pessoaLogin = new Pessoa();
    public static int idLogin;
    public static String nomeLogin;

    Gson g = new Gson();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etSenha = (EditText) findViewById(R.id.etSenha);
        btnLogar = (Button) findViewById(R.id.btnEntrar);

        BASE_URL = baseURL.getBaseUrl();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        final IRetrofitCreche call = retrofit.create(IRetrofitCreche.class);


        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = etEmail.getText().toString();
                senha = etSenha.getText().toString();

                Call<Pessoa> pessoaCall = call.login(email, senha);

                pessoaCall.enqueue(new Callback<Pessoa>() {


                    @Override
                    public void onResponse(Call<Pessoa> call, Response<Pessoa> response) {
                        if (response.isSuccessful()) {

                            pessoaLogin = response.body();
                            Log.i("Nome", pessoaLogin.getNome());

                            //Intent intent = new Intent(MainActivity.this, ProfessorActivity.class);

                            Intent intent;


                            if (pessoaLogin == null) {
                                Log.i("Nome", pessoaLogin.getNome());
                                Toast.makeText(getApplicationContext(), "Login ou email com erro", Toast.LENGTH_LONG).show();

                                //TESTA PARA VER O TIPO DE PESSOA:
                                // 1 Administrador,
                                // 2 Professor,
                                // 3 Aluno,
                                // 4 Funcionário,
                                // 5 Responsável
                            } else if (pessoaLogin.getTipoPessoa() == 1) {

                                intent = new Intent(Login.this, MainActivity.class);

                                nomeLogin = pessoaLogin.getNome();

                                idLogin = pessoaLogin.getId();

                                startActivity(intent);

                            } else if (pessoaLogin.getTipoPessoa() == 2){

                                intent = new Intent(Login.this, Alunos_Responsavel_Activity.class);
                                nomeLogin = pessoaLogin.getNome();

                                idLogin = pessoaLogin.getId();

                                startActivity(intent);
                            }


                        } else {
                            Toast.makeText(getApplicationContext(), "Erro:" + response.code(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Pessoa> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erros: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}
