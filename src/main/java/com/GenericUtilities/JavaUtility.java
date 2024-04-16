package com.GenericUtilities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility
{
public int getRandomno()
{
	Random ran=new Random();
	int random=ran.nextInt(500);
	return random;
}
public String getSystemdate()
{
	java.util.Date dt=new java.util.Date();
	String date=dt.toString();
	return date;
}
public String getSystemDateinFormat()
{
	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	java.util.Date dt=new java.util.Date();
	String sysDateinFormat=dateformat.format(dt);
	return sysDateinFormat;
}
}
