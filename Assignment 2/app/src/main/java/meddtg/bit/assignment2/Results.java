package meddtg.bit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent FinaleResults = getIntent();
        int score = FinaleResults.getIntExtra("Results", -1);
        TextView tv = findViewById(R.id.textViewResult);
        tv.setText(score + " out of 10");
    }
}