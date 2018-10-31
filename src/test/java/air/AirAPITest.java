package air;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.JsonObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AirAPITest {

	private String url = null;

	@Parameters("defaultUrl")
	@BeforeClass(alwaysRun = true)
	public void initialize(String defaultUrl) {
		String serverUrl = System.getProperty("serverUrl");
		System.out.println(serverUrl);
		this.url = serverUrl != null && !serverUrl.isEmpty() ? serverUrl : defaultUrl;
		System.out.println("**********************************************");
		System.out.println("Test for url " + this.url);

	}

	@Test(groups = { "air" }, dataProvider = "bankProvider1", dataProviderClass = MyDataProvider.class)
	public void positiveTest(JsonObject requestBody, int code, String responseBody) throws IOException {
		System.out.println("###Test positive cases###");
		baseTest(requestBody, code, responseBody);

	}

	@Test(groups = { "air" }, dataProvider = "bankProvider2", dataProviderClass = MyDataProvider.class)
	public void accountnumberTest(JsonObject requestBody, int code, String responseBody) throws IOException {
		System.out.println("###Test account_number related cases###");
		baseTest(requestBody, code, responseBody);
	}

	@Test(groups = { "air" }, dataProvider = "bankProvider3", dataProviderClass = MyDataProvider.class)
	public void paymentmethodTest(JsonObject requestBody, int code, String responseBody) throws IOException {
		System.out.println("###Test payment_method related cases###");
		baseTest(requestBody, code, responseBody);
	}

	@Test(groups = { "air" }, dataProvider = "bankProvider4", dataProviderClass = MyDataProvider.class)
	public void bankcountrycodeTest(JsonObject requestBody, int code, String responseBody) throws IOException {
		System.out.println("###Test bank_country_code related cases###");
		baseTest(requestBody, code, responseBody);
	}

	@Test(groups = { "air" }, dataProvider = "bankProvider5", dataProviderClass = MyDataProvider.class)
	public void accountnameTest(JsonObject requestBody, int code, String responseBody) throws IOException {
		System.out.println("###Test account_name_code related cases###");
		baseTest(requestBody, code, responseBody);
	}

	@Test(groups = { "air" }, dataProvider = "bankProvider6", dataProviderClass = MyDataProvider.class)
	public void swiftcodeTest(JsonObject requestBody, int code, String responseBody) throws IOException {
		System.out.println("###Test swift_code related cases###");
		baseTest(requestBody, code, responseBody);
	}

	@Test(groups = { "air" }, dataProvider = "bankProvider7", dataProviderClass = MyDataProvider.class)
	public void bsbabaTest(JsonObject requestBody, int code, String responseBody) throws IOException {
		System.out.println("###Test bsb_aba related cases###");
		baseTest(requestBody, code, responseBody);
	}

	private void baseTest(JsonObject requestBody, int code, String responseBody) throws IOException {

		URL myurl = new URL(url);

		HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(requestBody.toString());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("Sending 'POST' request to URL : " + url);
		System.out.println("Post Data : " + requestBody);
		System.out.println("Response Code : " + responseCode);
		assertEquals(responseCode, code);

		String output;
		StringBuffer response = new StringBuffer();
		if (responseCode == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while ((output = in.readLine()) != null) {
				response.append(output);
			}
			in.close();
		} else if (responseCode == 400) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			while ((output = in.readLine()) != null) {
				response.append(output);
			}
			in.close();
		}

		System.out.println("Response  : " + response);
		System.out.println("Response body : " + responseBody);
		assertEquals(response.toString(), responseBody);
	}
}
