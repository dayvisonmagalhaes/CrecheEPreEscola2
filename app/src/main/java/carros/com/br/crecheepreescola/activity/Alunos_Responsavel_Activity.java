package carros.com.br.crecheepreescola.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Alunos_Responsavel;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Tur_Cal;
import carros.com.br.crecheepreescola.dominio.Pessoa;
import carros.com.br.crecheepreescola.fragment.AlunosFragment;
import carros.com.br.crecheepreescola.fragment.AlunosResponsavelFragment;
import carros.com.br.crecheepreescola.fragment.PCalendarioFragment;
import carros.com.br.crecheepreescola.fragment.TurmasFragment;

public class Alunos_Responsavel_Activity extends AppCompatActivity {

    private static final String TAG = "Alunos_Responsavel_Activity";
    private SectionsPageAdapter_Alunos_Responsavel mSectionsPageAdapter;
    private ViewPager mViewPager;
    public static int idResponsavel = Login.idLogin;


    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsavel_alunos);

        Intent intent = getIntent();
        Pessoa pessoa = intent.getParcelableExtra("pessoaId");
        //idResponsavel = pessoa.getId(); // DESCOMENTAR ASSIM QUE RECEBER DA TELA DE LOGIN.

        Log.d(TAG, "onCreate: Starting.");
        mSectionsPageAdapter = new SectionsPageAdapter_Alunos_Responsavel(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container_Alunos_Responsavel);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsAlunos);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager (ViewPager viewPager){

        SectionsPageAdapter_Alunos_Responsavel adapter = new SectionsPageAdapter_Alunos_Responsavel(getSupportFragmentManager());
        adapter.addFragment(new AlunosResponsavelFragment(), "MEUS FILHOS");
        viewPager.setAdapter(adapter);
    }

    public int obterIdResponsavel(){
        return idResponsavel;
    }

}
