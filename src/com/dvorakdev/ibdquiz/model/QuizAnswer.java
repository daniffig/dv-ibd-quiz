package com.dvorakdev.ibdquiz.model;

import android.content.Context;

import com.orm.SugarRecord;

public class QuizAnswer extends SugarRecord<QuizAnswer> {
	
	private QuizQuestion quizQuestion;

	public QuizAnswer(Context arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public QuizQuestion getQuizQuestion() {
		return quizQuestion;
	}

	public void setQuizQuestion(QuizQuestion quizQuestion) {
		this.quizQuestion = quizQuestion;
	}

}
