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
import java.lang.Integer as Integer

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.base_url)

WebUI.maximizeWindow()

priceTag = WebUI.getText(findTestObject('Landing Page/priceTag')).replace('Rp.', '').replace(',', '')

WebUI.verifyMatch(priceTag, findTestData('checkout_data').getValue(3, 1), false)

WebUI.click(findTestObject('Landing Page/buyNowBtn'))

qtyField = WebUI.getText(findTestObject('Checkout Page/qtyField')).replace('×', '').replace(' ', '')

WebUI.verifyMatch(qtyField, findTestData('checkout_data').getValue(2, 1), false)

WebUI.verifyElementAttributeValue(findTestObject('Checkout Page/amountField'), 'value', findTestData('checkout_data').getValue(
        3, 1), 0)

totalAmountField = WebUI.getText(findTestObject('Checkout Page/totalAmountField')).replace(',', '')

WebUI.verifyMatch(totalAmountField, findTestData('checkout_data').getValue(4, 1), false)

WebUI.setText(findTestObject('Checkout Page/nameField'), findTestData('checkout_data').getValue(5, 1))

WebUI.setText(findTestObject('Checkout Page/emailField'), findTestData('checkout_data').getValue(6, 1))

WebUI.setText(findTestObject('Checkout Page/phoneField'), findTestData('checkout_data').getValue(7, 1))

WebUI.setText(findTestObject('Checkout Page/cityField'), findTestData('checkout_data').getValue(8, 1))

WebUI.setText(findTestObject('Checkout Page/addressField'), findTestData('checkout_data').getValue(9, 1))

WebUI.setText(findTestObject('Checkout Page/postalCodeField'), findTestData('checkout_data').getValue(10, 1))

WebUI.click(findTestObject('Checkout Page/checkoutBtn'))

WebUI.switchToFrame(findTestObject('Summary Order/iFrameSummaryOrder'), 30)

totalAmountAtas = WebUI.getText(findTestObject('Summary Order/orderData/amountTotalHeader'), FailureHandling.STOP_ON_FAILURE).replace(
    'Rp', '').replace('.', '')

WebUI.verifyMatch(totalAmountAtas, totalAmountField, false)

orderIdText = WebUI.getText(findTestObject('Summary Order/orderData/orderID'))

WebUI.click(findTestObject('Summary Order/expandSummaryOrder'))

totalAmountBawah = WebUI.getText(findTestObject('Summary Order/orderData/amountOrderSummary')).replace('Rp', '').replace(
    '.', '')

WebUI.verifyMatch(totalAmountBawah, totalAmountAtas, false)

WebUI.verifyElementText(findTestObject('Summary Order/orderData/name'), findTestData('checkout_data').getValue(5, 1))

WebUI.verifyElementText(findTestObject('Summary Order/orderData/phone'), findTestData('checkout_data').getValue(7, 1))

WebUI.click(findTestObject('Summary Order/expandSummaryOrder'))

WebUI.click(findTestObject('Summary Order/bankTransferMethod'))

WebUI.click(findTestObject('paymentMethod/bankBCA'))

WebUI.waitForElementClickable(findTestObject('paymentMethod/paidBtn'), 40)

WebUI.click(findTestObject('paymentMethod/paidBtn'))

WebUI.verifyElementText(findTestObject('Status Payment/statusPayment'), findTestData('checkout_data').getValue(11, 1))

totalAmountFinal = WebUI.getText(findTestObject('Status Payment/amountTotal')).replace('Rp', '').replace('.', '')

WebUI.verifyMatch(totalAmountFinal, totalAmountAtas, false)

WebUI.takeScreenshot()

