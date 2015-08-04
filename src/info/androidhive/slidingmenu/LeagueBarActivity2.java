package info.androidhive.slidingmenu;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TabHost;
import com.joker.laughs.R;

public class LeagueBarActivity2 extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nicholsontab);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, Tab1League2.class);
        spec = tabHost.newTabSpec("Sound 1").setIndicator("Sound 1")
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, Tab2League2.class);
        spec = tabHost.newTabSpec("Sound 2").setIndicator("Sound 2")
                      .setContent(intent);
        tabHost.addTab(spec);
        




       
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
        	  Intent intent = new Intent(LeagueBarActivity2.this, LeagueBarActivity.class);
              startActivity(intent);
            
        }
        return super.onKeyDown(keyCode, event);
    }
}