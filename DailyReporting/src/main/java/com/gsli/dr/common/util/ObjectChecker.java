
package com.gsli.dr.common.util;

public class ObjectChecker {
	public static boolean isStringEmpty(String str) {
		boolean retVal = false;
		if ((str == null) || ("".equals(str))) {
			retVal = true;
		}
		return retVal;
	}

	public static boolean objectNotNull(Object obj) {
		boolean retVal = true;
		if (obj == null) {
			retVal = false;
		}
		return retVal;
	}

	public static boolean notNullObjects(Object[] objcts)
  {
    boolean retVal = true;
    for (Object arg : objcts) {
      if (arg == null) {
        retVal = false;
        break;
      }
    }
    return retVal;
  }
}