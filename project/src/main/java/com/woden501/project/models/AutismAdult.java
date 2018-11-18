package com.woden501.project.models;

public class AutismAdult {
	private int question1;
	private int question2;
	private int question3;
	private int question4;
	private int question5;
	private int question6;
	private int question7;
	private int question8;
	private int question9;
	private int question10;
	private int age;
	private String gender;
	private String ethnicity;
	private String jaundice;
	private String autism;
	private String countryOfRes;
	private String usedAppBefore;
	private int result;
	private String ageDesc;
	private String relation;
	private String asd;

	public AutismAdult(String question1, String question2, String question3, String question4, String question5,
			String question6, String question7, String question8, String question9, String question10, String age,
			String gender, String ethnicity, String jaundice, String autism, String countryOfRes, String usedAppBefore,
			String result, String ageDesc, String relation, String asd) {
		super();
		this.question1 = Integer.parseInt(question1);
		this.question2 = Integer.parseInt(question2);
		this.question3 = Integer.parseInt(question3);
		this.question4 = Integer.parseInt(question4);
		this.question5 = Integer.parseInt(question5);
		this.question6 = Integer.parseInt(question6);
		this.question7 = Integer.parseInt(question7);
		this.question8 = Integer.parseInt(question8);
		this.question9 = Integer.parseInt(question9);
		this.question10 = Integer.parseInt(question10);
		if (age.equals("?"))
			this.age = 0;
		else
			this.age = Integer.parseInt(age);
		this.gender = gender;
		this.ethnicity = ethnicity;
		this.jaundice = jaundice;
		this.autism = autism;
		this.countryOfRes = countryOfRes;
		this.usedAppBefore = usedAppBefore;
		this.result = Integer.parseInt(result);
		this.ageDesc = ageDesc;
		this.relation = relation;
		this.asd = asd;
	}

	public AutismAdult(int question1, int question2, int question3, int question4, int question5, int question6,
			int question7, int question8, int question9, int question10, int age, String gender, String ethnicity,
			String jaundice, String autism, String countryOfRes, String usedAppBefore, int result, String ageDesc,
			String relation, String asd) {
		super();
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
		this.question7 = question7;
		this.question8 = question8;
		this.question9 = question9;
		this.question10 = question10;
		this.age = age;
		this.gender = gender;
		this.ethnicity = ethnicity;
		this.jaundice = jaundice;
		this.autism = autism;
		this.countryOfRes = countryOfRes;
		this.usedAppBefore = usedAppBefore;
		this.result = result;
		this.ageDesc = ageDesc;
		this.relation = relation;
		this.asd = asd;
	}

	public AutismAdult(AutismAdult adult) {
		super();
		this.question1 = adult.question1;
		this.question2 = adult.question2;
		this.question3 = adult.question3;
		this.question4 = adult.question4;
		this.question5 = adult.question5;
		this.question6 = adult.question6;
		this.question7 = adult.question7;
		this.question8 = adult.question8;
		this.question9 = adult.question9;
		this.question10 = adult.question10;
		this.age = adult.age;
		this.gender = adult.gender;
		this.ethnicity = adult.ethnicity;
		this.jaundice = adult.jaundice;
		this.autism = adult.autism;
		this.countryOfRes = adult.countryOfRes;
		this.usedAppBefore = adult.usedAppBefore;
		this.result = adult.result;
		this.ageDesc = adult.ageDesc;
		this.relation = adult.relation;
		this.asd = adult.asd;
	}

	@Override
	public String toString() {
		return this.question1 + "," + this.question2 + "," + this.question3 + "," + this.question4 + ","
				+ this.question5 + "," + this.question6 + "," + this.question7 + "," + this.question8 + ","
				+ this.question9 + "," + this.question10 + "," + this.age + "," + this.gender + "," + this.ethnicity
				+ "," + this.jaundice + "," + this.autism + "," + this.countryOfRes + "," + this.usedAppBefore + ","
				+ this.result + "," + this.ageDesc + "," + this.relation + "," + this.asd;
	}

	public AutismAdult negate() {
		return new AutismAdult(negate(this.question1), negate(this.question2), negate(this.question3),
								negate(this.question4), negate(this.question5), negate(this.question6),
								negate(this.question7), negate(this.question8), negate(this.question9),
								negate(this.question10), negate(this.age), negate(this.gender),
								negate(this.ethnicity), negate(this.jaundice), negate(this.autism),
								negate(this.countryOfRes), negate(this.usedAppBefore), negate(this.result),
								negate(this.ageDesc), negate(this.relation),negate(this.asd));
	}

	private int negate(int value) {
		if (value == 0)
			return 1;
		else
			return 0;
	}

	private String negate(String value) {
		if (value.equals("NO"))
			return "YES";
		else if (value.equals("YES"))
			return "NO";
		else if (value.equals("0"))
			return "1";
		else
			return "0";
	}

	public int getQuestion1() {
		return question1;
	}

	public void setQuestion1(int question1) {
		this.question1 = question1;
	}

	public int getQuestion2() {
		return question2;
	}

	public void setQuestion2(int question2) {
		this.question2 = question2;
	}

	public int getQuestion3() {
		return question3;
	}

	public void setQuestion3(int question3) {
		this.question3 = question3;
	}

	public int getQuestion4() {
		return question4;
	}

	public void setQuestion4(int question4) {
		this.question4 = question4;
	}

	public int getQuestion5() {
		return question5;
	}

	public void setQuestion5(int question5) {
		this.question5 = question5;
	}

	public int getQuestion6() {
		return question6;
	}

	public void setQuestion6(int question6) {
		this.question6 = question6;
	}

	public int getQuestion7() {
		return question7;
	}

	public void setQuestion7(int question7) {
		this.question7 = question7;
	}

	public int getQuestion8() {
		return question8;
	}

	public void setQuestion8(int question8) {
		this.question8 = question8;
	}

	public int getQuestion9() {
		return question9;
	}

	public void setQuestion9(int question9) {
		this.question9 = question9;
	}

	public int getQuestion10() {
		return question10;
	}

	public void setQuestion10(int question10) {
		this.question10 = question10;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getJaundice() {
		return jaundice;
	}

	public void setJuandice(String jaundice) {
		this.jaundice = jaundice;
	}

	public String getAutism() {
		return autism;
	}

	public void setAutism(String autism) {
		this.autism = autism;
	}

	public String getCountryOfRes() {
		return countryOfRes;
	}

	public void setCountryOfRes(String countryOfRes) {
		this.countryOfRes = countryOfRes;
	}

	public String getUsedAppBefore() {
		return usedAppBefore;
	}

	public void setUsedAppBefore(String usedAppBefore) {
		this.usedAppBefore = usedAppBefore;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getAgeDesc() {
		return ageDesc;
	}

	public void setAgeDesc(String ageDesc) {
		this.ageDesc = ageDesc;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getAsd() {
		return asd;
	}

	public void setAsd(String asd) {
		this.asd = asd;
	}

}
