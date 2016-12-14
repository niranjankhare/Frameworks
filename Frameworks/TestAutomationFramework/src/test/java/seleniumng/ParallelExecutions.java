package seleniumng;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import static java.nio.charset.StandardCharsets.*;
import org.seleniumng.driver.DriverInventory;
import org.testng.annotations.Test;

public class ParallelExecutions {
	
	
	@Test
	public void testCaseOne() throws UnsupportedEncodingException {
		//Printing Id of the thread on using which test method got executed
		DriverInventory.getDriver("testCaseOne");
	

	    System.out.println("Done");

	}

	@Test
	public void testCaseTwo() {
		////Printing Id of the thread on using which test method got executed
		DriverInventory.getDriver("testCaseTwo");
	}
	
	@Test
	public void testCaseThree() {
		////Printing Id of the thread on using which test method got executed
		DriverInventory.getDriver("testCaseThree");
	}
	
	@Test
	public void testCaseFour() {
		////Printing Id of the thread on using which test method got executed
		DriverInventory.getDriver("testCaseFour");
	}

}
