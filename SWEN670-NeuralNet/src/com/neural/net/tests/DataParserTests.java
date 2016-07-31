package com.neural.net.tests;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.junit.Test;

import com.neural.net.model.DataPoint;
import com.neural.net.parser.DataParser;

public class DataParserTests {
	
	/**
	 * Tests that the parser can correctly parse the specially formatted .csv file
	 */
	@Test
	public void testParseDataFile() {
		try {
			File temp = File.createTempFile("temp", ".csv");
	
		    // Delete temp file when program exits.
		    temp.deleteOnExit();
	
		    // Write to temp file
		    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		    out.write("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
		    out.newLine();
		    out.write("phon_R01_S07_1,197.07600,206.89600,192.05500,0.00289,0.00001,0.00166,0.00168,0.00498,0.01098,0.09700,0.00563,0.00680,0.00802,0.01689,0.00339,26.77500,0,0.422229,0.741367,-7.348300,0.177551,1.743867,0.085569");
		    
		    out.close();
		    
		    List<DataPoint> points = DataParser.parseDataFile(temp);
		    
		    assertTrue(points.size() == 2);
		    assertTrue(points.get(0).getName().equals("phon_R01_S06_6"));
		    assertTrue(points.get(1).getName().equals("phon_R01_S07_1"));
		} catch (Exception ex){
			fail("An exception occurred: " + ex.getMessage());
		}
	}
	
	/**
	 * Tests that an exception is thrown if a bad data file is given without enough elements
	 */
	@Test
	public void testBadDataFileNotEnoughElements(){
		try {
			File temp = File.createTempFile("temp", ".csv");
	
		    // Delete temp file when program exits.
		    temp.deleteOnExit();
	
		    // Write to temp file
		    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		    out.write("hi,1,2,3,4");
		    
		    out.close();
		    
		    List<DataPoint> points = DataParser.parseDataFile(temp);
		    
		    fail("No exception was thrown");
		} catch (Exception ex){
			assertTrue(true);
		}
	}
	
	/**
	 * Tests that an exception is thrown if a bad data file is given with enough elements but a string where it shouldn't be
	 */
	@Test
	public void testBadDataFileEnoughElementsWithBadString(){
		try {
			File temp = File.createTempFile("temp", ".csv");
	
		    // Delete temp file when program exits.
		    temp.deleteOnExit();
	
		    // Write to temp file
		    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		    out.write("hi,1,2,3,4,5,6,7,8,9,0,1,2,3,string,5,6,7,8,9,0,1,2,3");
		    
		    out.close();
		    
		    List<DataPoint> points = DataParser.parseDataFile(temp);
		    
		    fail("No exception was thrown");
		} catch (Exception ex){
			assertTrue(true);
		}
	}
	
	/**
	 * Tests that DataParser can return a well formed DataPoint given a specially formatted string
	 */
	@Test
	public void testParseDataString(){
		try {
			String data = "phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242";
			
			DataPoint point = DataParser.parseDataString(data);
			
			assertTrue(point != null);
			assertTrue(point.getName().equals("phon_R01_S06_6"));
		} catch (Exception ex){
			fail("An exception was thrown: " + ex.getMessage());
		}
	}
	
	/**
	 * Tests that an exception is thrown if a bad data string is given without enough elements
	 */
	@Test
	public void testBadDataStringNotEnoughElements(){
		try {
			String val = "hi,this,is,wrong";
		    
		    DataPoint point = DataParser.parseDataString(val);
		    
		    fail("No exception was thrown");
		} catch (Exception ex){
			assertTrue(true);
		}
	}
	
	/**
	 * Tests that an exception is thrown if a bad data string is given with enough elements but a string where it shouldn't be
	 */
	@Test
	public void testBadDataStringEnoughElementsWithBadString(){
		try {
			String val = "hi,1,2,3,4,5,6,7,8,9,0,1,2,3,string,5,6,7,8,9,0,1,2,3";
		    
		    DataPoint point = DataParser.parseDataString(val);
		    
		    fail("No exception was thrown");
		} catch (Exception ex){
			assertTrue(true);
		}
	}
	
	/**
	 * Tests that the normalize data method correctly normalizes the data to between 0 and 1
	 */
	@Test
	public void testNormalizeData(){
		try {
			File temp = File.createTempFile("temp", ".csv");
	
		    // Delete temp file when program exits.
		    temp.deleteOnExit();
	
		    // Write to temp file
		    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		    out.write("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
		    out.newLine();
		    out.write("phon_R01_S07_1,197.07600,206.89600,192.05500,0.00289,0.00001,0.00166,0.00168,0.00498,0.01098,0.09700,0.00563,0.00680,0.00802,0.01689,0.00339,26.77500,0,0.422229,0.741367,-7.348300,0.177551,1.743867,0.085569");
		    
		    out.close();
		    
		    List<DataPoint> points = DataParser.parseDataFile(temp);
		    
		    assertTrue(points.get(0).getMDVP_Fo_Hz() == 162.56800);
		    
		    points = DataParser.normalizeData(points, points);
		    
		    assertTrue(points.get(0).getMDVP_Fo_Hz() >= 0 && points.get(0).getMDVP_Fo_Hz() <= 1);
		    
		} catch (Exception ex){
			fail("An exception occurred: " + ex.getMessage());
		}
	}
	
	/**
	 * Tests that the nomalize method accepts three inputs and returns a value between 0 and 1
	 */
	@Test
	public void testNormalize(){
		double val = DataParser.normalize(60, 50, 100);
		
		assertTrue(val == 0.2);
	}
	
	/**
	 * Tests that the minimum value is returned
	 */
	@Test
	public void testCheckMin(){
		assertTrue(DataParser.checkMin(1, 2) == 1);
	}
	
	/**
	 * Tests that the maximum value is returned
	 */
	@Test
	public void testCheckMax(){
		assertTrue(DataParser.checkMax(1, 2) == 2);
	}

}
