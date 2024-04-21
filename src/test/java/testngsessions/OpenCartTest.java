package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTest {
	
	//before annotations:
	@BeforeSuite // run once
	public void dbConnection() {
		System.out.println("BS-- DB Connections");
	}
	
	@BeforeTest // run once
	public void createUser() {
		System.out.println("BT -- Create Use");
	}
	
	@BeforeClass // run once
	public void launchBrowser() {
		System.out.println("Bc -- Launch Browser");
	}
	
	@BeforeMethod // it will run before each test
	public void login() {
		System.out.println("BM -- login");
	}
	
	// test annotations - test will run alphabetically
	@Test
	public void titleTest(){
		System.out.println("Title test");
	}
	
	@Test
	public void headerTest(){
		System.out.println("Header test");
	}
	@Test
	public void urlTest(){
		System.out.println("URL test");
	}
	
	//After annotations
	@AfterMethod // run after each test
	public void logout() {
		System.out.println("AM -- logout");
	}
	@AfterClass // run once
	public void closeBrowser() {
		System.out.println("AC -- close Browser");
	}
	@AfterTest // run once
	public void deleteUser() {
		System.out.println("AT -- Delete Use");
	}
	@AfterSuite // run once
	public void disconnectDB() {
		System.out.println("aS-- removeDB Connections");
	}
}