package com.neural.net.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Test;

import com.neural.net.gui.NeuralInterface;

public class NetworkOutputTest {
	
	NeuralInterface gui;

	@Test
	public void testOutputFile() {
		try {
			gui = new NeuralInterface();
			
			File temp1 = File.createTempFile("temp1", ".csv");
	
		    // Delete temp file when program exits.
		    temp1.deleteOnExit();
	
		    // Write to temp file
		    BufferedWriter out1 = new BufferedWriter(new FileWriter(temp1));
		    out1.write("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
		    out1.newLine();
		    out1.write("phon_R01_S07_1,197.07600,206.89600,192.05500,0.00289,0.00001,0.00166,0.00168,0.00498,0.01098,0.09700,0.00563,0.00680,0.00802,0.01689,0.00339,26.77500,0,0.422229,0.741367,-7.348300,0.177551,1.743867,0.085569");
		    
		    out1.close();
		    
		    gui.runTrainingFile(temp1);
		    
		    File temp2 = File.createTempFile("temp2", ".csv");
			
		    // Delete temp file when program exits.
		    temp2.deleteOnExit();
	
		    // Write to temp file
		    BufferedWriter out2 = new BufferedWriter(new FileWriter(temp1));
		    out2.write("phon_R01_S06_6,162.56800,198.34600,77.63000,0.00502,0.00003,0.00280,0.00253,0.00841,0.01791,0.16800,0.00793,0.01057,0.01799,0.02380,0.01170,25.67800,1,0.427785,0.723797,-6.635729,0.209866,1.957961,0.135242");
		    
		    out2.close();
		    
		    File testOut = new File("testOut.csv");
		    
		    gui.runInputData(temp2, testOut);
		    
		    
		    BufferedReader br = null;

			String sCurrentLine;

			br = new BufferedReader(new FileReader(testOut));

			while ((sCurrentLine = br.readLine()) != null) {
				assertTrue(sCurrentLine.split(",").length == 3);
				assertTrue(sCurrentLine.equals("Name, Expected Result, Network Result") || ((sCurrentLine.split(",")[1].equals("0") || sCurrentLine.split(",")[1].equals("1")) && (Double.parseDouble(sCurrentLine.split(",")[2]) >= 0) || Double.parseDouble(sCurrentLine.split(",")[2]) <= 1));
			}
			
			assertTrue(testOut.exists());

			
			br.close();
				
		} catch (Exception ex){
			ex.printStackTrace();
			fail("An exception was thrown: " + ex.getMessage());
		
		}
	}

}
