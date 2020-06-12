package com.syz.springangular.demo.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public class SharedParameters {

    public static final int DEFAULT_BOOKS_PER_PAGE = 5;
    
    
    public static Pageable sortByPublishDatePage = PageRequest.of(0, SharedParameters.DEFAULT_BOOKS_PER_PAGE, Sort.by(Order.desc("publishDate")));
}
