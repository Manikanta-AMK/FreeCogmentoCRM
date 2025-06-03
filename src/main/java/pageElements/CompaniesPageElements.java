package pageElements;

public interface CompaniesPageElements {

	String  companieslink = "//div[@class=\"ui header item mb5 light-black\"]//span";
	String createBtn = "(//button[@class='ui linkedin button'])[3]";
	String CreatenewCompany  ="//div[@class=\"ui header item mb5 light-black\"]//span";
	String nameTxtBx = "name";
	String websiteTxtBx =  "//input[ @name='url' and contains(@type,'text')]";
	String cityTxtBx = "city";
	String phoneNumberTxtBx ="//input[@placeholder='Number']";
	String industryTxtBx = "(//input[@autocomplete='new-password'])[3]";
	String numberOfEmployeeTxtBx = "//input[@autocomplete='new-password' and @name='num_employees']";
	String saveBtn = "//button[@class='ui linkedin button']";
	
}
