package com.dvorakdev.ibdquiz;

import com.dvorakdev.ibdquiz.model.QuizQuestion;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;

public class QuizActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		QuizQuestion.truncate();
		
		for (int i = 0; i < 10; i++)
		{
			QuizQuestion aQuizQuestion = new QuizQuestion();
			
			aQuizQuestion.setQuestion(String.format("QuizQuestion %d", i));
			
			aQuizQuestion.save();
		}
		
		RadioGroup quizQuestionRadioGroup = (RadioGroup) this.findViewById(R.id.quizAnswerRadioGroup);
		
		for (QuizQuestion aQuizQuestion : QuizQuestion.all())
		{
			RadioButton aRadioButton = new RadioButton(this.getBaseContext());
			
			aRadioButton.setText(aQuizQuestion.getQuestion());
			aRadioButton.setTextColor(Color.BLACK);
			
			quizQuestionRadioGroup.addView(aRadioButton);
		}
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
