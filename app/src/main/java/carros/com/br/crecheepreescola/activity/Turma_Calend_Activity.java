package carros.com.br.crecheepreescola.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Tur_Cal;
import carros.com.br.crecheepreescola.fragment.CalendarioFragment;
import carros.com.br.crecheepreescola.fragment.PCalendarioFragment;
import carros.com.br.crecheepreescola.fragment.TurmasFragment;

public class Turma_Calend_Activity extends AppCompatActivity {

    private static final String TAG = "Turma_Calend_Activity";
    private SectionsPageAdapter_Tur_Cal mSectionsPageAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turma__calend_);

        Log.d(TAG, "onCreate: Starting.");
        mSectionsPageAdapter = new SectionsPageAdapter_Tur_Cal(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container_turmas_calend);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_turmas_calend);
        tabLayout.setupWithViewPager(mViewPager);


    }
    private void setupViewPager (ViewPager viewPager){

        SectionsPageAdapter_Tur_Cal adapter = new SectionsPageAdapter_Tur_Cal(getSupportFragmentManager());
        adapter.addFragment(new TurmasFragment(), "TURMAS");
        adapter.addFragment(new CalendarioFragment(), "CALENDÁRIO");
        viewPager.setAdapter(adapter);
    }
}
