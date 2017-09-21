package com.proprog.quizapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * App contains 4 - 10 questions,
 * including at least one check box, one radio button, and one text entry.
 * Questions are in a variety of formats such as free text response,
 * checkboxes, and radio buttons.
 * App includes a button for the user to submit their answers and receive a score.
 * The app includes at least four of the following Views:
 * TextView, ImageView, Button, Checkbox, EditText,
 * LinearLayout, RelativeLayout, ScrollView, RadioButton, RadioGroup.
 * If applicable, the app uses nested ViewGroups to reduce the complexity of the layout.
 * The app gracefully handles displaying all the content on screen when rotated.
 * Either by updating the layout,
 * adding a scrollable feature or some other mechanism that adheres to Android development guidelines.
 */
public class MainActivity extends AppCompatActivity {

    private int countCorrectAnswers = 0;
    private int numOfCorrectChosen = 0;
    private int numOfActualChosen = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean answerForQuestionOne() {
        boolean check = false;
        RadioGroup groupQuestionOne = (RadioGroup) findViewById(R.id.question_one_group);
        RadioButton radioButton = (RadioButton) findViewById(groupQuestionOne.getCheckedRadioButtonId());
        String checkedAnswer = "";
        if (radioButton != null) {
            checkedAnswer = radioButton.getText().toString();
        }
        String correctAnswer = getString(R.string.question_one_correct);

        if (checkedAnswer.equals(correctAnswer)) {
            check = true;
            countCorrectAnswers++;
        }
        return check;
    }

    public boolean answerForQuestionTwo() {
        boolean check = false;
        RadioGroup groupQuestionTwo = (RadioGroup) findViewById(R.id.question_two_group);
        RadioButton radioButton = (RadioButton) findViewById(groupQuestionTwo.getCheckedRadioButtonId());
        String checkedAnswer = "";
        if (radioButton != null) {
            checkedAnswer = radioButton.getText().toString();
        }
        String correctAnswer = getString(R.string.question_two_correct);
        if (checkedAnswer.equals(correctAnswer)) {
            check = true;
            countCorrectAnswers++;
        }
        return check;
    }

    public boolean answerForQuestionThree() {
        boolean check = false;
        EditText enteredAnswer = (EditText) findViewById(R.id.q3_answer);
        String checkedAnswer = enteredAnswer.getText().toString();
        String correctAnswer = getString(R.string.question_three_correct);
        if (checkedAnswer.equalsIgnoreCase(correctAnswer)) {
            check = true;
            countCorrectAnswers++;
        }
        return check;
    }

    public boolean answerForQuestionFour() {
        boolean check = false;
        EditText enteredAnswer = (EditText) findViewById(R.id.q4_answer);
        String checkedAnswer = enteredAnswer.getText().toString();
        String correctAnswer = getString(R.string.question_four_correct);
        if (checkedAnswer.equalsIgnoreCase(correctAnswer)) {
            check = true;
            countCorrectAnswers++;
        }
        return check;
    }

    public boolean answerForQuestionFive() {
        boolean check = false;
        int numOfChosen = 0;


        //prepare checkboxes
        CheckBox firstChoiceCheckBox = (CheckBox) findViewById(R.id.q5_a);
        CheckBox secondChoiceCheckBox = (CheckBox) findViewById(R.id.q5_b);
        CheckBox thirdChoiceCheckBox = (CheckBox) findViewById(R.id.q5_c);
        CheckBox fourthChoiceCheckBox = (CheckBox) findViewById(R.id.q5_d);

        //check checkboxes states
        String firstAnswer = firstChoiceCheckBox.getText().toString();
        String secondAnswer = secondChoiceCheckBox.getText().toString();
        String thirdAnswer = thirdChoiceCheckBox.getText().toString();
        String fourthAnswer = fourthChoiceCheckBox.getText().toString();

        boolean isFirstAnswerChecked = firstChoiceCheckBox.isChecked();
        boolean isSecondAnswerChecked = secondChoiceCheckBox.isChecked();
        boolean isThirdAnswerChecked = thirdChoiceCheckBox.isChecked();
        boolean isFourthAnswerChecked = fourthChoiceCheckBox.isChecked();

        numOfChosen = isQuestionFiveCorrect(isFirstAnswerChecked, firstAnswer);
        numOfChosen = isQuestionFiveCorrect(isSecondAnswerChecked, secondAnswer);
        numOfChosen = isQuestionFiveCorrect(isThirdAnswerChecked, thirdAnswer);
        numOfChosen = isQuestionFiveCorrect(isFourthAnswerChecked, fourthAnswer);

        if (numOfChosen == 2) {
            countCorrectAnswers++;
            check = true;
        }

        return check;
    }

    public int isQuestionFiveCorrect(boolean isChosen, String checkedAnswer) {
        //get correct answers
        String firstCorrectAnswer = getString(R.string.question_five_correct_1);
        String secondCorrectAnswer = getString(R.string.question_five_correct_2);
        if (isChosen) {
            numOfActualChosen++;
            if (firstCorrectAnswer.equals(checkedAnswer) || secondCorrectAnswer.equals(checkedAnswer)) {
                numOfCorrectChosen++;
            }
        }
        if (numOfActualChosen > 2) {
            numOfCorrectChosen = 0;
            return 0;
        }
        return numOfCorrectChosen;
    }

    public void submitUserAnswers(View view) {

        answerForQuestionOne();
        answerForQuestionTwo();
        answerForQuestionThree();
        answerForQuestionFour();
        answerForQuestionFive();
        Toast.makeText(this, "Correct " + countCorrectAnswers, Toast.LENGTH_SHORT).show();
        countCorrectAnswers = 0;
        numOfCorrectChosen = 0;
        numOfActualChosen = 0;

    }

}
