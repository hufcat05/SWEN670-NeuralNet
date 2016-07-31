package com.neural.net.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neural.net.Network;
import com.neural.net.model.DataPoint;
import com.neural.net.parser.DataParser;


//Since there is a random element to training a neural network, it is nearly impossible to test exact outputs using 
//JUnit. The only real test is whether or not the network as a whole predicts relatively accurately.
public class NetworkTests {
	
	Network network = new Network(22, 22, 1, 0.7, 0.9);
	
	/**
	 * Tests that without any training the base error for the network is 0
	 */
	@Test
	public void testGetErrorNoTraining() {	
		double val = network.getError(10);
		
		assertTrue(val == 0.0);
	}
	
	/**
	 * Tests that the output from training the network has only one element
	 */
	@Test
	public void testComputeOutputs(){
		try {
			DataPoint point = DataParser.parseDataString("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
			double[] outputs = network.computeOutputs(point.toArray());
			assertTrue(outputs.length == 1);
		} catch (Exception ex){
			fail("An exception was thrown: " + ex.getMessage());
		}
	}
	
	/**
	 * Tests that after training the network, the total error is greater than 0
	 */
	@Test
	public void testCalcError() {
		try {
			DataPoint point = DataParser.parseDataString("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
			double[] ideal = {1};
			double[] outputs = network.computeOutputs(point.toArray());
			network.calcError(ideal);
			network.learn();
			
			assertTrue(network.getError(1) > 0);
		} catch (Exception ex){
			fail("An exception was thrown: " + ex.getMessage());
		}
	}
	
	/**
	 * Tests that after resetting the network everything should be cleared. A good test for this is the error on the network
	 */
	@Test
	public void testReset(){
		try {
			DataPoint point = DataParser.parseDataString("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
			double[] ideal = {1};
			double[] outputs = network.computeOutputs(point.toArray());
			network.calcError(ideal);
			network.learn();
			network.reset();
			
			assertTrue(network.getError(1) == 0);
		} catch (Exception ex){
			fail("An Exception was thrown: " + ex.getMessage());
		}
	}
	
	/**
	 * Tests that the threshold calculation works properly
	 */
	@Test
	public void testThreshold() {
		double result = network.threshold(0);
		
		assertTrue(result == 0.5);
	}
}
