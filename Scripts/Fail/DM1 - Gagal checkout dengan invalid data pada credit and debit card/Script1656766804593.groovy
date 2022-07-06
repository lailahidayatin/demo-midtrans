import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://demo.midtrans.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Home Page/btnBuyNow'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('Shopping Cart/shoppingCartForm'), 5)

WebUI.verifyElementPresent(findTestObject('Shopping Cart/shoppingCartForm'), 0)

WebUI.click(findTestObject('Object Repository/Shopping Cart/btn_Checkout'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('Shopping Cart/verify_priceTag'), 5)

WebUI.verifyElementPresent(findTestObject('Shopping Cart/verify_priceTag'), 0)

WebUI.click(findTestObject('Object Repository/methodPayment/btnpaymentCC'))

WebUI.setText(findTestObject('Object Repository/CreditCard/input_CreditCard'), '4911 1111 1111 1114')

WebUI.setText(findTestObject('Object Repository/CreditCard/input_expiredDate'), '0125')

WebUI.setText(findTestObject('Object Repository/CreditCard/input_cvv'), '123')

WebUI.verifyElementText(findTestObject('Object Repository/CreditCard/verify_numberCreditCard'), 'Make sure your card number are correct.')

