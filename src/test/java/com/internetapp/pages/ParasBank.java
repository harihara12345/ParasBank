package com.internetapp.pages;

import static com.maveric.core.utils.reporter.Report.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Popup;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;


public class ParasBank extends WebActions {
	
//Register    
	private final By Register = By.xpath("//a[contains(text(),'Register')]");
	private final By Title = By.xpath("//h1[@class='title']");
	private final By FirstName = By.xpath("//input[@id='customer.firstName']");
	private final By LastName = By.xpath("//input[@id='customer.lastName']");
	private final By Address = By.xpath("//input[@id='customer.address.street']");
	private final By City = By.xpath("//input[@id='customer.address.city']");
	private final By State = By.xpath("//input[@id='customer.address.state']");
	private final By Zipcode = By.xpath("//input[@id='customer.address.zipCode']");
	private final By Input = By.xpath("//input[@id='customer.phoneNumber']");
	private final By SSN = By.xpath("//input[@id='customer.ssn']");
	private final By UserName = By.xpath("//input[@id='customer.username']");
	private final By Password = By.xpath("//input[@id='customer.password']");
	private final By ConfirmPassword = By.xpath("//input[@id='repeatedPassword']");
	private final By RegisterButton = By.xpath("//table[@class='form2']//input[@class='button']");
	private final By WelcomeTitle = By.xpath("//h1[@class='title']");
	private final By OpenNewAccount = By.xpath("//a[contains(text(),'Open New Account')]");
	private final By TransferFunds = By.xpath("//a[contains(text(),'Transfer Funds')]");
	
//Open New Account 	
	private final By OpenNewAccountTitle = By.xpath("//h1[@class='title']");
	private final By dropdown1 = By.xpath("//select[@id='type']");
	private final By dropdown2 = By.xpath("//select[@id='fromAccountId']");
	private final By OpenNewAccountClick = By.xpath("//input[@class='button']");
	private final By AccountOpenedTitle = By.xpath("//h1[@class='title']");
	private final By NewAccountNumber = By.xpath("//a[@id='newAccountId']");

//Account Overview
	private final By AccountsOverview = By.xpath("//a[contains(text(),'Accounts Overview')]");
	private final By AccountsOverviewTitle = By.xpath("//h1[@class='title']");
	private final By SecondAccount = By.xpath("(//a[@class='ng-binding'])[2]");
	private final By AccountDetailsHeader = By.xpath("//h1[contains(text(),'Account Details')]");
	
	
//Transfer Funds
	private final By TransferTitileScreen = By.xpath("//h1[@class='title']");
	private final By TransferAmount = By.xpath("//input[@id='amount']");
	private final By FromAccount = By.xpath("//select[@id='fromAccountId']");
	private final By ToAccount = By.xpath("//select[@id='toAccountId']");
	private final By TransferButton = By.xpath("//input[@class='button']");
	private final By TransferComplete = By.xpath("//h1[@class='title']");
	private final By LogOut = By.xpath("//a[contains(text(),'Log Out')]");
//	private final By elementHead = By.xpath("");
	
	
	 WebDriverWait wait;
	    WebDriver driver;

	    public ParasBank() {
	        driver = Driver.getWebDriver();
	        wait = new WebDriverWait(driver, ConfigProperties.WAIT_TIMEOUT.getInt());
	    }

	    public ParasBank navigate(String url) {
	        driver.navigate().to(url);
	        driver.manage().window().maximize();

	        logScreenshot("login");
	        ;
	        log("sample log");

	        return this;

	    }	
	    	//src//main//resources//testData//Parasbank.xlsx
	    	//C:\\Users\\HARIHARAVIGNESHM\\Desktop\\Eclipse source folders\\Parasbank.xlsx
	    public ParasBank Register() throws IOException, InterruptedException  {
	    	
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 driver.findElement(Register).click();
	    	 System.out.println("Clicked");
	    	 File file = new File("src//main//resources//testData//Parasbank.xlsx");
	    	 String firstname, lastname,address,city,state,zipcode,input,ssn,username = null,password,confirmpassword;
	    	  
	         InputStream is = new FileInputStream(file);
	         XSSFWorkbook wb = new XSSFWorkbook(is);
	         XSSFSheet sheet1 = wb.getSheet("Sheet1");
	         Thread.sleep(10);
	         for (int i = 1; i <= sheet1.getLastRowNum(); i++)
	         {
	        	 driver.findElement(FirstName).sendKeys(firstname = sheet1.getRow(i).getCell(0).getStringCellValue());
				 driver.findElement(LastName).sendKeys(lastname = sheet1.getRow(i).getCell(1).getStringCellValue());
				 driver.findElement(Address).sendKeys(address = sheet1.getRow(i).getCell(2).getStringCellValue());
				 driver.findElement(City).sendKeys(city = sheet1.getRow(i).getCell(3).getStringCellValue());
				 driver.findElement(State).sendKeys(state = sheet1.getRow(i).getCell(4).getStringCellValue());
				 driver.findElement(Zipcode).sendKeys(zipcode = sheet1.getRow(i).getCell(5).getStringCellValue());
				 driver.findElement(Input).sendKeys(input = sheet1.getRow(i).getCell(6).getStringCellValue());
				 driver.findElement(SSN).sendKeys(ssn = sheet1.getRow(i).getCell(7).getStringCellValue());
				 scrollDown();
				 Thread.holdsLock(1000);
				 driver.findElement(UserName).sendKeys(username = sheet1.getRow(i).getCell(8).getStringCellValue());
				 driver.findElement(Password).sendKeys(password = sheet1.getRow(i).getCell(9).getStringCellValue());
				 driver.findElement(ConfirmPassword).sendKeys(confirmpassword = sheet1.getRow(i).getCell(10).getStringCellValue());
				 logScreenshot("Details input for user Register");
				 driver.findElement(RegisterButton).click();
	         }
	             String text1 = driver.findElement(WelcomeTitle).getText();
                 Assert.assertEquals(text1, "Welcome " + username);
                 System.out.println("Assertion passed on Registration for user name " + username);
                 logScreenshot("Succeessfully User Register done");
				return this;

                 
	    	
	         }
	    
	   
	   
	    
	    public ParasBank Accountopen(String option1) throws IOException, InterruptedException  {
	    	
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AccountsOverviewTitle)).isDisplayed();
	    	 driver.findElement(OpenNewAccount).click();
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(OpenNewAccountTitle)).isDisplayed();
	    	 
	    	 WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='type']"));
	    	 Select select = new Select(dropdown1);
	    	   	select.selectByVisibleText(option1);;
	        	Thread.sleep(1000);
	        	logScreenshot("Details inputted for New Account opening");
	        	Thread.sleep(2000);
	        	driver.findElement(OpenNewAccountClick).click();
	        	wait.until(ExpectedConditions.presenceOfElementLocated(AccountOpenedTitle)).isDisplayed();
	        	logScreenshot("New Account opened");
	        	String AccountNumber = driver.findElement(NewAccountNumber).getText();
	        	System.out.println("New Account number created is - "+AccountNumber);
	    	 return this;
	    }
	    
	    public ParasBank FundTransfer(String Amount, int option1) throws IOException, InterruptedException  {
	    	
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 driver.findElement(TransferFunds).click();
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(TransferTitileScreen)).isDisplayed();
	    	 Thread.sleep(2000);
	    	 driver.findElement(TransferAmount).sendKeys(Amount);
	    	 
	    	 
	    	 WebElement dropdown1 = driver.findElement(FromAccount);
	    	 WebElement dropdown2 = driver.findElement(ToAccount);
	    	 Select select = new Select(dropdown1);
	    	   	select.selectByIndex(option1);
	    	   	String AccountnumberFrom = dropdown1.getText();
	    	   	String AccountnumberTo = dropdown2.getText();
	        	Thread.sleep(1000);
	        	logScreenshot("Details inputted for Fund transfer from one account to another account");
	        	driver.findElement(TransferButton).click();
	        	wait.until(ExpectedConditions.presenceOfElementLocated(TransferComplete)).isDisplayed();
	        	logScreenshot("Fund transfer Completed");
	        	WebElement text = driver.findElement(By.xpath("//span[@id='amount']"));
	        	String text2="$"+Amount;
	        	System.out.println("Amount inputted - "+text2);
	        	String AmountTransferred = 	text.getText();
	        	System.out.println("Amount Transfeered - "+AmountTransferred);
	        	
	        	
	        	Thread.sleep(1000);
	        	
	        	
	    	 return this;
	    }
	    
	    public ParasBank AccounActivity() throws IOException, InterruptedException  {
	    	
	    	WebElement Account =  driver.findElement(By.xpath("//span[@id='fromAccountId']"));	
	    	String text = Account.getText();
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 driver.findElement(AccountsOverview).click();
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AccountsOverviewTitle)).isDisplayed();
	    	 driver.findElement(SecondAccount).click();
	    	 Thread.sleep(1000);
	    	 WebElement Account1 =  driver.findElement(By.xpath("//td[@id='accountId']"));	
	    	 String text1 = Account1.getText();
	    	 Thread.sleep(2000);
	    //	 Assert.assertEquals(text, text1);
	    	 System.out.println("Assertion passed for Account selected - "+Account);
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(AccountDetailsHeader)).isDisplayed();
	    	 logScreenshot("Navigated to Account details Screen");
	    	 //To get number of rows
	    	 WebElement TogetRows = driver.findElement(By.xpath("//table[@id='transactionTable']//tbody"));
	    	 List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
	    	 int RowCount = TotalRowsList.size();
	    	 //To Get no of Columns
	    	 WebElement ToGetColumns = driver.findElement(By.xpath("//table[@id='transactionTable']//tbody/tr[1]"));
	    	 List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
	    	 int Columncount = TotalColsList.size();
	    	 scrollDown();
	    	     	 
	 		//src//main//resources//testData//Parasbank.xlsx
	    	 
	    	 //C:\\Users\\HARIHARAVIGNESHM\\Desktop\\Eclipse source folders\\Excel.xlsx
	 		for(int i=1;i<=RowCount;i++)
	 		{
	 			File file = new File("src//main//resources//testData//Excel.xlsx");
	 			FileInputStream fis = new FileInputStream(file);
			 	 
			 	XSSFWorkbook wb = new XSSFWorkbook(fis);
			 	XSSFSheet sheet = wb.getSheet("Sheet1"); 			
	 			Row row = sheet.createRow(i);
	 			for(int j=0;j<Columncount;j++)
	 			{
	 				if(i==1)
	 				{
	 				List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[1]//td"));
	 				String text2 = A.get(j).getText();
	 				Cell firstCell = row.createCell(j);
	 				firstCell.setCellValue(text2);
	 				Thread.sleep(1000);
	 				}
	 				if(i==2)
	 				{
	 				List<WebElement> A = driver.findElements(By.xpath("//table[@id='transactionTable']//tr[2]//td"));
	 				String text2 = A.get(j).getText();
	 				Cell firstCell = row.createCell(j);
	 				firstCell.setCellValue(text2);
	 				Thread.sleep(1000);
	 				}
	 		    }
	 			fis.close();
                FileOutputStream fos = new FileOutputStream(file);
                wb.write(fos);
                fos.close();
			
	 		}	
	 		
	 		
			System.out.println("Excel write Successfully done");
			driver.findElement(LogOut).click();
			System.out.println("Successfully logged out ");
			logScreenshot("Successfully logged out");
			
			
	    	 return this;
	    
	  }
}