package air;
import javax.json.Json;
import javax.json.JsonObject;

import org.testng.annotations.DataProvider;

public class MyDataProvider {
 
	@DataProvider(name = "bankProvider1")
	public Object[][] positiveDataProvider() {
		JsonObject requestBody1 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();

	    String responseBody1 = "{\"success\":\"Bank details saved\"}";
		return new Object[][] { {requestBody1, 200, responseBody1 }};
    }
    
	@DataProvider(name = "bankProvider2")
	public Object[][] accountnumberDataProvider() {
		JsonObject requestBody1 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody2 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","123456789123456789")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody3 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","1")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody4 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","1234567891")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody5 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "CN")
			     .add("account_name", "Jessie")
			     .add("account_number","12")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody6 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "CN")
			     .add("account_name", "Jessie")
			     .add("account_number","123456789123456789123456")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
	    String responseBody1 = "{\"error\":\"'account_number' is required\"}";
	    String responseBody2 = "{\"error\":\"Length of account_number should be between 7 and 11 when bank_country_code is 'US'\"}";
	    String responseBody3 = "{\"error\":\"Length of account_number should be between 6 and 9 when bank_country_code is 'AU'\"}";
	    String responseBody4 = "{\"error\":\"Length of account_number should be between 6 and 9 when bank_country_code is 'AU'\"}";
	    String responseBody5 = "{\"error\":\"Length of account_number should be between 8 and 20 when bank_country_code is 'CN'\"}";
	    String responseBody6 = "{\"error\":\"Length of account_number should be between 8 and 20 when bank_country_code is 'CN'\"}";
		return new Object[][] { {  requestBody1, 400, responseBody1 } ,{requestBody2, 400, responseBody2},{requestBody3, 400, responseBody3},{requestBody4, 400, responseBody4},{requestBody5, 400, responseBody5},{requestBody6, 400, responseBody6}};
    }
	
	@DataProvider(name = "bankProvider3")
	public Object[][] paymentmethodDataProvider() {
		JsonObject requestBody1 = Json.createObjectBuilder()
			     .add("payment_method", "")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody2 = Json.createObjectBuilder()
			     .add("payment_method", "TEST")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody3 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();


	    String responseBody1 = "{\"error\":\"'payment_method' field required, the value should be either 'LOCAL' or 'SWIFT'\"}";
	    String responseBody2 = "{\"error\":\"'payment_method' field required, the value should be either 'LOCAL' or 'SWIFT'\"}";
	    String responseBody3 = "{\"success\":\"Bank details saved\"}";
		return new Object[][] { {  requestBody1, 400, responseBody1 } ,{requestBody2, 400, responseBody2},{requestBody3, 200, responseBody3}};
    }
	
	@DataProvider(name = "bankProvider4")
	public Object[][] bankcountrycodeDataProvider() {
		JsonObject requestBody1 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "")
			     .add("account_name", "Jessie")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody2 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody3 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "CN")
			     .add("account_name", "Jessie")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody4 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "CU")
			     .add("account_name", "Jessie")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();


	    String responseBody1 = "{\"error\":\"'bank_country_code' is required, and should be one of 'US', 'AU', or 'CN'\"}";
	    String responseBody2 = "{\"success\":\"Bank details saved\"}";

	    String responseBody3 = "{\"success\":\"Bank details saved\"}";
	    String responseBody4 = "{\"error\":\"'bank_country_code' is required, and should be one of 'US', 'AU', or 'CN'\"}";
		return new Object[][] { {  requestBody1, 400, responseBody1 } ,{requestBody2, 200, responseBody2},{requestBody3, 200, responseBody3}, {requestBody4, 400, responseBody4}};
    }
	
	@DataProvider(name = "bankProvider5")
	public Object[][] accountnameDataProvider() {
		JsonObject requestBody1 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "AU")
			     .add("account_name", "$#%^&*@|?")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody2 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "AU")
			     .add("account_name", "")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody3 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "AU")
			     .add("account_name", "$#%^&*@|\\\"?????")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody4 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "AU")
			     .add("account_name", "1")
			     .add("account_number","\"1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();

	    String responseBody1 = "{\"success\":\"Bank details saved\"}";
	    String responseBody2 = "{\"error\":\"'account_name' is required\"}";
	    String responseBody3 = "{\"error\":\"Length of account_name should be between 2 and 10\"}";
	    String responseBody4 = "{\"error\":\"Length of account_name should be between 2 and 10\"}";
		return new Object[][] { {  requestBody1, 200, responseBody1 } ,{requestBody2, 400, responseBody2},{requestBody3, 400, responseBody3}, {requestBody4, 400, responseBody4}};
    }
	
	@DataProvider(name = "bankProvider6")
	public Object[][] swiftcodeDataProvider() {
		JsonObject requestBody1 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody2 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody3 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUUBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody4 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody5 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "CN")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody6 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody7 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJJJJ")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody8 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUS")
			     .add("aba", "11122233A")
			     .build();

		JsonObject requestBody9 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUS")
			     .add("aba", "11122233A")
			     .build();
		JsonObject requestBody10 = Json.createObjectBuilder()
			     .add("payment_method", "LOCAL")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUUBJ")
			     .add("aba", "11122233A")
			     .build();

	    String responseBody1 = "{\"error\":\"'swift_code' is required when payment method is 'SWIFT'\"}";
	    String responseBody2 = "{\"success\":\"Bank details saved\"}";
	    String responseBody3 = "{\"error\":\"The swift code is not valid for the given bank country code: US\"}";
	    String responseBody4 = "{\"error\":\"The swift code is not valid for the given bank country code: AU\"}";
	    String responseBody5 = "{\"error\":\"The swift code is not valid for the given bank country code: CN\"}";
	    String responseBody6 = "{\"error\":\"Length of 'swift_code' should be either 8 or 11\"}";
	    String responseBody7 = "{\"success\":\"Bank details saved\"}";
	    String responseBody8 = "{\"error\":\"Length of 'swift_code' should be either 8 or 11\"}";
	    String responseBody9 = "{\"success\":\"Bank details saved\"}";
	    String responseBody10 = "{\"success\":\"Bank details saved\"}";
		return new Object[][] { {  requestBody1, 400, responseBody1 } ,{requestBody2, 200, responseBody2},{requestBody3, 400, responseBody3}, {requestBody4, 400, responseBody4}, {requestBody5, 400, responseBody5},{requestBody6, 400, responseBody6},{requestBody7, 200, responseBody7},{requestBody8, 400, responseBody8},{requestBody9, 200, responseBody9},{requestBody10, 200, responseBody10}};
    }
	
	@DataProvider(name = "bankProvider7")
	public Object[][] bsbabaDataProvider() {
		JsonObject requestBody1 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "")
			     .build();
		JsonObject requestBody2 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "11")
			     .build();
		JsonObject requestBody3 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "%^${}&?<>")
			     .build();
		JsonObject requestBody4 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("aba", "1234567890")
			     .build();
		JsonObject requestBody5 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "US")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCUSBJ")
			     .add("bsb", "11122233A")
			     .build();
		
		JsonObject requestBody6 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCAUBJ")
			     .add("bsb", "")
			     .build();
		JsonObject requestBody7 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCAUBJ")
			     .add("bsb", "11")
			     .build();
		JsonObject requestBody8 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCAUBJ")
			     .add("bsb", "%^$?}&")
			     .build();
		JsonObject requestBody9 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCAUBJ")
			     .add("bsb", "1234567")
			     .build();
		JsonObject requestBody10 = Json.createObjectBuilder()
			     .add("payment_method", "SWIFT")
			     .add("bank_country_code", "AU")
			     .add("account_name", "Jessie")
			     .add("account_number","1#$!>~")
			     .add("swift_code", "ICBCAUBJ")
			     .add("aba", "111222")
			     .build();

	    String responseBody1 = "{\"error\":\"'aba' is required when bank country code is 'US'\"}";
	    String responseBody2 = "{\"error\":\"Length of 'aba' should be 9\"}";
	    String responseBody3 = "{\"success\":\"Bank details saved\"}";
	    String responseBody4 = "{\"error\":\"Length of 'aba' should be 9\"}";
	    String responseBody5 = "{\"error\":\"'aba' is required when bank country code is 'US'\"}";
	    String responseBody6 = "{\"error\":\"'bsb' is required when bank country code is 'AU'\"}";
	    String responseBody7 = "{\"error\":\"Length of 'bsb' should be 6\"}";
	    String responseBody8 = "{\"success\":\"Bank details saved\"}";
	    String responseBody9 = "{\"error\":\"Length of 'bsb' should be 6\"}";
	    String responseBody10 = "{\"error\":\"'bsb' is required when bank country code is 'AU'\"}";
	    return new Object[][] { {  requestBody1, 400, responseBody1 } ,{requestBody2, 400, responseBody2},{requestBody3, 200, responseBody3}, {requestBody4, 400, responseBody4}, {requestBody5, 400, responseBody5},{requestBody6, 400, responseBody6},{requestBody7, 400, responseBody7},{requestBody8, 200, responseBody8},{requestBody9, 400, responseBody9},{requestBody10, 400, responseBody10}};
    }
}
