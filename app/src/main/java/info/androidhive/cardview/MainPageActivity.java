package info.androidhive.cardview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Tony Ayebare on 7/25/16.
 */
public class MainPageActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        ImageButton bank = (ImageButton)findViewById(R.id.bank);
        ImageButton mfi = (ImageButton)findViewById(R.id.mfi);
        TextView banktext = (TextView)findViewById(R.id.textView5);
        TextView mfitext = (TextView)findViewById(R.id.textView6);

        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });

        mfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivityTwo.class);
                startActivity(i);

            }
        });





    }
}
