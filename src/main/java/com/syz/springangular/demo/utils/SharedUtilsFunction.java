package com.syz.springangular.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedUtilsFunction {

    public static Date constructDateByYearMonth(String year, String month) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(year+"-"+month+"-02");
    }
}
