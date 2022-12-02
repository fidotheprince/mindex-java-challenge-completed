package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

public interface CompensationService {
       
    Compensation read(String id);
    Compensation create(String salary, String id);
}
