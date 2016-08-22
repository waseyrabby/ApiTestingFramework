package com;

/**
 * Created by wasey on 8/21/16.
 */
public class Constant {

    public static final String ConnecTionMsg = "******Connecting To Api******";
    public static final String EndMsg = "******Closeing Connection To Api******";

    //HTTP STATUS CODE
    public static final int OK= Integer.parseInt("200");
    public static final int  Created= Integer.parseInt("201");
    public static final int Accepted= Integer.parseInt("202");
    public static final int NonAuthoritative= Integer.parseInt("203");
    public static final int NoContent= Integer.parseInt("204");
    public static final int ResetContent= Integer.parseInt("205");
    public static final int PartialContent= Integer.parseInt("206");
    public static final int MultiStatus= Integer.parseInt("207");
    public static final int AlreadyReported= Integer.parseInt("208");
    public static final int  IMUsed= Integer.parseInt("209");

    public static final int BadRequest= Integer.parseInt("400");
    public static final int Unauthorized= Integer.parseInt("401");
    public static final int PaymentRequired= Integer.parseInt("402");
    public static final int Forbidden= Integer.parseInt("403");
    public static final int  NotFound= Integer.parseInt("404");
}
