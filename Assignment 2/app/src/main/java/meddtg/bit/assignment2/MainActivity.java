/**
 * This class is the main code for this program which sets up the main quiz
 * and things like images aswell as handling the swapping of images and questions
 */

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
    /**
     * This method is used to set the questions up before they are shown
     */
    public void setQuestion() {
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new Questions(i);
        }
    }

    /**
     * This method puts the images and question onto the screen in the correct questions then calls the
     * setUpButtons method
     */
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

    /**
     * This method sets up the radio buttons and randomizes the location of the answer
     * then puts them onto the screen
     */
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

    /**
     * This method creates an onclick event so that when the submit button is pressed
     * it will check if a radiobutton is selected then checks to see what question the user
     * is on then checks the answer
     *
     * this method also changes the number for the question text at the top of the screen
     *
     * if the user is on the last question this method will send them to the results screen
     * @param v
     */
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
                Toast.makeText(this, "Wrong the correct answer was: " + questions[questionNum].getAnswer(), Toast.LENGTH_LONG).show();
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