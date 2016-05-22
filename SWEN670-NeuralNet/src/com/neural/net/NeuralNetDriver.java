package com.neural.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.neural.net.model.DataPoint;
import com.neural.net.parser.DataParser;

public class NeuralNetDriver {
	private static final String PROPS_LOCATION = "conf/neural-net.properties";
	
	private static File trainingData;
	private static List<DataPoint> dataPoints;

	public static void main(String[] args) {
		loadProps();
		
		dataPoints = DataParser.parseDataFile(trainingData);
		
		
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
