package com.dvorakdev.ibdquiz.model;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;

@Table(name = "Quiz")
public class Quiz extends Model {
	
	@Column(name = "Name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<QuizQuestion> getQuizQuestions()
    {
        return this.getMany(QuizQuestion.class, "Quiz");
    }
    
    public static List<Quiz> all()
    {
    	return Model.all(Quiz.class);
    }
}
