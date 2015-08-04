package info.androidhive.slidingmenu;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.joker.laughs.R;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
	private InterstitialAd interAd;
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
    	interAd= new InterstitialAd(rootView.getContext());
		interAd.setAdUnitId("ca-app-pub-2026106398422810/7602454480");
		//AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        interAd.loadAd(adRequest);
        
        interAd.setAdListener(new AdListener() {
			public void onAdLoaded() {
				// Call displayInterstitial() function
				displayInterstitial();
			}
		});
        
        
        
       //mAdView.loadAd(adRequest);
        return rootView;
    }
	public void displayInterstitial()
	{
		if(interAd.isLoaded())
		{
			interAd.show();
		}
	}
}
