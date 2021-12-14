package com.daimler.dcPortal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestBase {

		public static Properties prop;
		String localDir = System.getProperty("user.dir");
		public static final String Path_Co = "\\src\\test\\java\\com\\daimler\\dcPortal\\config.properties";
		
		public TestBase() {
			prop = new Properties();
			try {
				FileInputStream fs = new FileInputStream(localDir + Path_Co);
				prop.load(fs);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		}
				
		public Map<String, String> setUp() {
			Map<String, String> propertyMap = new HashMap<>();
			
			String envUrl = null;
			String rootUrl = prop.getProperty("Env");
			
			
			if(rootUrl.equals("QA_East")) {
				envUrl = prop.getProperty("QA_East");
			}
			else if(rootUrl.equals("QA_West")) {
				envUrl =  prop.getProperty("QA_West");
			}
			else if(rootUrl.equals("PROD_East")) {
				envUrl =  prop.getProperty("PROD_East");
			}
			else if(rootUrl.equals("PROD_West")) {
				envUrl =  prop.getProperty("PROD_West");
			}
			else	{
				envUrl = prop.getProperty("Dev");
			}
			
			propertyMap.put("EnvURL",envUrl);
			
			propertyMap.put("TableList", prop.getProperty("TBLLIST"));
			propertyMap.put("TableQry", prop.getProperty("TBLQRY"));
			
			
			propertyMap.put("GetVehStatus", prop.getProperty("GETVEHSTATUS"));
			propertyMap.put("GetVehicle", prop.getProperty("GETVEHICLE"));
			propertyMap.put("VinTrips180", prop.getProperty("VINTRIPS180"));
			propertyMap.put("TripAnalyticsData", prop.getProperty("TRIPANALYTICSDATA"));
			propertyMap.put("FEAnalyticsData", prop.getProperty("FEANALYTICSDATA"));
			
			
			propertyMap.put("GetPopulation", prop.getProperty("GETPOPULATION"));
			propertyMap.put("GetSafetyAnalytics", prop.getProperty("GETSAFETYANALYTICS"));
			propertyMap.put("SafetyEvents", prop.getProperty("SAFETYEVENTS"));
			propertyMap.put("SafetyRbuffer", prop.getProperty("SAFETYRBUFFER"));
			propertyMap.put("SafetyAnalyticsPerVin", prop.getProperty("SAFETYANALYTICSPERVIN"));
			
			propertyMap.put("DriveScore30Days", prop.getProperty("DRIVESCORE30DAYS"));
			propertyMap.put("DriveScoreLbData", prop.getProperty("DRIVESCORELBDATA"));
			propertyMap.put("DriveScorePerTrip", prop.getProperty("DRIVESCOREPERTRIP"));
			propertyMap.put("EP_TRIPDEF", prop.getProperty("EP_TRIPDEF"));
			
			propertyMap.put("VehicleMaintenence", prop.getProperty("VEHICLEMAINTENENCE"));
			propertyMap.put("OtaDdecReportStatus", prop.getProperty("OTADDECREPORTSTATUS"));
			propertyMap.put("CcDdecReports", prop.getProperty("GETCCDDECREPORTS"));
			
			return propertyMap;
			
		
		}
		
	}

