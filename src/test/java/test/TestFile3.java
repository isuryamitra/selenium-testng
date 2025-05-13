package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestFile3 {
	
	@DataProvider (name="abcd")
	public Object[] a()
	{
		return new Object[] {3,5};
	}
	
	@Test(dataProvider="abcd")
	public void myTest(int a)
	{
		System.out.println(a);
	}

}
