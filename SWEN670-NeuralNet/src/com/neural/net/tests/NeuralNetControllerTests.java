package com.neural.net.tests;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.neural.net.NeuralNetController;
import com.neural.net.gui.NeuralInterface;
import com.neural.net.model.DataPoint;

public class NeuralNetControllerTests {
	
	NeuralNetController controller = new NeuralNetController();
	NeuralInterface ui = new NeuralInterface();
	
	/**
	 * Tests that training initializes without any errors
	 */
	@Test
	public void testInitializeTraining() {
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
		    
		    controller.initializeTraining(temp, ui);
			
		} catch (Exception ex){
			fail("An exception was thrown: " + ex.getMessage());
		}
	}
	
	/**
	 * Tests that the training actually works by comparing an input with the expected results
	 */
	@Test
	public void testProcessInput() {
		try {
			File temp1 = File.createTempFile("temp1", ".csv");

		    // Delete temp file when program exits.
		    temp1.deleteOnExit();

		    // Write to temp file
		    BufferedWriter out1 = new BufferedWriter(new FileWriter(temp1));
		    out1.write("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
		    out1.newLine();
		    out1.write("phon_R01_S07_1,197.07600,206.89600,192.05500,0.00289,0.00001,0.00166,0.00168,0.00498,0.01098,0.09700,0.00563,0.00680,0.00802,0.01689,0.00339,26.77500,0,0.422229,0.741367,-7.348300,0.177551,1.743867,0.085569");
		    
		    out1.close();
			
		    controller.initializeTraining(temp1, ui);
			
		    // Create temp file.
		    File temp = File.createTempFile("temp", ".csv");

		    // Delete temp file when program exits.
		    temp.deleteOnExit();

		    // Write to temp file
		    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		    out.write("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
		    out.close();
		    
		    List<DataPoint> points = controller.processInput(temp);
		    
		    assertTrue(points.size() == 1);
		    assertTrue(points.get(0).getResult() > .9);
		    
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed with exception: " + e.getMessage());
		}
	}

}
