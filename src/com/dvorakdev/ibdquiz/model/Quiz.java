package com.dvorakdev.ibdquiz.model;

import java.util.Collection;

import android.content.Context;

import com.orm.SugarRecord;

public class Quiz extends SugarRecord<Quiz> {
	
	private String name;
	private Collection<QuizQuestion> quizQuestions;

	public Quiz(Context arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<QuizQuestion> getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(Collection<QuizQuestion> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}
	
	public void addQuizQuestion(QuizQuestion aQuizQuestion)
	{
		aQuizQuestion.setQuiz(this);
		this.getQuizQuestions().add(aQuizQuestion);
	}

}
