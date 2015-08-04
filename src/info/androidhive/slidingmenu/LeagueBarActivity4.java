package info.androidhive.slidingmenu;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import com.joker.laughs.R;

public class LeagueBarActivity4 extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherstab);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, Tab1League4.class);
        spec = tabHost.newTabSpec("Sound 1").setIndicator("Sound 1")
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, Tab2League4.class);
        spec = tabHost.newTabSpec("Sound 2").setIndicator("Sound 2")
                      .setContent(intent);
        tabHost.addTab(spec);
        




       
    }
}