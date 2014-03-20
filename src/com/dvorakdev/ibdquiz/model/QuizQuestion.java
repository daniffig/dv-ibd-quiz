package com.dvorakdev.ibdquiz.model;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;

@Table(name = "QuizQuestion")
public class QuizQuestion extends Model {
	
	@Column(name = "Quiz")
	private Quiz quiz;
	
	@Column(name = "Question")
	private String question;

	@Column(name = "CorrectQuizAnswer")	
	private QuizAnswer correctQuizAnswer;
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuizAnswer getCorrectQuizAnswer() {
		return correctQuizAnswer;
	}

	public void setCorrectQuizAnswer(QuizAnswer correctQuizAnswer) {
		this.correctQuizAnswer = correctQuizAnswer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

    public List<QuizAnswer> getQuizAnswers()
    {
        return this.getMany(QuizAnswer.class, "QuizQuestion");
    }
    
    public static List<QuizQuestion> all()
    {
    	return Model.all(QuizQuestion.class);
    }
    
    public static void truncate()
    {
    	Model.delete(QuizQuestion.class);
    }

}
