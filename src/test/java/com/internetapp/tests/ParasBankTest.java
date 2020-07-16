package com.internetapp.tests;

import com.internetapp.pages.ParasBank;
import com.internetapp.pages.a_ElementsPage;
import com.maveric.core.testng.BaseTest;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ParasBankTest extends BaseTest{
	
	@Test(groups = {"web"})
	public void Test2() throws InterruptedException, IOException {

        new ParasBank()
              .navigate("https://parabank.parasoft.com/parabank/register.htm")
              .Register()
              .Accountopen("SAVINGS")
              .FundTransfer("10.00", 1)
              .AccounActivity()
              
              ;
        
        

}

}
