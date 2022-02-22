package com.rexel.utils;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();
    private static ThreadLocal<String> osVersion = new ThreadLocal<String>();
    private static ThreadLocal<String> BROWSERSTACK_BUILD_NAME = new ThreadLocal<String>();
    private static ThreadLocal<String> BROWSERSTACK_APP_ID = new ThreadLocal<String>();
    private static ThreadLocal<String> type	= new ThreadLocal<String>();

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort2) {
        chromeDriverPort.set(chromeDriverPort2);
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort2) {
        wdaLocalPort.set(wdaLocalPort2);
    }

    public String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public void setWebkitDebugProxyPort(String webkitDebugProxyPort2) {
        webkitDebugProxyPort.set(webkitDebugProxyPort2);
    }
    
    public void setOsVersion(String osVersion2) {
    	osVersion.set(osVersion2);
    }
    
    public String getOsVersion() {
        return osVersion.get();
    }
    
    public String getBrowserstackBuildName() {
    	return BROWSERSTACK_BUILD_NAME.get();
    }
    
    public void setBrowserstackBuildName(String browserstackBuildName) {
    	BROWSERSTACK_BUILD_NAME.set(browserstackBuildName);
    }
    
    public void setBrowserstackAppId(String browserstackApp) {
    	BROWSERSTACK_APP_ID.set(browserstackApp);
    }
    
    public String getBrowserstackAppId() {
    	return BROWSERSTACK_APP_ID.get();
    }
    
    public void setType(String type2) {
    	type.set(type2);
    }
    
    public String getType() {
    	return type.get();
    }

    public void initializeGlobalParams(){
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUDID(System.getProperty("udid", "<enter_device_udid_here>>"));
        params.setDeviceName(System.getProperty("deviceName", "OnePlus"));

        switch(params.getPlatformName()){
            case "Android":
                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
                break;
            case "iOS":
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
                break;
            case "Browserstack":
            	break;
            default:
                throw new IllegalStateException("Invalid Platform Name!");
        }
    }
}
