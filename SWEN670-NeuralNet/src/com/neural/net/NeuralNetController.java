package com.neural.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.neural.net.model.DataPoint;
import com.neural.net.parser.DataParser;

public class NeuralNetController {
	private List<DataPoint> trainingDataPoints;
	private List<DataPoint> originalTrainingDataPoints;
	private List<DataPoint> inputDataPoints;
	private List<double[]> expectedStatus;
	private Network network;
	
	public NeuralNetController() {
		network = new Network(22, 22, 1, 0.7, 0.9);
		expectedStatus = new ArrayList<double[]>();
	}
	
	public void initializeTraining(File trainingData) throws Exception{
		
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMinimumFractionDigits(4);
		
		trainingDataPoints = DataParser.parseDataFile(trainingData);
		originalTrainingDataPoints = DataParser.parseDataFile(trainingData);
		trainingDataPoints = DataParser.normalizeData(trainingDataPoints, trainingDataPoints);
		
		for (DataPoint dataPoint : trainingDataPoints){
			double[] var = {dataPoint.getStatus()};
			expectedStatus.add(var);
		}
		
		for (int i=0;i<10000;i++) {
			for (int j=0;j<trainingDataPoints.size();j++) {
				network.computeOutputs(trainingDataPoints.get(j).toArray());
				network.calcError(expectedStatus.get(j));
				network.learn();
			}
			
			if (i % 100 == 0){
				System.out.println( "Trial #" + i + ",Error:" +
	             percentFormat .format(network.getError(trainingDataPoints.size())) );
				
			}
		}
		
		DataPoint oneDataPoint = null;
		DataPoint zeroDataPoint = null;
		
		for (DataPoint dataPoint : trainingDataPoints){
			if (dataPoint.getStatus() == 1){
				oneDataPoint = dataPoint;
			} else if (dataPoint.getStatus() == 0){
				zeroDataPoint = dataPoint;
			}
		}
		
		System.out.println("Recall:" );
		double[] output = network.computeOutputs(oneDataPoint.toArray());
		System.out.println("Result: " + output[0]);
		System.out.println("Expected: " + oneDataPoint.getStatus());
		output = network.computeOutputs(zeroDataPoint.toArray());
		System.out.println("Result: " + output[0]);
		System.out.println("Expected: " + zeroDataPoint.getStatus());
		
		System.out.println("-----");
		
		List<DataPoint> test = DataParser.parseDataFile(new File("C:\\Users\\hufcat05\\Documents\\input-data.csv"));
		List<DataPoint> fullSet = new ArrayList<DataPoint>();
		fullSet.addAll(originalTrainingDataPoints);
		fullSet.addAll(test);
		test = DataParser.normalizeData(fullSet, test);
		
		for (DataPoint point : test){
			double[] testOut = network.computeOutputs(point.toArray());
			System.out.println("Result: " + testOut[0]);
			System.out.println("Expected: " + point.getStatus());
		}
	}
	
	public List<DataPoint> processInput(File inputData){
		inputDataPoints = DataParser.parseDataFile(inputData);
		
		List<DataPoint> fullSet = new ArrayList<DataPoint>();
		fullSet.addAll(originalTrainingDataPoints);
		fullSet.addAll(inputDataPoints);
		
		inputDataPoints = DataParser.normalizeData(fullSet, inputDataPoints);
		
		for (DataPoint point : inputDataPoints){
			double[] output = network.computeOutputs(point.toArray());
			point.setResult(output[0]);
		}
		return inputDataPoints;
	}

}
