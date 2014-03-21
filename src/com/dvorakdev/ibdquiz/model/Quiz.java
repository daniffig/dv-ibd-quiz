package com.dvorakdev.ibdquiz.model;

import java.io.Serializable;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.*;

@Table(name = "Quiz")
public class Quiz extends Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6852525868616487970L;
	
	public String toString()
	{
		return this.getName();
	}
	
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
    
    public static void truncate()
    {
    	Model.delete(Quiz.class);
    }
}
