package tests.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Student;

public class StudentTest {

	@Test
	public void test() {
		Student s1 = new Student(70);
		String expgrade ="B";
		assertEquals(expgrade, s1.printGrade());
	}

}
