package com.neural.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.neural.net.model.DataPoint;
import com.neural.net.parser.DataParser;

public class NeuralNetDriver {
	private static final String PROPS_LOCATION = "conf/neural-net.properties";
	
	private static File trainingData;
	private static List<DataPoint> dataPoints;
	private static List<double[]> expectedStatus;

	public static void main(String[] args) {
		Network network = new Network(22, 22, 1, 0.7, 0.9);
		expectedStatus = new ArrayList<double[]>();
		
		loadProps();
		
		dataPoints = DataParser.parseDataFile(trainingData);
		dataPoints = DataParser.normalizeData(dataPoints);
		
		DataPoint oneDataPoint = null;
		DataPoint zeroDataPoint = null;
		
		for (DataPoint dataPoint : dataPoints){
			if (dataPoint.getStatus() == 1){
				oneDataPoint = dataPoint;
			} else if (dataPoint.getStatus() == 0){
				zeroDataPoint = dataPoint;
			}
		}
		
		int x = 0;
		for (DataPoint dataPoint : dataPoints){
			double[] var = {dataPoint.getStatus()};
			expectedStatus.add(var);
		}
		
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMinimumFractionDigits(4);


		for (int i=0;i<10000;i++) {
			for (int j=0;j<dataPoints.size();j++) {
				network.computeOutputs(dataPoints.get(j).toArray());
				network.calcError(expectedStatus.get(j));
				network.learn();
			}
			
			if (i % 100 == 0){
				System.out.println( "Trial #" + i + ",Error:" +
	             percentFormat .format(network.getError(dataPoints.size())) );
				
			}
	  }
		
		System.out.println("Recall:" );
		double[] output = network.computeOutputs(oneDataPoint.toArray());
		System.out.println("Result: " + output[0]);
		System.out.println("Expected: " + oneDataPoint.getStatus());
		output = network.computeOutputs(zeroDataPoint.toArray());
		System.out.println("Result: " + output[0]);
		System.out.println("Expected: " + zeroDataPoint.getStatus());
	}
	
	public static void loadProps(){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(PROPS_LOCATION);

			// load a properties file
			prop.load(input);

			trainingData = new File(prop.getProperty("training.data.location"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
