package com.loan.houseloan.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoanStandards")
public class LoanStandards {

	@Id
	@Column(name = "HomeLoan")
	private String id;

	@Column(name = "minage")
	private int minAge;

	@Column(name = "maxage")
	private int maxAge;

	@Column(name = "mincreditScore")
	private int mincreditScore;

	@Column(name = "maxcreditScore")
	private int maxcreditScore;

	@Column(name = "mindistanceFromBank")
	private int mindistanceFromBank;

	@Column(name = "maxdistanceFromBank")
	private int maxdistanceFromBank;

	@Column(name = "minrepaymentPeriod")
	private int minrepaymentPeriod;

	@Column(name = "maxrepaymentPeriod")
	private int maxrepaymentPeriod;

	@Column(name = "minworkExperience")
	private int minworkExperience;

	@Column(name = "maxworkExperience")
	private int maxworkExperience;

	@Column(name = "occupation")
	private int occupation;

	@Column(name = "relationWithBank")
	private int relationWithBank;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOccupation() {
		return occupation;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	public int getRelationWithBank() {
		return relationWithBank;
	}

	public void setRelationWithBank(int relationWithBank) {
		this.relationWithBank = relationWithBank;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public int getMincreditScore() {
		return mincreditScore;
	}

	public void setMincreditScore(int mincreditScore) {
		this.mincreditScore = mincreditScore;
	}

	public int getMaxcreditScore() {
		return maxcreditScore;
	}

	public void setMaxcreditScore(int maxcreditScore) {
		this.maxcreditScore = maxcreditScore;
	}

	public int getMindistanceFromBank() {
		return mindistanceFromBank;
	}

	public void setMindistanceFromBank(int mindistanceFromBank) {
		this.mindistanceFromBank = mindistanceFromBank;
	}

	public int getMaxdistanceFromBank() {
		return maxdistanceFromBank;
	}

	public void setMaxdistanceFromBank(int maxdistanceFromBank) {
		this.maxdistanceFromBank = maxdistanceFromBank;
	}

	public int getMinrepaymentPeriod() {
		return minrepaymentPeriod;
	}

	public void setMinrepaymentPeriod(int minrepaymentPeriod) {
		this.minrepaymentPeriod = minrepaymentPeriod;
	}

	public int getMaxrepaymentPeriod() {
		return maxrepaymentPeriod;
	}

	public void setMaxrepaymentPeriod(int maxrepaymentPeriod) {
		this.maxrepaymentPeriod = maxrepaymentPeriod;
	}

	public int getMinworkExperience() {
		return minworkExperience;
	}

	public void setMinworkExperience(int minworkExperience) {
		this.minworkExperience = minworkExperience;
	}

	public int getMaxworkExperience() {
		return maxworkExperience;
	}

	public void setMaxworkExperience(int maxworkExperience) {
		this.maxworkExperience = maxworkExperience;
	}

}
