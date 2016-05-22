package com.neural.net;

import java.util.List;

import com.neural.net.model.DataPoint;

public abstract class NeuralNetwork {
	public double predictionThreshold = .99;
	
	abstract void trainNetwork(List<DataPoint> dataPoints);
	abstract double classifyDataPoint(DataPoint dataPoint);
}
