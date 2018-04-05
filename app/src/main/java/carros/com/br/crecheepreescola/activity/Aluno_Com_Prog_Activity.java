package carros.com.br.crecheepreescola.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Alu_Com_Prog;
import carros.com.br.crecheepreescola.dominio.Diario;
import carros.com.br.crecheepreescola.dominio.Turma;
import carros.com.br.crecheepreescola.fragment.AlunosFragment;
import carros.com.br.crecheepreescola.fragment.ComunicadoFragment;
import carros.com.br.crecheepreescola.fragment.ProgramaFragment;

public class Aluno_Com_Prog_Activity extends AppCompatActivity {

    private static final String TAG = "Aluno_Com_Prog_Activity";
    private SectionsPageAdapter_Alu_Com_Prog mSectionsPageAdapter;
    private ViewPager mViewPager;
    public static int idTurma;

//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno__com__prog_);

        //CAPTURANDO O "putExtra" DA TELA ANTERIOR (ListaTurmaAdapter)
        Intent intent = getIntent();
        Turma turma = intent.getParcelableExtra("turmaSelecionada");
        idTurma = turma.getId();

        Log.d("TurmaPacelable" , "ID: " + idTurma );


        Log.d(TAG, "onCreate: Starting.");
        mSectionsPageAdapter = new SectionsPageAdapter_Alu_Com_Prog(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container_Aluno_Com_Prog);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_Aluno_Com_Prog);
        tabLayout.setupWithViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager) {

        SectionsPageAdapter_Alu_Com_Prog adapter = new SectionsPageAdapter_Alu_Com_Prog(getSupportFragmentManager());
        adapter.addFragment(new AlunosFragment(), "ALUNOS");
        adapter.addFragment(new ComunicadoFragment(), "COMUNICADOS");
        adapter.addFragment(new ProgramaFragment(), "PROGRAMAS");
        viewPager.setAdapter(adapter);
    }

    public int obterIdTurma(){

        return idTurma;
    }
}
