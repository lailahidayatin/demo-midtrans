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

WebUI.click(findTestObject('Shopping Cart/btn_Checkout'))

WebUI.click(findTestObject('methodPayment/btnpaymentCC'))

WebUI.setText(findTestObject('CreditCard/input_CreditCard'), '4811111111111114')

WebUI.setText(findTestObject('CreditCard/input_expiredDate'), '0125')

WebUI.setText(findTestObject('CreditCard/input_cvv'), '123')

WebUI.scrollToElement(findTestObject('Object Repo by Record/demo-midtrans/button_Pay now'), 0)

WebUI.click(findTestObject('Object Repository/Object Repo by Record/demo-midtrans/button_Pay now'))

WebUI.delay(3)

WebUI.setEncryptedText(findTestObject('Object Repo by Record/button-OK-Declined/Page_Sample Store/input_Password_PaRes'), 'J29kuh22Bbk=')

WebUI.click(findTestObject('Object Repo by Record/button-OK-Declined/Page_Sample Store/button_OK'))

WebUI.waitForElementPresent(findTestObject('Object Repo by Record/button-OK-Declined/Page_Sample Store/div_Card declined by bank'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repo by Record/button-OK-Declined/Page_Sample Store/div_Card declined by bank'), 0)

WebUI.click(findTestObject('Object Repo by Record/demo-midtrans/Page_Sample Store/button_OK_Declined'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Object Repo by Record/demo-midtrans/verify-popUpAlertAfterFail'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Object Repo by Record/demo-midtrans/verify-popUpAlertAfterFail'), 
    0)

WebUI.takeScreenshot()

WebUI.closeBrowser()

