package com.paxovision.api.heatclinick;

/**
 * Created by wasey on 8/21/16.
 */
public class HeatAppConstant {

    public static final String HeatURL = "http://qa1.paxotech.com";
    public static final int HeatPort= Integer.parseInt("80");
    public static final String HeatBase= "/heatclinic/api/v1";
    public static final String SEARCH_FOR= "kargo";
    public static final String USERNAME = "aamwasey1";
    public static final String AUTOMATE_KEY = "hSRqEJw7xmCdMu4omyRZ";
    public static final String REMOTEURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final StringBuffer verificationErrors = new StringBuffer();
    public static final String dataFile = System.getProperty("user.dir") + "/src/main/resources/KeyWord.txt";
}
