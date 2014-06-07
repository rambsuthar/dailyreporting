package com.gsli.dr.domain.service;

import com.gsli.dr.domain.entity.DailyReport;
import com.gsli.dr.domain.generic.GenericRepository;

public abstract interface DailyReportService {

	public abstract GenericRepository<DailyReport, Long> getEntityRepository();
}
