package pageEvents;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import pageElements.newCompanyDetailspageElements;
import utills.constants;
import utills.elementFetch;
import utills.excelutills;

public class newCompanyDetailsPageEvents {
	
	elementFetch ele = new elementFetch();
	
	public String newCompanyDetails()
	{
		return ele.getWebElement("XPATH", newCompanyDetailspageElements.companyName).getText();
		
	}
	
//	public String validateCompanyName() throws Throwable
//	{
//		System.out.println(newCompanyDetailspageElements.companyName);
//		int rc = excelutills.getrowcount(constants.excelPath, "NewCompanyDetails");
//	    int cc = excelutills.getcellcount(constants.excelPath, "NewCompanyDetails", 1);
//	    Object[][] newCompaniesDetails = new Object[rc][cc];
//		for(int i=1;i<=rc;i++)
//		{
//			for(int j=0;j<cc;j++)
//	    	{
//	    		newCompaniesDetails[i-1][j] = excelutills.getDataFromExcel(constants.excelPath, "NewCompanyDetails", i, j);
//	    		String companyNameInCell = newCompaniesDetails[i - 1][j].toString();
//	    		return companyNameInCell;
//	    	}
//		}
		
		public String validateCompanyNames() throws Throwable {
			int rc = excelutills.getrowcount(constants.excelPath, "NewCompanyDetails");
			String nameofcompany = null;
			for (int i = 1; i <= rc; i++) {
				String companyNames = excelutills.getDataFromExcel(constants.excelPath, "NewCompanyDetails", i, 0);
				System.out.println("company name is: "+companyNames);
				 nameofcompany = companyNames;
			}
			return nameofcompany;
		}

		
}
