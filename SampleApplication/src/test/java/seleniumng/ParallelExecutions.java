package seleniumng;

import java.io.UnsupportedEncodingException;

//import org.seleniumng.driver.DriverInventory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ParallelExecutions {
	
	
	@Test
	public void testCaseOne() throws UnsupportedEncodingException {
		//Printing Id of the thread on using which test method got executed
//		DriverInventory.getDriver("testCaseOne");
	
//		String val = System.getProperties()("integration.url");
//		System.setProperty("integration.url", "http://loclahost");
	    System.out.println("Done:"+ System.getProperty("niru.khare"));

	}

	@Test
	public void testCaseTwo() {
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(0L, 1L, "assert long 1 = 2");
		softAssert.assertEquals(0, 1, "assert int 1 = 2");
		softAssert.assertEquals("aniru", "aniru", "assert string pass");
		softAssert.assertAll();
		
		////Printing Id of the thread on using which test method got executed
//		DriverInventory.getDriver("testCaseTwo");
	}
	
	@Test
	public void testCaseThree() {
		////Printing Id of the thread on using which test method got executed
//		DriverInventory.getDriver("testCaseThree");
	}
	
	@Test
	public void testCaseFour() {
		////Printing Id of the thread on using which test method got executed
//		DriverInventory.getDriver("testCaseFour");
	}

}
