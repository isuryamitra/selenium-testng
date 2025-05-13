package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestFile {
	@Test
	public void method1()
	{
		System.out.println("Test 1 printed in File 1");
		
	}

	
	@BeforeSuite
	public void method2()
	{
		Assert.assertEquals(true, false);
		System.out.println("Before Suite printed on File 1");
		
	}

	
	@BeforeTest
	public void method7()
	{
		System.out.println("Before Test printed in file 1");
		
	}
	
	@AfterTest()
	
	public void method12()
	{
		System.out.println("After Test printed in file 1");
		
	}
	
	
	


}
