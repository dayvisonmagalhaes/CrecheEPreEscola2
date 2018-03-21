package carros.com.br.crecheepreescola.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import carros.com.br.crecheepreescola.R;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Diario_Msg;
import carros.com.br.crecheepreescola.adapter.SectionsPageAdapter_Tur_Cal;
import carros.com.br.crecheepreescola.fragment.DiarioFragment;
import carros.com.br.crecheepreescola.fragment.DiarioFragment2;
import carros.com.br.crecheepreescola.fragment.MsgFragment;
import carros.com.br.crecheepreescola.fragment.PCalendarioFragment;
import carros.com.br.crecheepreescola.fragment.PTurmasFragment;

public class Diario_Msg_Activity extends AppCompatActivity {

    private static final String TAG = "Diario_Msg_Activity";
    private SectionsPageAdapter_Diario_Msg mSectionsPageAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario__msg_);

        Log.d(TAG, "onCreate: Starting.");
        mSectionsPageAdapter = new SectionsPageAdapter_Diario_Msg(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container_Diario_Msg);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_Diario_Msg);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager (ViewPager viewPager){

        SectionsPageAdapter_Diario_Msg adapter = new SectionsPageAdapter_Diario_Msg(getSupportFragmentManager());
        adapter.addFragment(new DiarioFragment2(), "DIÁRIO");
        adapter.addFragment(new MsgFragment(), "MENSAGEM");
        viewPager.setAdapter(adapter);
    }
}
