package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class activity2 extends AppCompatActivity {

    public String[] letters={"ہ","أ","ع","ح","غ","خ","ق","ک","ج","ش","ی","ض","ل","ن","ر","ت","د","ط","ث","ذ","ظ","س","ز","ص","ن","م","ف","ب","م","و","بىِ","بوُ","باَ"};

    public String[] answers1 ={"Shajariyah-Haafiyah","Lahatiyah","Halqiyah","Tarfiyah"};
    public String[] answers2 ={"Nit-eeyah","Lisaveyah","Ghunna","Tarfiyah"};
    //
    public int rightAnswerCount =0;
    public String[] rightAnswerString = new String [33];
    public int IndexOfRightAnswer = 0;
    public int counter = -1;
    public String[] randomQuestions = new String [33];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init1();
        NextClick(null);
    }


    public void init1() {

        for(int i=0;i<33;i++) {
            randomQuestions[i]=letters[i];
        }
        shuffleArray(randomQuestions);
        //getText(View view);
    }

    //0-14
    //15-32
    String radioButtonOption = "";
    boolean click = false;
    public void f1(View view){
        Button button10 = (Button) findViewById(R.id.nextID);
        button10.setText("RadioButton1");
        RadioButton tempRadioButton = (RadioButton)findViewById(R.id.radioButton1);
        String RadioButtonText = (String)tempRadioButton.getText();
        radioButtonOption = RadioButtonText;
        click = true;
    }
    public void f2(View view){
        Button button10 = (Button) findViewById(R.id.nextID);
        button10.setText("RadioButton2");
        RadioButton tempRadioButton = (RadioButton)findViewById(R.id.radioButton2);
        String RadioButtonText = (String)tempRadioButton.getText();
        radioButtonOption = RadioButtonText;
        click = true;
    }
    public void f3(View view){
        Button button10 = (Button) findViewById(R.id.nextID);
        button10.setText("RadioButton3");
        RadioButton tempRadioButton = (RadioButton)findViewById(R.id.radioButton3);
        String RadioButtonText = (String)tempRadioButton.getText();
        radioButtonOption = RadioButtonText;
        click = true;
    }
    public void f4(View view){
        RadioButton tempRadioButton = (RadioButton)findViewById(R.id.radioButton4);
        String RadioButtonText = (String)tempRadioButton.getText();
        radioButtonOption = RadioButtonText;
        click = true;
    }

    String[] previousAnswer = new String [4];

    public void NextClick(View view) {
        if (click==true || counter==-1) {
            counter = counter + 1;
            if (counter > 32) {
                Intent resultIntent = new Intent(this, ResultActivity.class);
                resultIntent.putExtra("Result",rightAnswerCount);
                resultIntent.putExtra("Total",33);
                startActivity(resultIntent);
            } else if (counter == 32) {
                Button button10 = (Button) findViewById(R.id.nextID);
                button10.setText("Finish");
            }
            RadioButton button1 = (RadioButton) findViewById(R.id.radioButton1);
            RadioButton button2 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton button3 = (RadioButton) findViewById(R.id.radioButton3);
            RadioButton button4 = (RadioButton) findViewById(R.id.radioButton4);

            TextView mcq = (TextView) findViewById(R.id.mcqText);

            shuffleArray(answers1);
            shuffleArray(answers2);


            if(counter > 0){
                int Index = 35;

                if (Index >= 0 && Index < 6) {
                    if (radioButtonOption == "Halqiyah") {
                        rightAnswerCount += 1;
                    }
                } else if (Index >= 6 && Index < 8) {
                    if (radioButtonOption == "Lahatiyah") {
                        rightAnswerCount += 1;
                    }
                } else if (Index >= 9 && Index < 13) {
                    if (radioButtonOption == "Shajariyah-Haafiyah") {
                        rightAnswerCount += 1;
                    }
                } else if (Index >= 13 && Index < 16) {
                    if (radioButtonOption == "Tarfiyah") {
                        rightAnswerCount += 1;
                    }
                } else if (Index >= 16 && Index < 19) {
                    if (radioButtonOption == "Nit-eeyah") {
                        rightAnswerCount += 1;
                    }
                } else if (Index >= 19 && Index < 25) {
                    if (radioButtonOption == "Lisaveyah") {
                        rightAnswerCount += 1;
                    }
                } else if (Index >= 26 && Index < 33) {
                    if (radioButtonOption == "Ghunna") {
                        rightAnswerCount += 1;
                    }
                }
            }
            if (getIndexOfQuestion(randomQuestions[counter]) > 14) {
                button1.setText(answers2[0]);
                button2.setText(answers2[1]);
                button3.setText(answers2[2]);
                button4.setText(answers2[3]);
            }
            else {
                button1.setText(answers1[0]);
                button2.setText(answers1[1]);
                button3.setText(answers1[2]);
                button4.setText(answers1[3]);
            }

            mcq.setText(randomQuestions[counter]);

            click = false;
        }
    }

    public int getIndexOfQuestion(String temp){
        for (int i=0; i<33; i++){
            if(temp==letters[i]){
                return i;
            }
        }
        return -1;
    }


    private static void shuffleArray(String[] array) {
        int index;
        String temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}