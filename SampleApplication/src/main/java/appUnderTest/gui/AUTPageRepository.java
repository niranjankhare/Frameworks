package appUnderTest.gui;

import org.seleniumng.utils.PageObjectRepository;

import appUnderTest.gui.pageObjects.PageDashboard;
import appUnderTest.gui.pageObjects.PageLogin;

public class AUTPageRepository extends PageObjectRepository {
	/**
	 * From the app.gui.pageObjectsPackage
	 * include one static public field for each of hte page classes.
	 */
	public static  PageLogin pageLogin;
	public static  PageDashboard pageDashboard;
}
