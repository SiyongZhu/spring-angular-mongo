package com.syz.springangular.demo.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public class SharedParameters {

    public static final int DEFAULT_BOOKS_PER_PAGE = 5;
    
    public static final String NEW_YORKER = "NewYorker";
    public static final String NEW_YORK_TIMES = "NYT";
    public static final String ECONOMIST = "Economist";
    public static final String POLITICS_PROSE = "P&P";
    public static final String COMMON_WEALTH = "CommonWealth";
    public static final String PUBLISHER_WEEKLY = "PW";
    public static final String KIRKUS = "Kirkus";
    
    
    public static Pageable sortByPublishDatePage = PageRequest.of(0, SharedParameters.DEFAULT_BOOKS_PER_PAGE, Sort.by(Order.desc("publishDate")));
}
