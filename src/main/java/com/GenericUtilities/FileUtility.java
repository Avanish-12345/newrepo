package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	/**
	 * This method is used to read data from property file
	 * Author Avanish kumar dubey
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream(IPathConstant.FilePath);
	Properties pobj=new Properties();
	pobj.load(fis);
	String value=pobj.getProperty(key);
	return value;
}
}
