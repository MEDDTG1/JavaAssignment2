package meddtg.bit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Results extends AppCompatActivity implements View.OnClickListener {
    private ImageView image;
    private  int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent FinaleResults = getIntent();
        score = FinaleResults.getIntExtra("Results", -1);
        TextView tv = findViewById(R.id.textViewResult);
        tv.setText(score + " out of 10");
        Button rtybutton = (Button) findViewById(R.id.retrybtn);
        rtybutton.setOnClickListener(this);
        image = findViewById(R.id.imageView2);
        image.setImageResource(R.drawable.up);
        setImage();
    }

    /**
     * this changes the image in the results screen depending on the users score
     * if they get under 5 then a thumbs down is displayed and if above 5 a thumbs up
     */
    public void setImage() {
        if (score < 5) {
            image.setImageResource(R.drawable.down);
        }
    }

    @Override
    public void onClick(View v) {
        System.exit(0);
    }
}