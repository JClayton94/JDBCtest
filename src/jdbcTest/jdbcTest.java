package jdbcTest;

import static org.junit.Assert.*;

import org.junit.Test;

import jdbc.dbMethods;

public class jdbcTest {

	@Test
	public void testReadFromDB() {

		dbMethods test = new dbMethods();
		
		test.accessDB();
		assertNotNull(test.readFromDB("*", "actor"));
		test.readFromDB("*", "actor").stream().forEach(x -> System.out.println(x.getfName() + " " + x.getlName() + "\n")); 
	
	}
	@Test
	public void testSQLToDB() {
		
		dbMethods test = new dbMethods();
		
		test.accessDB();
		//Values below already inserted
		//test.insertIntoDB("insert into actor (first_name, last_name) values ('Bob', 'Dole')");
		
		assertEquals("Not correct name", "Bob Dole", test.readFromDB("*", "actor where first_name = 'Bob' and last_name = 'Dole'").get(0).getFullName());
		
		
	} 

}
 