package tests.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import app.Calculator;
import app.CalculatorService;

public class CalculatorTest {
    Calculator calc;
    CalculatorService service;
    @Before
    public void setUp()
    {
    	//mock() method will create a mock object for calculator service
    	service = Mockito.mock(CalculatorService.class);
    	calc = new Calculator(service);
    }
    
    @Test
    public void testPercentage()
    {
    	int exppercentage = 100;    	
    	//Method stub
    	//When a method x() is called return me result y
    	//This will not call the actual method, but will return a dummy output
    	when(service.multiply(200, 50)).thenReturn(10000);
    	int actpercentage = calc.getPercentage(200, 50);
    	assertEquals(exppercentage, actpercentage);
    }
	
    @Test
	public void testAdd() {		
		int expected = 10;
		
		int actual = calc.add(1,2,3,4);
		assertEquals(expected, actual);
	}

	@Test
	public void testDivide()
	{
		int expected = 10;		
		int actual = calc.divide(20, 2);
		assertEquals(expected, actual);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivideExp()
	{
		calc.divide(20, 0);
	}
	
	@Test()
	public void testDivideExp1()
	{
	   ArithmeticException myexp= 
			  assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
	   assertTrue(myexp.getMessage().equals("/ by zero"));
	}
	
	@Rule
	public ExpectedException myexp = ExpectedException.none();
	@Test
	public void divideExp2()
	{
		myexp.expectMessage("/ by zero");
		myexp.expect(ArithmeticException.class);
		calc.divide(10, 0);
		verify(service).multiply(200, 10);
	}
	
}
