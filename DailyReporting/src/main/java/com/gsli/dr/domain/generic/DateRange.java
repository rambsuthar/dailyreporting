package com.gsli.dr.domain.generic;

import java.io.Serializable;
import java.util.Date;

public class DateRange implements Serializable {
	private static final long serialVersionUID = 500942078875371930L;
	private String fieldName;
	private Date from;
	private Date to;
	private Boolean includeNull;

	public DateRange(String fieldName, Date from, Date to) {
		this.fieldName = fieldName;
		this.from = from;
		this.to = to;
	}

	public DateRange(String fieldName, Date from, Date to, Boolean includeNull) {
		this.fieldName = fieldName;
		this.from = from;
		this.to = to;
		this.includeNull = includeNull;
	}

	public DateRange(DateRange other) {
		this.fieldName = other.getFieldName();
		this.from = other.getFrom();
		this.to = other.getTo();
		this.includeNull = other.getIncludeNull();
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public boolean isFromSet() {
		return (getFrom() != null);
	}

	public Date getTo() {
		return this.to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public boolean isToSet() {
		return (getTo() != null);
	}

	public void setIncludeNull(boolean includeNull) {
		this.includeNull = Boolean.valueOf(includeNull);
	}

	public Boolean getIncludeNull() {
		return this.includeNull;
	}

	public boolean isIncludeNullSet() {
		return (this.includeNull != null);
	}

	public boolean isBetween() {
		return ((isFromSet()) && (isToSet()));
	}

	public boolean isSet() {
		return ((isFromSet()) || (isToSet()) || (isIncludeNullSet()));
	}

	public boolean isValid() {
		if (isBetween()) {
			return (getFrom().compareTo(getTo()) <= 0);
		}
		return true;
	}
}