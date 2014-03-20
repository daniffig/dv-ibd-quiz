package com.dvorakdev.ibdquiz.model;

import java.util.Collection;

import android.content.Context;

import com.orm.SugarRecord;

public class QuizQuestion extends SugarRecord<QuizQuestion> {
	
	private Quiz quiz;
	private Collection<QuizAnswer> quizAnswers;

	public QuizQuestion(Context arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Collection<QuizAnswer> getQuizAnswers() {
		return quizAnswers;
	}

	public void setQuizAnswers(Collection<QuizAnswer> quizAnswers) {
		this.quizAnswers = quizAnswers;
	}
	
	public void addQuizAnswer(QuizAnswer aQuizAnswer)
	{
		aQuizAnswer.setQuizQuestion(this);
		this.getQuizAnswers().add(aQuizAnswer);
	}

}
