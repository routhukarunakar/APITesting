package com.daimler.dcPortal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;

//import static org.junit.Assert.assertEquals;
//import org.junit.Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTesting_Analytics {

	public TestBase testbase;
	private Map<String, String> propertyMap;

	HttpClient client = HttpClientBuilder.create().build();
	RequestSpecification request = RestAssured.given();

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		testbase = new TestBase();
		propertyMap = testbase.setUp();
	}

	@Test
	public void baseurl200() throws ClientProtocolException, IOException {
		String tblList = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("TableList"));

		Response response = noParams(tblList);
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getVehStatus() throws ClientProtocolException, IOException {
		String epGetVehStatus = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("GetVehStatus"));

		Response response = noParams(epGetVehStatus);
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getVehicle() throws ClientProtocolException, IOException {
		String epGetVehicle = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("GetVehicle"));

		Response response = noParams(epGetVehicle);
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void vintrip() throws ClientProtocolException, IOException {
		String epVinTrips180 = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("VinTrips180"));

		Response response = noParams(epVinTrips180);
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void vehicleMaintenence() throws ClientProtocolException, IOException {
		String epvehiclemaintenence = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("VehicleMaintenence"));
		 
		Response response = noParams(epvehiclemaintenence);
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getOtaDdecReportStatus() throws ClientProtocolException, IOException {
		String epOtaDdecReportStatus = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("OtaDdecReportStatus"));

		Response response = noParams(epOtaDdecReportStatus);
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getCcDdecReports() throws ClientProtocolException, IOException {
		String epCcDdecReports = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("CcDdecReports"));

		Response response = noParams(epCcDdecReports);
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getTripAnalyticsData() {
		String epTripAnalyticsData = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("TripAnalyticsData"));

		Response response = AnalyticsDataTwo(epTripAnalyticsData, "TN13766", "3AKJHHDR3MSMD9162");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getFEAnalyticsData() {
		String epFEAnalyticsData = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("FEAnalyticsData"));

		Response response = AnalyticsDataTwo(epFEAnalyticsData, "TN13766", "3AKJHHDR3MSMD9162");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getPopulationAnalytics() {
		String epGetPopulation = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("GetPopulation"));
		Response response = AnalyticsDataOne(epGetPopulation, "TN13766");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
		//		ResponseBody actualbody = (ResponseBody) responseMap.get("actualbody");
	}

	@Test
	public void getSafetyAnalytics() {
		String epGetSafetyAnalytics = String.format("%s%s", propertyMap.get("EnvURL"),propertyMap.get("GetSafetyAnalytics"));
		Response response = AnalyticsDataOne(epGetSafetyAnalytics, "TN13766");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getSafetyAnalyticsPerVin() {
		String epSafetyAnalyticsPerVin = String.format("%s%s", propertyMap.get("EnvURL"),propertyMap.get("SafetyAnalyticsPerVin"));
		Response response = AnalyticsDataTwo(epSafetyAnalyticsPerVin, "TN137666", "3AKJHHDR3MSMD9162");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getDriveScoreLbData() {
		String epDriveScoreLbData = String.format("%s%s", propertyMap.get("EnvURL"),propertyMap.get("DriveScoreLbData"));
		Response response = AnalyticsDataOne(epDriveScoreLbData, "TN13766");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getDriveScoresFor30DaysPerVin() {
		String epDriveScore30Days = String.format("%s%s", propertyMap.get("EnvURL"),propertyMap.get("DriveScore30Days"));
		Response response = AnalyticsDataTwo(epDriveScore30Days, "TN13766", "3AKJHHDR3MSMD9162");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getsafetyEvents() {
		String epSafetyEvents = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("SafetyEvents"));
		Response response = safetyEvents(epSafetyEvents, "TN15208", "3AKJHHDR6JSHU5842", "1588965984000","1589225184000");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void getRingBufferForSafetyEvent() {
		String epSafetyRbuffer = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("SafetyRbuffer"));
		Response response = ringBufferForsafetyEvent(epSafetyRbuffer, "DEVZONAR361000302", "1580769727000");
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void faultFlag() {
		String epFaultFlag = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("TableQry"));
		Response response = regTableParams(epFaultFlag, "FAULT_FLAG", "TV24504:3AKJGLDR3HSHT2255:", 100);
		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void parameterProfile() {
		String epparameterProfile = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("TableQry"));
		Response response = regTableParams(epparameterProfile, "PARAMETER_PROFILE", "TV24504:", 100);

		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void vehicleFaults() {
		String epvehicleFaults = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("TableQry"));
		Response response = regTableParams(epvehicleFaults, "FAULT", "3AKJGLDR3HSHT2255:", 2);

		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	@Test
	public void collectiveAnalytics() {
		String epcollectiveAnalytics = String.format("%s%s", propertyMap.get("EnvURL"), propertyMap.get("TableQry"));
		Response response = regTableParams(epcollectiveAnalytics, "COLLECTIVE_ANALYTICS", "TV24504:3AKJGLDR3HSHT2255:",2);

		Map<String, Object> responseMap = parseResponse(response);
		AssertJUnit.assertEquals((int) responseMap.get("actualStatus"), 200);
	}

	public Response noParams(String url) {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		return request.get();
	}

	public Response AnalyticsDataOne(String url, String role) {
		String queryParam = String.format("%s%s%s", "[[\"", role,"\"]]"); 	// [["TN13766"]]
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		return request.body(queryParam).get();
	}

	public Response AnalyticsDataTwo(String url, String tan, String vin) {
		String queryParam = String.format("%s%s%s%s%s", "[[\"", tan,"\"],\"", vin,"\"]]"); 		// [["TN13766"],"3AKJHHDR3MSMD9162"]
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		return request.body(queryParam).get();
	}

	public Response safetyEvents(String url, String tan, String vin, String starttime, String endtime) {
		String queryParam = String.format("%s%s%s%s%s%s%s%s%s", "[\"", tan,"\",\"", vin,"\",\"", starttime, "\",\"" , endtime , "\"]");
		// ["TN15208","3AKJHHDR6JSHU5842",1588965984000,1589225184000]
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		return request.body(queryParam).post();
	}

	public Response ringBufferForsafetyEvent(String url, String vin, String timestamp) {
		String queryParam = String.format("%s%s%s%s%s", "[\"", vin, "\",\"" , timestamp , "\"]");    // ['DEVZONAR361000302',1580769727000]
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		return request.body(queryParam).post();
	}

	public Response regTableParams(String url, String tablename, String begin, int limit) {
		String queryParam = String.format("%s%s%s%s%s%s%s%s", "[{\"table\":\"" , tablename , "\",\"keys\":[{\"begin\":\"" , begin , "\"}]" , ",\"limit\":\"" , limit , "\"}]");
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		return request.body(queryParam).post();
	}

	public Map<String, Object> parseResponse(Response response) {
		Map<String, Object> map = new HashMap<>();
		map.put("actualStatus", response.getStatusCode());
		map.put("actualbody", response.body());
		map.put("actualresponse", response.prettyPrint());
		map.put("actualHeaders", response.getHeaders());
		//		String actualresponse= response.prettyPrint();
		//		Headers actualHeaders= response.getHeaders();
		return map;
	}

}
