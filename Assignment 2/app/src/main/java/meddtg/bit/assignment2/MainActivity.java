package meddtg.bit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Questions[] questions = new Questions[10];
    private int score = 0;
    private  int questionNum = 0;
    private RadioGroup rg;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg= (RadioGroup) findViewById(R.id.radioGroup);
        Button btncheck = (Button) findViewById(R.id.buttoncheck);
        btncheck.setOnClickListener(this);
        image = findViewById(R.id.imageView);
        image.setImageResource(R.drawable.mosgiel);
        score = 0;
        questionNum = 0;
        setQuestion();
        showQuestion();
    }

    public void setQuestion() {
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new Questions(i);
        }
    }

    public  void  showQuestion() {
        TextView quest = findViewById(R.id.questionText);
        quest.setText(questions[questionNum].questionString());
        setUpButtons();
        switch (questionNum){
            case 0:
                image.setImageResource(R.drawable.mosgiel);
            break;
            case 1:
                image.setImageResource(R.drawable.south);
                break;
            case 2:
                image.setImageResource(R.drawable.christchurch);
                break;
            case 3:
                image.setImageResource(R.drawable.nz);
                break;
            case 4:
                image.setImageResource(R.drawable.north);
                break;
            case 5:
                image.setImageResource(R.drawable.sport);
                break;
            case 6:
                image.setImageResource(R.drawable.port);
                break;
            case 7:
                image.setImageResource(R.drawable.east);
                break;
            case 8:
                image.setImageResource(R.drawable.hamilton);
                break;
            case 9:
                image.setImageResource(R.drawable.fizz);
                break;
        }
    }

    public void setUpButtons() {
        RadioButton r1 = findViewById(R.id.radioButton);
        RadioButton r2 = findViewById(R.id.radioButton2);
        RadioButton r3 = findViewById(R.id.radioButton3);
        RadioButton r4 = findViewById(R.id.radioButton4);
        Random rand = new Random();
        switch(rand.nextInt( 4)) {
            case 0:
                r1.setText(questions[questionNum].ans4);
                r2.setText(questions[questionNum].ans3);
                r3.setText(questions[questionNum].ans2);
                r4.setText(questions[questionNum].ans1);
                break;
            case 1:
                r1.setText(questions[questionNum].ans1);
                r2.setText(questions[questionNum].ans4);
                r3.setText(questions[questionNum].ans3);
                r4.setText(questions[questionNum].ans2);
                break;
            case 2:
                r1.setText(questions[questionNum].ans3);
                r2.setText(questions[questionNum].ans1);
                r3.setText(questions[questionNum].ans4);
                r4.setText(questions[questionNum].ans2);
                break;
            case 3:
                r1.setText(questions[questionNum].ans2);
                r2.setText(questions[questionNum].ans3);
                r3.setText(questions[questionNum].ans4);
                r4.setText(questions[questionNum].ans1);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(rg.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Please Select an Answer", Toast.LENGTH_LONG).show();
        }
        else if (questionNum < questions.length) {
            RadioGroup rg = findViewById(R.id.radioGroup);
            int selected = rg.getCheckedRadioButtonId();
            RadioButton chosen = findViewById(selected);
            if (chosen.getText().equals(questions[questionNum].getAnswer())) {
                score++;
                Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            questionNum++;
            rg.clearCheck();
            if (questionNum < questions.length) {
                showQuestion();
                TextView qNum = findViewById(R.id.qNumber);
                qNum.setText("Question " + (questionNum + 1));
            }
            else {
                Intent changeActivity = new Intent(MainActivity.this, Results.class);
                changeActivity.putExtra("Results", score);
                startActivity(changeActivity);
            }
        }
    }
}