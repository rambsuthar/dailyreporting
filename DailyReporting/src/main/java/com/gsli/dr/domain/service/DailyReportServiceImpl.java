package com.gsli.dr.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsli.dr.domain.entity.DailyReport;
import com.gsli.dr.domain.generic.GenericEntityServiceImpl;
import com.gsli.dr.domain.generic.GenericRepository;
import com.gsli.dr.domain.repository.DailyReportRepository;

public class DailyReportServiceImpl extends GenericEntityServiceImpl<DailyReport, Long> implements DailyReportService{
	
	@Autowired
	private DailyReportRepository dailyReportRepository;

	public DailyReportRepository getDailyReportRepository() {
		return dailyReportRepository;
	}

	public void setDailyReportRepository(DailyReportRepository dailyReportRepository) {
		this.dailyReportRepository = dailyReportRepository;
	}

	@Override
	public GenericRepository<DailyReport, Long> getEntityRepository() {
		return getDailyReportRepository();
	}

	@Override
	public boolean validateEntity(DailyReport paramT) {
		return true;
	}

}
