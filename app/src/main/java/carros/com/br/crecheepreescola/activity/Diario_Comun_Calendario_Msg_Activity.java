package carros.com.br.crecheepreescola.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Alu_Com_Prog;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Diario_Comun_Calendario_Msg;
import carros.com.br.crecheepreescola.fragment.AlunosFragment;
import carros.com.br.crecheepreescola.fragment.CalendarioFragment;
import carros.com.br.crecheepreescola.fragment.ComunicadoFragment;
import carros.com.br.crecheepreescola.fragment.DiarioResponsavelFragment;
import carros.com.br.crecheepreescola.fragment.MsgFragment;
import carros.com.br.crecheepreescola.fragment.ProgramaFragment;

public class Diario_Comun_Calendario_Msg_Activity extends AppCompatActivity {

    private static final String TAG = "Diario_Comun_Calendario_Msg_Activity";
    private SectionsPageAdapter_Diario_Comun_Calendario_Msg mSectionsPageAdapter;
    private ViewPager mViewPager;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario__comun__calendario_msg);

        Log.d(TAG, "onCreate: Starting.");
        mSectionsPageAdapter = new SectionsPageAdapter_Diario_Comun_Calendario_Msg(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container_Diario_Comun_Calendario_Msg);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_Diario_Comun_Calendario_Msg);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager (ViewPager viewPager){

        SectionsPageAdapter_Diario_Comun_Calendario_Msg adapter = new SectionsPageAdapter_Diario_Comun_Calendario_Msg(getSupportFragmentManager());
        adapter.addFragment(new DiarioResponsavelFragment(), "DIÁRIO");
        adapter.addFragment(new ComunicadoFragment(), "COMUNICADOS");
        adapter.addFragment(new CalendarioFragment(), "CALENDÁRIO");
        adapter.addFragment(new MsgFragment(), "MENSAGEMS");
        viewPager.setAdapter(adapter);
    }
}
