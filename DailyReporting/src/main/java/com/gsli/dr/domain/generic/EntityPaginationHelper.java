package com.gsli.dr.domain.generic;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.gsli.dr.common.util.DRContractChecker;
import com.gsli.dr.common.util.ObjectChecker;
import com.gsli.dr.common.view.util.DRPageConfig;
import com.gsli.dr.common.view.util.PageSortDirection;

public class EntityPaginationHelper {
	public static Pageable constructPageSpecification(DRPageConfig pageConfig) {
		Pageable pageSpecification = null;
		DRContractChecker.notNullObjects(
				EntityPaginationHelper.class.getName(),
				"constructPageSpecification", new Object[] { pageConfig });
		DRContractChecker.notEmptyStrings(
				EntityPaginationHelper.class.getName(),
				"constructPageSpecification",
				pageConfig.getPropertiesToOrderBy());

		if (pageConfig.getResultsPerPage() == 0) {
			pageConfig.setResultsPerPage(20);
		}

		Sort.Direction sortDirection = Sort.Direction.ASC;
		if (ObjectChecker.objectNotNull(pageConfig.getSortDirection())) {
			String selectedSortDir = pageConfig.getSortDirection().toString();
			if ((!(ObjectChecker.isStringEmpty(selectedSortDir)))
					&& (selectedSortDir
							.equalsIgnoreCase(PageSortDirection.SORT_DESC
									.name()))) {
				sortDirection = Sort.Direction.DESC;
			}
		}
		pageSpecification = new PageRequest(pageConfig.getPageNum(),
				pageConfig.getResultsPerPage(), sortDirection,
				pageConfig.getPropertiesToOrderBy());
		return pageSpecification;
	}
}