package com.neural.net;

import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.neural.net.gui.NeuralInterface;
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
	
	public void initializeTraining(File trainingData, NeuralInterface ui) throws Exception{
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
				ui.updateStatusBar(i/100);
				System.out.println( "Trial #" + i + ",Error:" +
	             percentFormat .format(network.getError(trainingDataPoints.size())) );
				
			}
		}
		ui.updateStatusBar(0);
	}
	
	public List<DataPoint> processInput(File inputData) throws Exception{
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
