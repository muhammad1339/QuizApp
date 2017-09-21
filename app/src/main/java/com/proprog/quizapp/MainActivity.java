package com.proprog.quizapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
