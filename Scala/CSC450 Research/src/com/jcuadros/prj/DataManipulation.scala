package com.jcuadros.prj
import java.util.Comparator
import scala.reflect.internal.util.Collections
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import java.io._
object DataManipulation {
  val list = new ArrayBuffer[Person]
	val random = new Random()
	def init(){
		for(i <- 1 to 10000000){
			list+=(new Person())
		}
	}
	def getList =	list
	def main(args: Array[String]) {
	  var start = System.currentTimeMillis()
	  println("Start Loading population");
	  var listy = DataManipulation
		listy.init()
		var end = System.currentTimeMillis() - start
		println("It took " + end + " milliseconds to load population")
	  var mainStartTime = start		
	  println("Sorting...")
	  start = System.currentTimeMillis()
		var sortedLis = listy.list.sortWith(_.age < _.age)
		end = System.currentTimeMillis() - start
	  println("It took " + end + " milliseconds to sort population")
	  println("Assign age group")
	  start = System.currentTimeMillis()
		for(p <- sortedLis){
		  if(p.age < 18){
		    p.ageGroup = "Child"
		  }else if(p.age < 55){
		    p.ageGroup = "Adult"
		  }else{
		    p.ageGroup = "Senior"
		  }
		}
	  end = System.currentTimeMillis() - start
	  println("It took " + end + " milliseconds to assign age group")
    println("Printing... to file")
	  start = System.currentTimeMillis()
	  val pw = new PrintWriter(new File("C:/Users/Jeffrey Cuadros/workspace/CSC450 Research/scalaOutput.txt" ))
	  for(p <- sortedLis)
		  pw.write(p.toString())
    pw.close
    val mainEndTime = System.currentTimeMillis()
    end = mainEndTime - start
    println("It took " + end + " milliseconds to save to file")
    new File("C:/Users/Jeffrey Cuadros/workspace/CSC450 Research/scalaOutput.txt").delete()
    println("\t\t\tAll the process took " + (mainEndTime-mainStartTime) + " milliseconds")
	}
}