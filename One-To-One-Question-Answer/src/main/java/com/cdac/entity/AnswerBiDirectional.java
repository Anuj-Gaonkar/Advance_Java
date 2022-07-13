package com.cdac.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_ans_bi")
public class AnswerBiDirectional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ans_id")
	private int id;
	private String answer;
	
	@OneToOne(mappedBy = "answer", cascade = CascadeType.ALL)
	private QuestionBiDirectional q; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public QuestionBiDirectional getQ() {
		return q;
	}
	public void setQ(QuestionBiDirectional q) {
		this.q = q;
	}
	
}
