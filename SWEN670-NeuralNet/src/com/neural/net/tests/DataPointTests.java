package com.neural.net.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neural.net.model.DataPoint;
import com.neural.net.parser.DataParser;

/**
 * Most of this class are just getters and setters, however there are a few process methods that can be tested
 * @author hufcat05
 *
 */
public class DataPointTests {
	/**
	 * Tests that toArray is only outputting the correct number of fields for the neural network
	 */
	@Test
	public void testToArray() {
		try {
			DataPoint point = DataParser.parseDataString("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
	
			double[] arr = point.toArray();
			
			assertTrue(arr.length == 22);
		} catch (Exception ex){
			fail("An exception was thrown: " + ex.getMessage());
		}
	}

}
