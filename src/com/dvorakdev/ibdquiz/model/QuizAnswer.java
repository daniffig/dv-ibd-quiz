package com.dvorakdev.ibdquiz.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;

@Table(name = "QuizAnswer")
public class QuizAnswer extends Model {
	
	@Column(name = "QuizQuestion")
	private QuizQuestion quizQuestion;

	public QuizQuestion getQuizQuestion() {
		return quizQuestion;
	}

	public void setQuizQuestion(QuizQuestion quizQuestion) {
		this.quizQuestion = quizQuestion;
	}

}
