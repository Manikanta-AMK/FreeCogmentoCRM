package pageEvents;

import pageElements.newCompanyDetailspageElements;
import utills.elementFetch;

public class newCompanyDetailsPageEvents {
	
	elementFetch ele = new elementFetch();
	
	public String newCompanyDetails()
	{
		return ele.getWebElement("XPATH", newCompanyDetailspageElements.companyName).getText();
		
	}
}
