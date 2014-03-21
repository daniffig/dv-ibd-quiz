package com.dvorakdev.ibdquiz;

import com.dvorakdev.ibdquiz.model.QuizQuestion;
import com.dvorakdev.ibdquiz.model.QuizQuestionAnswer;

import android.os.Bundle;
import android.app.Activity;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;

public class QuizQuestionActivity extends Activity {
	
	SparseArray<QuizQuestionAnswer> quizQuestionAnswerArray = new SparseArray<QuizQuestionAnswer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz_question);
		// Show the Up button in the action bar.
		setupActionBar();
		
		QuizQuestion selectedQuizQuestion = QuizQuestion.load(QuizQuestion.class, this.getApplicationContext().getSharedPreferences("IBDQuiz", 0).getLong("selectedQuizQuestion.id", -1));
				
		TextView quizQuestionTextView = (TextView) this.findViewById(R.id.quizQuestionTextView);		
		RadioGroup quizQuestionAnswerRadioGroup = (RadioGroup) this.findViewById(R.id.quizQuestionAnswerRadioGroup);
		
		quizQuestionTextView.setText(selectedQuizQuestion.getQuestion());
		
		for (QuizQuestionAnswer aQuizQuestionAnswer : selectedQuizQuestion.getQuizQuestionAnswers())
		{
			RadioButton aRadioButton = new RadioButton(this);
			
			aRadioButton.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub					
					QuizQuestionActivity.this.checkQuizAnswer(v);
				}				
			});
			
			aRadioButton.setText(aQuizQuestionAnswer.getAnswer());
			aRadioButton.setTextColor(Color.BLACK);
			
			quizQuestionAnswerArray.put(aRadioButton.hashCode(), aQuizQuestionAnswer);
			
			quizQuestionAnswerRadioGroup.addView(aRadioButton);
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
		getMenuInflater().inflate(R.menu.quiz_question, menu);
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
	
	private void checkQuizAnswer(View view)
	{
		RadioGroup quizQuestionAnswerRadioGroup = (RadioGroup) this.findViewById(R.id.quizQuestionAnswerRadioGroup);
		
		if (quizQuestionAnswerRadioGroup.getCheckedRadioButtonId() == -1)
		{
			//	TODO i18n
			Toast.makeText(this.getApplicationContext(), "Debe seleccionar una respuesta.", Toast.LENGTH_SHORT).show();
		}
		else
		{			
			QuizQuestionAnswer selectedQuizQuestionAnswer = quizQuestionAnswerArray.get(this.findViewById(quizQuestionAnswerRadioGroup.getCheckedRadioButtonId()).hashCode());
			
			if (selectedQuizQuestionAnswer.isCorrect())
			{
				//	TODO i18n
				Toast.makeText(this.getApplicationContext(), "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
				
				this.finish();
			}
		}		
	}

}
