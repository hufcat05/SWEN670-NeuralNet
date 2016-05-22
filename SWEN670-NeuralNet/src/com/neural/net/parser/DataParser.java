package com.neural.net.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.neural.net.model.DataPoint;
import com.neural.net.model.DataPointFactory;

public class DataParser {
	
	public static List<DataPoint> parseDataFile(File file){
		List<DataPoint> dataPoints = new ArrayList<DataPoint>();
		BufferedReader br = null;
		String line = "";

		try {

			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {

			  DataPoint dataPoint = parseDataString(line);
			  dataPoints.add(dataPoint);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return dataPoints;
	}
	
	public static DataPoint parseDataString(String data){
		String[] dataArray = data.split(",");
		
		DataPoint dataPoint = DataPointFactory.generateDataPoint(dataArray[0], Double.parseDouble(dataArray[1]), 
				Double.parseDouble(dataArray[2]), Double.parseDouble(dataArray[3]), Double.parseDouble(dataArray[4]),
				Double.parseDouble(dataArray[5]), Double.parseDouble(dataArray[6]), Double.parseDouble(dataArray[7]),
				Double.parseDouble(dataArray[8]), Double.parseDouble(dataArray[9]), Double.parseDouble(dataArray[10]),
				Double.parseDouble(dataArray[11]), Double.parseDouble(dataArray[12]), Double.parseDouble(dataArray[13]),
				Double.parseDouble(dataArray[14]), Double.parseDouble(dataArray[15]), Double.parseDouble(dataArray[16]),
				Integer.parseInt(dataArray[17]), Double.parseDouble(dataArray[18]), Double.parseDouble(dataArray[19]),
				Double.parseDouble(dataArray[20]), Double.parseDouble(dataArray[21]), Double.parseDouble(dataArray[22]),
				Double.parseDouble(dataArray[23]));
		
		
		return dataPoint;
	}

}
