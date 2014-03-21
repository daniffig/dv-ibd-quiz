package com.dvorakdev.ibdquiz;

import com.dvorakdev.ibdquiz.model.Quiz;
import com.dvorakdev.ibdquiz.model.QuizQuestionAnswer;
import com.dvorakdev.ibdquiz.model.QuizQuestion;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	SparseArray<Quiz> quizArray = new SparseArray<Quiz>();
	
	private Boolean isLoaded = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Quiz.truncate();
		
		if (Quiz.all().size() == 0)
		{
			for (int a = 0; a < 4; a++)
			{			
				Quiz aQuiz = new Quiz();

				aQuiz.setName(String.format("a Quiz %d", a));

				aQuiz.save();

				for (int i = 0; i < 4; i++)
				{
					QuizQuestion aQuizQuestion = new QuizQuestion();

					aQuizQuestion.setQuiz(aQuiz);
					aQuizQuestion.setQuestion(String.format("a QuizQuestion %d %d", a, i));

					aQuizQuestion.save();

					for (int j = 0; j < 4; j++)
					{
						QuizQuestionAnswer aQuizQuestionAnswer = new QuizQuestionAnswer();

						aQuizQuestionAnswer.setQuizQuestion(aQuizQuestion);
						aQuizQuestionAnswer.setAnswer(String.format("a QuizAnswer %d %d %d", a, i, j));

						aQuizQuestionAnswer.save();
					}

					aQuizQuestion.setCorrectQuizAnswer(aQuizQuestion.getQuizQuestionAnswers().get(0));
					aQuizQuestion.save();
				}
			}
		}
		
		Spinner quizSpinner = (Spinner) this.findViewById(R.id.quizSpinner);
		
		quizSpinner.setAdapter(new ArrayAdapter<Quiz>(this, android.R.layout.simple_spinner_item, Quiz.all()));
		
		quizSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (MainActivity.this.isLoaded)
				{
					Log.i("MainActivity", arg0.getSelectedItem().toString());
					MainActivity.this.openQuiz((Quiz) arg0.getSelectedItem());
				}
				else
				{
					MainActivity.this.isLoaded = true;
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void openQuiz(Quiz aQuiz)
	{		
		this.getApplicationContext().getSharedPreferences("IBDQuiz", 0).edit().putLong("selectedQuiz.id", aQuiz.getId()).commit();
		
		this.startActivity(new Intent(this, QuizActivity.class));
	}

}
