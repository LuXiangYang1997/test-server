package com.example.test.demo.util;

import java.sql.ResultSet;

public interface ResultSetExtractor<T> {

    public abstract T extractData(ResultSet rs);

}
