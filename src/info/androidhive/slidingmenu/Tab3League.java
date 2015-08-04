package info.androidhive.slidingmenu;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.util.ByteArrayBuffer;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.joker.laughs.R;


public class Tab3League extends Activity
{
	//final static String TARGET_BASE_PATH = "/sdcard/appname/voices/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	           WindowManager.LayoutParams.FLAG_FULLSCREEN);
	setContentView(R.layout.hammil1);
	
	findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
		@SuppressLint("NewApi") @Override
		public void onClick(View view) {

			File sound1;
            File directoryTest = new File(
                    Environment.getExternalStorageDirectory(), "raw2sd");
                try {
                    //coping sound file to sd
                    //defining specific directory
                    File soundDir = new File(directoryTest, "ORG");
                    //making directories
                    soundDir.mkdirs();
                    FileOutputStream sound = new FileOutputStream(
                            soundDir.getPath() + "/Joker-Hammil-Three.mp3");
                sound1=new File(soundDir.getPath());
                    InputStream is = getResources().openRawResource(R.raw.hammilthree);
                    int a = is.available();
                    byte[] buf = new byte[a];
                    is.read(buf, 0, a);
                    sound.write(buf);
                    sound.flush();
                    sound.close();
                    Toast.makeText(getApplicationContext(), "File saved at raw2sd/ORG",
                 		   Toast.LENGTH_LONG).show();
                    
                  //RINGTONE
                    File k = new File(sound1, "Joker-Hammil-Three.mp3"); // path is a file to /sdcard/media/ringtone

                    ContentValues values = new ContentValues();
                    values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
                    values.put(MediaStore.MediaColumns.TITLE, "Joker-Hammil-Three");
                    values.put(MediaStore.MediaColumns.SIZE, 215454);
                    values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3");
                    values.put(MediaStore.Audio.Media.ARTIST, "Joker");
                    //values.put(MediaStore.Audio.Media.DURATION, 230);
                    values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
                    values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
                    values.put(MediaStore.Audio.Media.IS_ALARM, false);
                    values.put(MediaStore.Audio.Media.IS_MUSIC, false);

                    //Insert it into the database
                    Uri uri = MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath());
                    getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + k.getAbsolutePath() + "\"", null);
                    Uri newUri = getContentResolver().insert(uri, values);

                    RingtoneManager.setActualDefaultRingtoneUri(Tab3League.this,
                            RingtoneManager.TYPE_RINGTONE, newUri);
                    Toast.makeText(getApplicationContext(), "Sound is set as ringtone",
                 		   Toast.LENGTH_LONG).show();
                    
                        } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    
                }
			
                
                
                
                
               
                
                
                  

		}
	});
	
	findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
		@SuppressLint("NewApi") @Override
		public void onClick(View view) {
			
			File sound1;
            File directoryTest = new File(
                    Environment.getExternalStorageDirectory(), "raw2sd");
                try {
                    //coping sound file to sd
                    //defining specific directory
                    File soundDir = new File(directoryTest, "ORG");
                    //making directories
                    soundDir.mkdirs();
                    FileOutputStream sound = new FileOutputStream(
                            soundDir.getPath() + "/Joker-Hammil-Three.mp3");
                sound1=new File(soundDir.getPath());
                    InputStream is = getResources().openRawResource(R.raw.hammilthree);
                    int a = is.available();
                    byte[] buf = new byte[a];
                    is.read(buf, 0, a);
                    sound.write(buf);
                    sound.flush();
                    sound.close();
                    Toast.makeText(getApplicationContext(), "File saved at raw2sd/ORG",
                 		   Toast.LENGTH_LONG).show();
                    String sharePath = Environment.getExternalStorageDirectory().getPath()
        		            + "/raw2sd/ORG/Joker-Hammil-Three.mp3";
        		    Uri uri = Uri.parse(sharePath);
        		    Intent share = new Intent(Intent.ACTION_SEND);
        		    share.setType("audio/*");
        		    share.putExtra(Intent.EXTRA_STREAM, uri);
        		    startActivity(Intent.createChooser(share, "Share Sound File"));
        			
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    
                }
			
			
			
			}
	});
	
	findViewById(R.id.button4).setOnClickListener(new OnClickListener() {
		@SuppressLint("NewApi") @Override
		public void onClick(View view) {
			MediaPlayer mPlayer2;
			mPlayer2= MediaPlayer.create(Tab3League.this, R.raw.hammilthree);
			        mPlayer2.start();
			
				}
	});
	
   	}
	
	private void copyAssets() {
	    AssetManager assetManager = getAssets();
	    String[] files = null;
	    try {
	        files = assetManager.list("");
	    } catch (IOException e) {
	        Log.e("tag", "Failed to get asset file list.", e);
	    }
	    for(String filename : files) {
	        InputStream in = null;
	        OutputStream out = null;
	        try {
	          in = assetManager.open(filename);
	          File outFile = new File(getExternalFilesDir(null), filename);
	          out = new FileOutputStream(outFile);
	          copyFile(in, out);
	        } catch(IOException e) {
	            Log.e("tag", "Failed to copy asset file: " + filename, e);
	        }     
	        finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    // NOOP
	                }
	            }
	            if (out != null) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                    // NOOP
	                }
	            }
	        }  
	    }
	}
	
	
	
	
	private void copyFile(InputStream in, OutputStream out) throws IOException {
	    byte[] buffer = new byte[1024];
	    int read;
	    while((read = in.read(buffer)) != -1){
	      out.write(buffer, 0, read);
	    }
	}
}



