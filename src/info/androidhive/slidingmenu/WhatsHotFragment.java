package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.joker.laughs.R;

public class WhatsHotFragment extends Fragment {
	
	public WhatsHotFragment(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);
        Intent shareIntent =   
   			 new Intent(android.content.Intent.ACTION_SEND);  
   			  
   			//set the type  
   			shareIntent.setType("text/plain");  
   			  
   			//add a subject  
   			shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,   
   			 "Check out this app: ");  
   			  
   			//build the body of the message to be shared  
   			String shareMessage = "https://play.google.com/store/apps/details?id=com.joker.laughs";  
   			  
   			//add the message  
   			shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,   
   			 shareMessage);  
   			  
   			//start the chooser for sharing  
   			startActivity(Intent.createChooser(shareIntent,   
   			 "Share the app via")); 
        return rootView;
    }
}
