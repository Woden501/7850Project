package com.woden501.project.models;

public class Adult {
	private int age;
	private String workclass;
	private int fnlwgt;
	private String education;
	private int educationNum;
	private String maritalStatus;
	private String occupation;
	private String relationship;
	private String race;
	private String sex;
	private int capitalGain;
	private int capitalLoss;
	private int hoursPerWeek;
	private String nativeCountry;
	private String salary;

	public Adult(String age, String workclass, String fnlwgt, String education, String educationNum,
			String maritalStatus, String occupation, String relationship, String race, String sex, String capitalGain,
			String capitalLoss, String hoursPerWeek, String nativeCountry, String salary) {
		super();
		this.age = Integer.parseInt(age);
		this.workclass = workclass;
		this.fnlwgt = Integer.parseInt(fnlwgt);
		this.education = education;
		this.educationNum = Integer.parseInt(educationNum);
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.relationship = relationship;
		this.race = race;
		this.sex = sex;
		this.capitalGain = Integer.parseInt(capitalGain);
		this.capitalLoss = Integer.parseInt(capitalLoss);
		this.hoursPerWeek = Integer.parseInt(hoursPerWeek);
		this.nativeCountry = nativeCountry;
		this.salary = salary;
	}

	public Adult(int age, String workclass, int fnlwgt, String education, int educationNum, String maritalStatus,
			String occupation, String relationship, String race, String sex, int capitalGain, int capitalLoss,
			int hoursPerWeek, String nativeCountry, String salary) {
		super();
		this.age = age;
		this.workclass = workclass;
		this.fnlwgt = fnlwgt;
		this.education = education;
		this.educationNum = educationNum;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.relationship = relationship;
		this.race = race;
		this.sex = sex;
		this.capitalGain = capitalGain;
		this.capitalLoss = capitalLoss;
		this.hoursPerWeek = hoursPerWeek;
		this.nativeCountry = nativeCountry;
		this.salary = salary;
	}

	public Adult(Adult adult) {
		super();
		this.age = adult.age;
		this.workclass = adult.workclass;
		this.fnlwgt = adult.fnlwgt;
		this.education = adult.education;
		this.educationNum = adult.educationNum;
		this.maritalStatus = adult.maritalStatus;
		this.occupation = adult.occupation;
		this.relationship = adult.relationship;
		this.race = adult.race;
		this.sex = adult.sex;
		this.capitalGain = adult.capitalGain;
		this.capitalLoss = adult.capitalLoss;
		this.hoursPerWeek = adult.hoursPerWeek;
		this.nativeCountry = adult.nativeCountry;
		this.salary = adult.salary;
	}

	@Override
	public String toString() {
		return this.age + "," + this.workclass + "," + this.fnlwgt + "," + this.education + "," + this.educationNum + "," + this.maritalStatus + ","
				+ this.occupation + "," + this.relationship + "," + this.race + "," + this.sex + "," + this.capitalGain + "," + this.capitalLoss + ","
				+ this.hoursPerWeek + "," + this.nativeCountry + "," + this.salary;
	}

	public Adult negate() {
		return new Adult(negate(this.age), negate(this.workclass), negate(this.fnlwgt), negate(this.education),
				negate(this.educationNum), negate(this.maritalStatus), negate(this.occupation),
				negate(this.relationship), negate(this.race), negate(this.sex), negate(this.capitalGain),
				negate(this.capitalLoss), negate(this.hoursPerWeek), negate(this.nativeCountry), negate(this.salary));
	}

	private int negate(int value) {
		if (value == 0)
			return 1;
		else
			return 0;
	}

	private String negate(String value) {
		if (value.equals("<=50K"))
			return ">50K";
		else if (value.equals(">50K"))
			return "<=50K";
		else if (value.equals("0"))
			return "1";
		else
			return "0";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWorkclass() {
		return workclass;
	}

	public void setWorkclass(String workclass) {
		this.workclass = workclass;
	}

	public int getFnlwgt() {
		return fnlwgt;
	}

	public void setFnlwgt(int fnlwgt) {
		this.fnlwgt = fnlwgt;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getEducationNum() {
		return educationNum;
	}

	public void setEducationNum(int educationNum) {
		this.educationNum = educationNum;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getCapitalGain() {
		return capitalGain;
	}

	public void setCapitalGain(int capitalGain) {
		this.capitalGain = capitalGain;
	}

	public int getCapitalLoss() {
		return capitalLoss;
	}

	public void setCapitalLoss(int capitalLoss) {
		this.capitalLoss = capitalLoss;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getNativeCountry() {
		return nativeCountry;
	}

	public void setNativeCountry(String nativeCountry) {
		this.nativeCountry = nativeCountry;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
}
