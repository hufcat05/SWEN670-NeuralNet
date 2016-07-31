package com.neural.net.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neural.net.model.DataPoint;
import com.neural.net.model.DataPointFactory;

public class DataPointFactoryTests {
	
	/**
	 * Tests that the data point generated is correct
	 */
	@Test
	public void testGenerateDataPoint() {
		DataPoint point = DataPointFactory.generateDataPoint("phon_R01_S06_6",162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242);
		
		assertTrue(point != null);
		assertTrue(point.getName().equals("phon_R01_S06_6"));
		assertTrue(point.getStatus() == 1);
	}

}
