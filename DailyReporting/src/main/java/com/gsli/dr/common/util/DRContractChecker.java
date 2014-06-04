package com.gsli.dr.common.util;


import java.util.List;

public class DRContractChecker {
	public static void notNull(String callingClazz, String callingMethod,
			Object obj) {
		if (obj == null)
			
			throw new NullPointerException();
	}

	public static void notNullObjects(String callingClazz, String callingMethod, Object[] objcts)
  {
    for (Object arg : objcts)
      if (arg == null)
    	  throw new NullPointerException();
    	  ; 
  }

	public static void validate(String callingClazz, String callingMethod,
			Validatable validatableObject) {
		if ((!(ObjectChecker.objectNotNull(validatableObject)))
				|| (validatableObject.validate()))
			return;
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void stringNotEmpty(String callingClazz,
			String callingMethod, String str) {
		if ((str != null) && (!("".equals(str))))
			return;
		throw new NullPointerException();
	}

	public static void checkListEmpty(String callingClazz,
			String callingMethod, List argList) {
		if ((!(ObjectChecker.objectNotNull(argList))) || (!(argList.isEmpty())))
			return;
		throw new NullPointerException();
	}

	public static void notEmptyStrings(String callingClazz, String callingMethod, String[] strs)
  {
    for (String str : strs)
    {
      if ((str != null) && (!("".equals(str))))
        continue;
      throw new NullPointerException();
    }
  }
}