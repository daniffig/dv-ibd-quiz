package com.dvorakdev.ibdquiz;

import com.dvorakdev.ibdquiz.model.QuizQuestion;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		for (int i = 0; i < 10; i++)
		{
			QuizQuestion aQuizQuestion = new QuizQuestion();
			
			aQuizQuestion.setQuestion(String.format("QuizQuestion %d", i));
			
			aQuizQuestion.save();
		}
		
		RadioGroup quizQuestionRadioGroup = (RadioGroup) this.findViewById(R.id.quizQuestionRadioGroup);
		
		for (QuizQuestion aQuizQuestion : QuizQuestion.all())
		{
			RadioButton aRadioButton = new RadioButton(this);
			
			aRadioButton.setText(aQuizQuestion.getQuestion());
			
			quizQuestionRadioGroup.addView(aRadioButton);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
