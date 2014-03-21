package com.dvorakdev.ibdquiz.model;

import java.io.Serializable;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;
import com.activeandroid.annotation.Column.ForeignKeyAction;

@Table(name = "QuizQuestion")
public class QuizQuestion extends Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 300646480872544139L;

	@Column(name = "Quiz")
	private Quiz quiz;
	
	@Column(name = "Question", onDelete = ForeignKeyAction.CASCADE)
	private String question;

	@Column(name = "CorrectQuizAnswer")	
	private QuizQuestionAnswer correctQuizAnswer;

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuizQuestionAnswer getCorrectQuizAnswer() {
		return correctQuizAnswer;
	}

	public void setCorrectQuizAnswer(QuizQuestionAnswer correctQuizAnswer) {
		this.correctQuizAnswer = correctQuizAnswer;
	}

    public List<QuizQuestionAnswer> getQuizQuestionAnswers()
    {
        return this.getMany(QuizQuestionAnswer.class, "QuizQuestion");
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
