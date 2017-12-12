class Person{
	def name 
	def lastName
	def age
	def role
	def ageGroup

	def toPrint() { "${name} ${lastName} ${age} ${role} ${ageGroup}" }
}


def listOfPersons = []

List<Person> list = new ArrayList<Person>();

def startTime = System.currentTimeMillis()

println "Loading objects..."

for (i = 0; i <5000000; i++) {
   list.add(new Person(name:'Lindsey', lastName:'Stirling', age:Math.abs(new Random().nextInt() % 100) + 1, role:"Violinist/Performer", ageGroup:""))
}

def endTime = System.currentTimeMillis() - startTime

println "It took " + endTime + " currentTimeMillis to load object"

def totalStartTime = startTime

startTime = System.currentTimeMillis()

println "Sorting...."

def sortedList = listOfPersons.sort{it.age}

endTime = System.currentTimeMillis() - startTime

println "It took "+ endTime + " milliseconds to sort"

startTime = System.currentTimeMillis()

println "Assigmning..."

sortedList.each{
	if(it.age < 18){
		it.ageGroup = "Child"
	}else if(it.age < 55){
		it.ageGroup = "Adult"
	}else{
		it.ageGroup = "Senior"
	}	
}

endTime = System.currentTimeMillis() -startTime

println "It took " + endTime + " milliseconds to assing"

println "Writing to a file"
def file = new File('C:/Users/Jeffrey Cuadros/workspace/CSC450 Research/groovyOutput.txt')

startTime = System.currentTimeMillis()

sortedList.each{
	file << (it.toPrint() + "\r")	
}

def totalEndTime = System.currentTimeMillis()

endTime = totalEndTime - startTime

println "End of writing, took " + endTime + " milliseconds"


println "\t\t\t Everything took " + totalEndTime + " milliseconds"


file.delete()

