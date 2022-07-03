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

WebUI.navigateToUrl(GlobalVariable.base_url)

WebUI.click(findTestObject('Landing Page/buyNowBtn'))

WebUI.maximizeWindow()

WebUI.verifyElementText(findTestObject('Checkout Page/qtyField'), findTestData('checkout_data').getValue(2, 1))

WebUI.verifyElementAttributeValue(findTestObject('Checkout Page/amountField'), 'value', findTestData('checkout_data').getValue(
        3, 1), 0)

WebUI.setText(findTestObject('Checkout Page/nameField'), findTestData('checkout_data').getValue(5, 1))

WebUI.setText(findTestObject('Checkout Page/emailField'), findTestData('checkout_data').getValue(6, 1))

WebUI.setText(findTestObject('Checkout Page/phoneField'), findTestData('checkout_data').getValue(7, 1))

WebUI.setText(findTestObject('Checkout Page/cityField'), findTestData('checkout_data').getValue(8, 1))

WebUI.setText(findTestObject('Checkout Page/addressField'), findTestData('checkout_data').getValue(9, 1))

WebUI.setText(findTestObject('Checkout Page/postalCodeField'), findTestData('checkout_data').getValue(10, 1))

WebUI.click(findTestObject('Checkout Page/checkoutBtn'))

WebUI.switchToFrame(findTestObject('Summary Order/iFrameSummaryOrder'), 30)

WebUI.click(findTestObject('Summary Order/expandSummaryOrder'))

totalAmountText = WebUI.getText(findTestObject('Summary Order/orderData/amountTotalHeader'), FailureHandling.STOP_ON_FAILURE)

orderIdText = WebUI.getText(findTestObject('Summary Order/orderData/orderID'))

WebUI.verifyElementText(findTestObject('Summary Order/orderData/name'), findTestData('checkout_data').getValue(5, 1))

WebUI.verifyElementText(findTestObject('Summary Order/orderData/phone'), findTestData('checkout_data').getValue(7, 1))

WebUI.click(findTestObject('Summary Order/expandSummaryOrder'))

WebUI.click(findTestObject('Summary Order/bankTransferMethod'))

WebUI.click(findTestObject('paymentMethod/bankBCA'))

WebUI.waitForElementClickable(findTestObject('paymentMethod/paidBtn'), 40)

WebUI.click(findTestObject('paymentMethod/paidBtn'))

WebUI.verifyElementText(findTestObject('Status Payment/statusPayment'), findTestData('checkout_data').getValue(11, 1))

actualAmountText = WebUI.getText(findTestObject('Status Payment/amountTotal'))

WebUI.verifyMatch(actualAmountText, totalAmountText, false)

