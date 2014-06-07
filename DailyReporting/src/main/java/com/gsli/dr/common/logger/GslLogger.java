package com.gsli.dr.common.logger;


import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GslLogger {
	private Logger logger = null;

	private GslLogger(Class clazz) {
		this.logger = Logger.getLogger(clazz);
	}

	public void debug(String message) {
		this.logger.debug(message);
	}

	public void debug(String message, Throwable exception) {
		this.logger.debug(message, exception);
	}

	public void info(String message) {
		this.logger.info(message);
	}

	public void info(String message, Throwable exception) {
		this.logger.info(message, exception);
	}

	public void error(String message) {
		this.logger.error(message);
	}

	public void error(String message, Throwable exception) {
		this.logger.error(message, exception);
	}

	public static final GslLogger getGslLogger(Class clazz) {
		GslLogger epLogger = new GslLogger(clazz);
		return epLogger;
	}

	public void disableLogging()
  {
    List<Logger> loggers = Collections.list(LogManager.getCurrentLoggers());
    loggers.add(LogManager.getRootLogger());
    for (Logger logger : loggers)
      logger.setLevel(Level.ERROR);
  }

	public void setLevelToLogger(Level level, String loggerName) {
		Logger logger = Logger.getLogger(loggerName);
		logger.setLevel(level);
	}
}