package info.androidhive.cardview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tony Ayebare on 7/27/16.
 */
public class FinanceActivity extends AppCompatActivity {
    ImageView thumbnail;
    TextView title;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.financial);

        title = (TextView)findViewById(R.id.finname);
        title.setText(""+getIntent().getStringExtra("name"));

        thumbnail = (ImageView)findViewById(R.id.banklogo);
        thumbnail.setImageResource(getIntent().getIntExtra("thumbnail",00));

       ImageButton button = (ImageButton) findViewById(R.id.location);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MapActivity.class);
                startActivity(i);

            }
        });

    }
}
