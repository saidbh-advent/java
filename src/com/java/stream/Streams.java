package com.java.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Streams {
	
	// A stream in java is not a  data structure
	// it does not store data and does not modify the underlying 
	//data
	
	// available through java.util.stream
	//supports functional-style operations on streams of 
	//data such as map-reduce
	
	
	private static Employee[] employees = {
			new Employee(1, "Jeff Bezos", 100000.0), 
		    new Employee(2, "Bill Gates", 200000.0), 
		    new Employee(3, "Mark Zuckerberg", 300000.0)
	};
	
	public static void main(String[] args) {
		
		// getting stream out of the employees array
		Stream.of(employees);
		

		 
		 
		 // Stream builder
		 Stream.Builder<Employee> streamBuilder = Stream.builder();
		 streamBuilder.accept(employees[0]);
		 streamBuilder.accept(employees[1]);
		 streamBuilder.accept(employees[2]);
		 Stream<Employee> theStream = streamBuilder.build();

	}
	
	
	@Test
	public void applyPayRaiseUsingForEach() {
		/// get stream from a list
		// apply for each emplyee the pay raise
		// test the salaries
		 List<Employee> listEmp = Arrays.asList(employees);
		 listEmp.stream().forEach(e -> e.incrementSalary(10000));
		 
		 assertEquals(employees[0].getSalary(), 110000.0, 0);
		 assertEquals(employees[1].getSalary(), 210000.0, 0);
		 assertEquals(employees[2].getSalary(), 310000.0, 0);

	}
	
	@Test
	public void buildStreamFromIdsArrayUsingMapAndCollect() {
		
	    Integer[] empIds = { 1, 2, 3 };

	    List<Employee> res = Stream.of(empIds).map(Streams :: getEmployee)
	    				 .collect(Collectors.toList());
	    assertEquals(Arrays.asList(employees).size(), res.size());
	    
	    for(Employee e : res) {
	    	System.out.println(e.toString());
	    }
	}
	
	
	private static  Employee getEmployee(int id) {
		for(Employee e :  employees) 
			if(e.getId() == id) {
				return e;
			}
		
		return null;
	}

}
