package com.jcuadros.data.manipulation;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
public class DataTest {
	private List<Person> list;
	private final Random random;
	public DataTest(){
		list = new ArrayList<Person>();
		random = new Random();
		for(int i =0; i < 10000000; i++){
			list.add(new Person());
		}
		Iterator<Person> ito = list.iterator();
		while (ito.hasNext()) {
			Person p = ito.next();
			if(random.nextBoolean()) p.setName("Christina");
			if(random.nextBoolean()) p.setLastName("Grimmie");
			if(random.nextBoolean()) p.setAge(random.nextInt(100) + 1);
			if(random.nextBoolean()) p.setRole("Singer");
			if(random.nextBoolean()) p.setName("Lindsey");
			if(random.nextBoolean()) p.setLastName("Stirling");
			if(random.nextBoolean()) p.setAge(random.nextInt(100) + 1);
			if(random.nextBoolean()) p.setRole("Violinist/Performer");
			ito.next();
		}
	}
	public List<Person> getList(){
		return list;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long mainStartTime = start;
		System.out.println("Start Loading population");
		DataTest dt =  new DataTest();
		long end = System.currentTimeMillis() - start;
		System.out.println("It took " + end + " milliseconds to load population");
		start = System.currentTimeMillis();
		System.out.println("Start Sorting by age");
		Collections.sort(dt.getList(), new Comparator<Person>(){
		     public int compare(Person p1, Person p2){
		         if(p1.getAge() == p2.getAge())
		             return 0;
		         return p1.getAge() < p2.getAge() ? -1 : 1;
		     }
		});
		end = System.currentTimeMillis() - start;
		System.out.println("It took " + end + " milliseconds to sort by age");
		System.out.println("Assingment age group");
		start = System.currentTimeMillis();
		for(Person p : dt.getList()){
			if (p.getAge() < 18){
				p.setAgeGroup("Child");
			}else if(p.getAge() < 55){
				p.setAgeGroup("Adult");
			}else{
				p.setAgeGroup("Senior");
			}
		}
		end = System.currentTimeMillis() - start;
		System.out.println("It took " + end + " milliseconds to assign age group");
		System.out.println("Writing of a file");
		start = System.currentTimeMillis();
		Path p = Paths.get("C:/Users/Jeffrey Cuadros/workspace/CSC450 Research/output.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(p)) {
			for(Person person : dt.getList())
				writer.write(person.toString());
		} catch (Exception e) {
			System.out.println("An exception has occured: ");
			e.printStackTrace();
		}
		long mainEndTime = System.currentTimeMillis();
		end = mainEndTime - start;
		System.out.println("It took " + end + " milliseconds to write to a file");
		System.out.println("\t\t\t All the processes took: " + (mainEndTime - mainStartTime) + " milliseconds"); 
		File f = new File("C:/Users/Jeffrey Cuadros/workspace/CSC450 Research/output.txt");
		f.delete();
	}
}