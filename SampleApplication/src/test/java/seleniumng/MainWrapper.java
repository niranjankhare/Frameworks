package seleniumng;

import static appUnderTest.gui.AUTPageRepository.*;

import appUnderTest.gui.AUTPageRepository;

public class MainWrapper {

	public static void main(String[] args) {
		new AUTPageRepository();
		System.out.println(pageLogin.userName.friendlyName);
		System.out.println(pageLogin.menuConfig.friendlyName);
		System.out.println(pageLogin.menuConfig.locValue);
		System.out.println(pageLogin.selLanguage.friendlyName);
		System.out.println(pageLogin.footerStuff.friendlyName);
		System.out.println(pageDashboard.footerStuff.friendlyName);
		System.out.println(pageLogin.controlAtTheBase.friendlyName);

	}

}
