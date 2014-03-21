package com.dvorakdev.ibdquiz.model;

import java.io.Serializable;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;
import com.activeandroid.annotation.Column.ForeignKeyAction;

@Table(name = "QuizAnswer")
public class QuizQuestionAnswer extends Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8970540366330756815L;

	@Column(name = "QuizQuestion", onDelete = ForeignKeyAction.CASCADE)
	private QuizQuestion quizQuestion;
	
	@Column(name = "Answer")
	private String answer;

	public QuizQuestion getQuizQuestion() {
		return quizQuestion;
	}

	public void setQuizQuestion(QuizQuestion quizQuestion) {
		this.quizQuestion = quizQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Boolean isCorrect()
	{
		return this.getQuizQuestion().getCorrectQuizAnswer().equals(this);
	}
}
