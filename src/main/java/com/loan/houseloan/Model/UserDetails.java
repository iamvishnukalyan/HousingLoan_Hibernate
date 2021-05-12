package com.loan.houseloan.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class UserDetails {

	@Id
	@Column(name = "userid")
	private String id;

	@Column(name = "age")
	private int age;

	@Column(name = "panCardNumber")
	private String panCardNumber;

	@Column(name = "creditScore")
	private int creditScore;

	@Column(name = "distanceFromBank")
	private int distanceFromBank;

	@Column(name = "repaymentPeriod")
	private int repaymentPeriod;

	@Column(name = "workExperience")
	private int workExperience;

	@Column(name = "occupation")
	private int occupation;

	@Column(name = "relationWithBank")
	private int relationWithBank;

	@Column(name = "LoanAmount")
	private int loanAmount;

	@Column(name = "ApprovedAmount")
	private int approvedAmount;

	@Column(name = "isApprovedAmountOk")
	private boolean isApprovedAmountOk;

	@Column(name = "ApprovedStatus")
	private boolean approvedStatus = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getDistanceFromBank() {
		return distanceFromBank;
	}

	public void setDistanceFromBank(int distanceFromBank) {
		this.distanceFromBank = distanceFromBank;
	}

	public int getRepaymentPeriod() {
		return repaymentPeriod;
	}

	public void setRepaymentPeriod(int repaymentPeriod) {
		this.repaymentPeriod = repaymentPeriod;
	}

	public int getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
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

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public int getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(int approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public boolean isApprovedAmountOk() {
		return isApprovedAmountOk;
	}

	public void setApprovedAmountOk(boolean isApprovedAmountOk) {
		this.isApprovedAmountOk = isApprovedAmountOk;
	}

	public boolean isApprovedStatus() {
		return approvedStatus;
	}

	public void setApprovedStatus(boolean approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

}
