package com.dvorakdev.ibdquiz;

import com.dvorakdev.ibdquiz.model.Quiz;
import com.dvorakdev.ibdquiz.model.QuizQuestion;

import android.os.Bundle;
import android.app.Activity;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

public class QuizActivity extends Activity {
	
	SparseArray<QuizQuestion> quizQuestionArray = new SparseArray<QuizQuestion>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		// Show the Up button in the action bar.
		//setupActionBar();
		
		Quiz selectedQuiz = Quiz.load(Quiz.class, this.getApplicationContext().getSharedPreferences("IBDQuiz", 0).getLong("selectedQuiz.id", -1));
		
		TextView quizNameTextView = (TextView) this.findViewById(R.id.quizNameTextView);		
		RadioGroup quizQuestionRadioGroup = (RadioGroup) this.findViewById(R.id.quizQuestionRadioGroup);
		
		quizNameTextView.setText(selectedQuiz.getName());
		
		for (QuizQuestion aQuizQuestion : selectedQuiz.getQuizQuestions())
		{
			RadioButton aRadioButton = new RadioButton(this);
			
			aRadioButton.setText(aQuizQuestion.getQuestion());
			aRadioButton.setTextColor(Color.BLACK);
			
			quizQuestionArray.put(aRadioButton.hashCode(), aQuizQuestion);
			
			quizQuestionRadioGroup.addView(aRadioButton);
		}
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
	
	public void openQuizQuestion(View view)
	{
		RadioGroup quizQuestionRadioGroup = (RadioGroup) this.findViewById(R.id.quizQuestionRadioGroup);
		
		if (quizQuestionRadioGroup.getCheckedRadioButtonId() == -1)
		{
			
		}
		else
		{
			QuizQuestion selectedQuizQuestion = quizQuestionArray.get(this.findViewById(quizQuestionRadioGroup.getCheckedRadioButtonId()).hashCode());	
			
			this.getApplicationContext().getSharedPreferences("IBDQuiz", 0).edit().putLong("selectedQuizQuestion.id", selectedQuizQuestion.getId()).commit();
			
			//this.startActivity(new Intent(this, QuizQuestionActivity.class));
		}
	}

}
