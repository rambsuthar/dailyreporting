package com.gsli.dr.common.exception;

import java.util.ArrayList;
import java.util.List;

public class AppException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  private String exceptionCode = null;

  private Object[] objArray = null;
  private List<String> exceptionTrace;

  public List<String> getExceptionTrace()
  {
    if (this.exceptionTrace == null) {
      this.exceptionTrace = new ArrayList<>();
    }
    return this.exceptionTrace;
  }

  public void setExceptionTrace(List<String> exceptionTrace) {
    this.exceptionTrace = exceptionTrace;
  }

  public Object[] getObjArray()
  {
    return this.objArray;
  }

  public String getExceptionCode()
  {
    return this.exceptionCode;
  }

  public AppException(String exceptionCode)
  {
    super(exceptionCode);
    this.exceptionCode = exceptionCode;
  }

  public AppException(String exceptionCode, Throwable exception)
  {
    super(exception);
    this.exceptionCode = exceptionCode;
  }

  public AppException(String exceptionCode, String exceptionMessage, Throwable exception)
  {
    super(exceptionMessage, exception);
    this.exceptionCode = exceptionCode;
  }

  public AppException(String exceptionCode, Throwable exception, Object[] objArray)
  {
    super(exception);
    this.exceptionCode = exceptionCode;
    this.objArray = objArray;
  }

  public AppException(String exceptionCode, String exceptionMessage, Throwable exception, Object[] objArray)
  {
    super(exceptionMessage, exception);
    this.exceptionCode = exceptionCode;
    this.objArray = objArray;
  }

  public AppException(String exceptionCode, Object[] objArray)
  {
    super(exceptionCode);
    this.exceptionCode = exceptionCode;
    this.objArray = objArray;
  }
}