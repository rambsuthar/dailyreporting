package com.gsli.dr.web.mvc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsli.dr.domain.entity.DailyReport;
import com.gsli.dr.domain.service.DailyReportService;
import com.gsli.dr.web.mvc.model.DailyReportVO;
import com.gsli.dr.web.mvc.model.Shop;

@Controller
@RequestMapping("/dailyreport/")
public class JSONController {

	@Autowired
	private DailyReportService dailyReportService;
	
	@RequestMapping(value = "{name}", method = RequestMethod.POST)
	public @ResponseBody
	DailyReport getShopInJSON(@RequestBody Shop s) {
		String name="ram";
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "mkyong1", "mkyong2" });

		return new DailyReport();

	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody DailyReport createDailyEntry(@ModelAttribute("SpringWeb") DailyReportVO dailyReportVO) {
		DailyReport dr = new DailyReport();
		dr.setCreatedDate(new Date());
		try{
			 dr = dailyReportService.create(dailyReportVO);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responsedr;
	}


}