package com.rexel.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
	TestUtils utils = new TestUtils();

	public DesiredCapabilities getCaps() throws IOException {
		GlobalParams params = new GlobalParams();
		Properties props = new PropertyManager().getProps();

		try {
			utils.log().info("getting capabilities");
			DesiredCapabilities caps = new DesiredCapabilities();

			switch (params.getPlatformName()) {
			case "Android":
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
				caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
				caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
				caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
				caps.setCapability("systemPort", params.getSystemPort());
				caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
				caps.setCapability("autoGrantPermissions", true);
				caps.setCapability("autoAcceptAlerts", "true");
				// String androidAppUrl =
				// getClass().getResource(props.getProperty("androidAppLocation")).getFile();
				String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "resources" + File.separator + "apps" + File.separator
						+ "app-qa_rexelse-release.apk";
				utils.log().info("appUrl is" + androidAppUrl);
				caps.setCapability("app", androidAppUrl);
				break;
			case "iOS":
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
				caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
				// String iOSAppUrl =
				// getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
				String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "resources" + File.separator + "apps" + File.separator
						+ "SwagLabsMobileApp.app";
				utils.log().info("appUrl is" + iOSAppUrl);
				caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
				caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
				caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
				caps.setCapability("autoGrantPermissions", true);
				caps.setCapability("autoAcceptAlerts", "true");
				caps.setCapability("app", iOSAppUrl);
				break;
			case "Browserstack":
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getType());
				caps.setCapability("device", params.getDeviceName());
				caps.setCapability("os_version", params.getOsVersion());
				caps.setCapability("project", "Rexel Demo");
				caps.setCapability("build", params.getBrowserstackBuildName());
				caps.setCapability("name", "Login Test");
				caps.setCapability("app", "bs://" + params.getBrowserstackAppId());
				caps.setCapability("autoAcceptAlerts", "true");
			}
			return caps;
		} catch (Exception e) {
			e.printStackTrace();
			utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
			throw e;
		}
	}
}
