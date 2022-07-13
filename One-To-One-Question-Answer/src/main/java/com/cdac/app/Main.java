package com.cdac.app;

import com.cdac.dao.QuestionAnswerDao;
import com.cdac.entity.Answer;
import com.cdac.entity.AnswerBiDirectional;
import com.cdac.entity.Question;
import com.cdac.entity.QuestionBiDirectional;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuestionAnswerDao dao = new QuestionAnswerDao();
		
		/*
		 * Question q = new Question(); q.setQuestion("What is C"); //
		 * dao.addQuestion(q);
		 * 
		 * Answer ans = new Answer(); ans.setAnswer("C is programming language");
		 * 
		 * 
		 * q.setAnswer(ans); dao.addQuestion(q); // dao.addAnswer(ans); //
		 * dao.update(q);
		 */
		
		QuestionBiDirectional qb = new QuestionBiDirectional();
		qb.setQuestion("python is ?");
		
		
		AnswerBiDirectional ansb = new AnswerBiDirectional();
		ansb.setAnswer("python is Programming labguage");
		
		qb.setAnswer(ansb);
		dao.addQuestion(qb);
		
	}

}
