package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

	public Profile getDataFromFile(File file) {
		return new Profile();
	}

	// Leer el file

	String directory = System.getProperty("user.home");
	String fileName = "Profile.txt";
	String absolutePath = directory + File.separator + fileName;{

	try(
	FileInputStream fileInputStream = new FileInputStream(absolutePath))
	{
		int ch;

		while ((ch = fileInputStream.read()) != -1) {
			System.out.print((char) ch);
		}

	}catch(
	FileNotFoundException e)
	{

	}catch(
	IOException eg)
	{

	}
}}
