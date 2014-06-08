package com.gsli.dr.domain.service;

import com.gsli.dr.domain.entity.DailyReport;
import com.gsli.dr.domain.generic.GenericEntityService;
import com.gsli.dr.domain.generic.GenericRepository;
import com.gsli.dr.web.mvc.model.DailyReportVO;

public abstract interface DailyReportService extends GenericEntityService<DailyReport, Long>{

	public abstract GenericRepository<DailyReport, Long> getEntityRepository();

	public DailyReport create(DailyReportVO dailyReportVO);
}
