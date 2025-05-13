package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestFile2 {
	
	
	
	@Test
	public void method4()
	{
		System.out.println("Test Method 2 printed in file 2");
		
	}
	
	@BeforeSuite
	public void beforeSuiteFile2()
	{
		System.out.println("Before suite printed in file 2");
		Assert.assertEquals(true, false);
		
	}
	
	@BeforeTest
	
	public void beforeTest()
	{
		System.out.println("Before Test printed in file 2");
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class printed in file 2");
		
	}
	
	
	
	

}
