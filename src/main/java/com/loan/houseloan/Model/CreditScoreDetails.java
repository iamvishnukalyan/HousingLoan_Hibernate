package com.loan.houseloan.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CreditScoreDetails")
public class CreditScoreDetails {

	@Id
	@Column(name = "panCard")
	private String panCard = "ccipc";

	@Column(name = "CreditScore")
	private int CreditScore;

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public int getCreditScore() {
		return CreditScore;
	}

	public void setCreditScore(int creditScore) {
		CreditScore = creditScore;
	}

}
