package com.jcuadros.prj
class Person {
	var name : String = "Lindsey"
	var lastName : String = "Stirling" 
	var age : Int = 10
	var role : String = "Violinist"
	var ageGroup : String = "Adult"
	override def toString = {
	  "Person name: " + name + " lastName: " + lastName  + " age: " + age + " role: " +role + " ageGroup: "  + ageGroup 
	}
}