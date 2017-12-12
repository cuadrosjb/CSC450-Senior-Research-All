package com.jcuadros.data.manipulation;
public class Person {
	private String name;
	private String lastName;
	private int age;
	private String role;
	private String ageGroup;
	public Person(){
		this.name = "Jill";
		this.lastName ="Smith";
		this.age = 30;
		this.role = "Adult";
		this.setAgeGroup("unassigned");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", age=" + age + ", role=" + role + ", ageGroup="
				+ ageGroup + "]\r";
	}
}