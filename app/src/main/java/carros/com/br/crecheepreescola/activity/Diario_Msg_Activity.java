package carros.com.br.crecheepreescola.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Diario_Msg;
import carros.com.br.crecheepreescola.dominio.Aluno;
import carros.com.br.crecheepreescola.fragment.DiarioFragment;
import carros.com.br.crecheepreescola.fragment.MsgFragment;

public class Diario_Msg_Activity extends AppCompatActivity {

    private static final String TAG = "Diario_Msg_Activity";
    private SectionsPageAdapter_Diario_Msg mSectionsPageAdapter;
    private ViewPager mViewPager;
    public static int idAluno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario__msg_);

        //CAPTURANDO O "putExtra" DA TELA ANTERIOR (ListaAlunoAdapter)
        Intent intent = getIntent();

        Aluno aluno = intent.getParcelableExtra("alunoSelecionado");
        idAluno = aluno.getId();
        Log.i("idAluno_Diario_MsgActi:",  "ID: " + idAluno);

        Log.d(TAG, "onCreate: Starting.");
        mSectionsPageAdapter = new SectionsPageAdapter_Diario_Msg(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container_Diario_Msg);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_Diario_Msg);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager (ViewPager viewPager){

        SectionsPageAdapter_Diario_Msg adapter = new SectionsPageAdapter_Diario_Msg(getSupportFragmentManager());
        adapter.addFragment(new DiarioFragment(), "DIÁRIO");
        adapter.addFragment(new MsgFragment(), "MENSAGEM");
        viewPager.setAdapter(adapter);
    }
}
