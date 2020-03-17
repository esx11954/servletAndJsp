package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProfileBean implements Serializable {

	/*
	 * 名前
	 * */
	private String name;
	
	/*
	 * 年齢
	 * */
	private String age;
	
	/*
	 * 性別
	 * */
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
