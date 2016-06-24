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
	
	public static List<DataPoint> normalizeData(List<DataPoint> dataPoints){
		
 		double maxMDVP_Fo_Hz = 0;
 		double minMDVP_Fo_Hz = 500000000;
 		double maxMDVP_Fhi_Hz = 0;
 		double minMDVP_Fhi_Hz = 500000000;
 		double maxMDVP_Flo_Hz = 0;
 		double minMDVP_Flo_Hz = 500000000;
 		double maxMDVP_Jitter_percent = 0;
 		double minMDVP_Jitter_percent = 50000000;
 		double maxMDVP_Jitter_abs = 0;
 		double minMDVP_Jitter_abs = 5000000;
 		double maxMDVP_RAP = 0;
 		double minMDVP_RAP = 5000000;
 		double maxMDVP_PPQ = 0;
 		double minMDVP_PPQ = 5000000;
 		double maxJitter_DDP = 0;
 		double minJitter_DDP = 500000;
 		double maxMDVP_Shimmer = 0;
 		double minMDVP_Shimmer = 5000000;
 		double maxMDVP_Shimmer_dB = 0;
 		double minMDVP_Shimmer_dB = 5000000;
 		double maxShimmer_APQ3 = 0;
 		double minShimmer_APQ3 = 5000000;
 		double maxShimmer_APQ5 = 0;
 		double minShimmer_APQ5 = 5000000;
 		double maxMDVP_APQ = 0;
 		double minMDVP_APQ = 5000000;
		double maxShimmer_DDA = 0;
		double minShimmer_DDA = 50000000;
 		double maxNHR = 0;
 		double minNHR = 5000000;
 		double maxHNR = 0;
 		double minHNR = 5000000;
 		double maxRPDE = 0;
 		double minRPDE = 5000000;
 		double maxDFA = 0;
 		double minDFA = 5000000;
 		double maxspread1 = 0;
 		double minspread1 = 50000000;
 		double maxspread2 = 0;
 		double minspread2 = 50000000;
 		double maxD2 = 0;
 		double minD2 = 5000000;
 		double maxPPE = 0;
 		double minPPE = 5000000;
 		
 		
		for (DataPoint point : dataPoints){
			maxD2 = checkMax(point.getD2(), maxD2);
			minD2 = checkMin(point.getD2(), minD2);
			
			maxDFA = checkMax(point.getDFA(), maxDFA);
			minDFA = checkMin(point.getDFA(), minDFA);
			
			maxHNR = checkMax(point.getHNR(), maxHNR);
			minHNR = checkMin(point.getHNR(), minHNR);
			
			maxJitter_DDP = checkMax(point.getJitter_DDP(), maxJitter_DDP);
			minJitter_DDP = checkMin(point.getJitter_DDP(), minJitter_DDP);
			
			maxMDVP_APQ = checkMax(point.getMDVP_APQ(), maxMDVP_APQ);
			minMDVP_APQ = checkMin(point.getMDVP_APQ(), minMDVP_APQ);
			
			maxMDVP_Fhi_Hz = checkMax(point.getMDVP_Fhi_Hz(), maxMDVP_Fhi_Hz);
			minMDVP_Fhi_Hz = checkMin(point.getMDVP_Fhi_Hz(), minMDVP_Fhi_Hz);
			
			maxMDVP_Flo_Hz = checkMax(point.getMDVP_Flo_Hz(), maxMDVP_Flo_Hz);
			minMDVP_Flo_Hz = checkMin(point.getMDVP_Flo_Hz(), minMDVP_Flo_Hz);
			
			maxMDVP_Fo_Hz = checkMax(point.getMDVP_Fo_Hz(), maxMDVP_Fo_Hz);
			minMDVP_Fo_Hz = checkMin(point.getMDVP_Fo_Hz(), minMDVP_Fo_Hz);
			
			maxMDVP_Jitter_abs = checkMax(point.getMDVP_Jitter_abs(), maxMDVP_Jitter_abs);
			minMDVP_Jitter_abs = checkMin(point.getMDVP_Jitter_abs(), minMDVP_Jitter_abs);
			
			maxMDVP_Jitter_percent = checkMax(point.getMDVP_Jitter_percent(), maxMDVP_Jitter_percent);
			minMDVP_Jitter_percent = checkMin(point.getMDVP_Jitter_percent(), minMDVP_Jitter_percent);
			
			maxMDVP_PPQ = checkMax(point.getMDVP_PPQ(), maxMDVP_PPQ);
			minMDVP_PPQ = checkMin(point.getMDVP_PPQ(), minMDVP_PPQ);
			
			maxMDVP_RAP = checkMax(point.getMDVP_RAP(), maxMDVP_RAP);
			minMDVP_RAP = checkMin(point.getMDVP_RAP(), minMDVP_RAP);
			
			maxMDVP_Shimmer = checkMax(point.getMDVP_Shimmer(), maxMDVP_Shimmer);
			minMDVP_Shimmer = checkMin(point.getMDVP_Shimmer(), minMDVP_Shimmer);
			
			maxMDVP_Shimmer_dB = checkMax(point.getMDVP_Shimmer_dB(), maxMDVP_Shimmer_dB);
			minMDVP_Shimmer_dB = checkMin(point.getMDVP_Shimmer_dB(), minMDVP_Shimmer_dB);
			
			maxNHR = checkMax(point.getNHR(), maxNHR);
			minNHR = checkMin(point.getNHR(), minNHR);
			
			maxPPE = checkMax(point.getPPE(), maxPPE);
			minPPE = checkMin(point.getPPE(), minPPE);
			
			maxRPDE = checkMax(point.getRPDE(), maxRPDE);
			minRPDE = checkMin(point.getRPDE(), minRPDE);
			
			maxShimmer_APQ3 = checkMax(point.getShimmer_APQ3(), maxShimmer_APQ3);
			minShimmer_APQ3 = checkMin(point.getShimmer_APQ3(), minShimmer_APQ3);
			
			maxShimmer_APQ5 = checkMax(point.getShimmer_APQ5(), maxShimmer_APQ5);
			minShimmer_APQ5 = checkMin(point.getShimmer_APQ5(), minShimmer_APQ5);
			
			maxShimmer_DDA = checkMax(point.getShimmer_DDA(), maxShimmer_DDA);
			minShimmer_DDA = checkMin(point.getShimmer_DDA(), minShimmer_DDA);
			
			maxspread1 = checkMax(point.getSpread1(), maxspread1);
			minspread1 = checkMin(point.getSpread1(), minspread1);
			
			maxspread2 = checkMax(point.getSpread2(), maxspread2);
			minspread2 = checkMin(point.getSpread2(), minspread2);
		}
		
		for (DataPoint point : dataPoints){
			point.setD2(normalize(point.getD2(), minD2, maxD2));
			point.setDFA(normalize(point.getDFA(), minDFA, maxDFA));
			point.setHNR(normalize(point.getHNR(), minHNR, maxHNR));
			point.setJitter_DDP(normalize(point.getJitter_DDP(), minJitter_DDP, maxJitter_DDP));
			point.setMDVP_APQ(normalize(point.getMDVP_APQ(), minMDVP_APQ, maxMDVP_APQ));
			point.setMDVP_Fhi_Hz(normalize(point.getMDVP_Fhi_Hz(), minMDVP_Fhi_Hz, maxMDVP_Fhi_Hz));
			point.setMDVP_Flo_Hz(normalize(point.getMDVP_Flo_Hz(), minMDVP_Flo_Hz, maxMDVP_Flo_Hz));
			point.setMDVP_Fo_Hz(normalize(point.getMDVP_Fo_Hz(), minMDVP_Fo_Hz, maxMDVP_Fo_Hz));
			point.setMDVP_Jitter_abs(normalize(point.getMDVP_Jitter_abs(), minMDVP_Jitter_abs, maxMDVP_Jitter_abs));
			point.setMDVP_Jitter_percent(normalize(point.getMDVP_Jitter_percent(), minMDVP_Jitter_percent, maxMDVP_Jitter_percent));
			point.setMDVP_PPQ(normalize(point.getMDVP_PPQ(), minMDVP_PPQ, maxMDVP_PPQ));
			point.setMDVP_RAP(normalize(point.getMDVP_RAP(), minMDVP_RAP, maxMDVP_RAP));
			point.setMDVP_Shimmer(normalize(point.getMDVP_Shimmer(), minMDVP_Shimmer, maxMDVP_Shimmer));
			point.setMDVP_Shimmer_dB(normalize(point.getMDVP_Shimmer_dB(), minMDVP_Shimmer_dB, maxMDVP_Shimmer_dB));
			point.setNHR(normalize(point.getNHR(), minNHR, maxNHR));
			point.setPPE(normalize(point.getPPE(), minPPE, maxPPE));
			point.setRPDE(normalize(point.getRPDE(), minRPDE, maxRPDE));
			point.setShimmer_APQ3(normalize(point.getShimmer_APQ3(), minShimmer_APQ3, maxShimmer_APQ3));
			point.setShimmer_APQ5(normalize(point.getShimmer_APQ5(), minShimmer_APQ5, maxShimmer_APQ5));
			point.setShimmer_DDA(normalize(point.getShimmer_DDA(), minShimmer_DDA, maxShimmer_DDA));
			point.setSpread1(normalize(point.getSpread1(), minspread1, maxspread1));
			point.setSpread2(normalize(point.getSpread2(), minspread2, maxspread2));
		}
		
		return dataPoints;
	}
	
	public static double normalize(double value, double min, double max){
		double result = (value - min)/(max - min);
		
		return result;
	}
	
	public static double checkMin(double data, double min){
		if (data < min){
			return data;
		} else {
			return min;
		}
	}
	
	public static double checkMax(double data, double max){
		if (data > max){
			return data;
		} else {
			return max;
		}
	}
}
