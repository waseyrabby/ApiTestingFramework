package com.paxovision.api.spree;

/**
 * Created by wasey on 8/21/16.
 */
public class SpreeAppConstant {

    public static final String SpreeURL = "http://spree.paxotech.com";
    public static final int SpreePort= Integer.parseInt("80");
    public static final String SpreeBase= "/api";
    public static final String SpreeToken= "X-Spree-Token";
    public static final String SpreeKey= "52a997116f906d2587dd9d8508e27d9167bdc90348bbdc9b";

    public static final String USERNAME = "aamwasey1";
    public static final String AUTOMATE_KEY = "hSRqEJw7xmCdMu4omyRZ";
    public static final String REMOTEURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final StringBuffer verificationErrors = new StringBuffer();
    public static final String dataFile = System.getProperty("user.dir") + "/src/main/resources/KeyWord.txt";
}
