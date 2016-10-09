package info.androidhive.cardview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Tony Ayebare on 7/25/16.
 */
public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        try{
            PlayWithRawFiles();
        }catch (IOException e){
            Toast.makeText(getApplicationContext(), "Problem:" +e.getMessage(), Toast.LENGTH_LONG
            ).show();
        }
    }
    public void PlayWithRawFiles() throws IOException{
        String str="";
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.ca);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if (is!= null){
            while ((str = reader.readLine()) != null){
                buf.append(str +"\n");
            }
        }
        is.close();
        TextView tv = (TextView)findViewById(R.id.abouttxt);
        tv.setText(buf.toString());
    }
}
