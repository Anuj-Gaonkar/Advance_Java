package com.cdac.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_qs_bi")
public class QuestionBiDirectional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="qs_id")
	private int id;
	private String question;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ans_id")
	private AnswerBiDirectional answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public AnswerBiDirectional getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerBiDirectional answer) {
		this.answer = answer;
	}
	
}
