package com.neural.net.model;

public class DataPointFactory {
	
	public static DataPoint generateDataPoint(String name, double mDVP_Fo_Hz, double mDVP_Fhi_Hz,
			double mDVP_Flo_Hz, double mDVP_Jitter_percent,
			double mDVP_Jitter_abs, double mDVP_RAP, double mDVP_PPQ,
			double jitter_DDP, double mDVP_Shimmer, double mDVP_Shimmer_dB,
			double shimmer_APQ3, double shimmer_APQ5, double mDVP_APQ,
			double shimmer_DDA, double nHR, double hNR, int status,
			double rPDE, double dFA, double spread1, double spread2, double d2,
			double pPE){
		
		
		return new DataPoint(name, mDVP_Fo_Hz, mDVP_Fhi_Hz, mDVP_Flo_Hz, mDVP_Jitter_percent,
				mDVP_Jitter_abs, mDVP_RAP, mDVP_PPQ, jitter_DDP, mDVP_Shimmer, mDVP_Shimmer_dB,
				shimmer_APQ3, shimmer_APQ5, mDVP_APQ, shimmer_DDA, nHR, hNR, status, rPDE, dFA,
				spread1, spread2, d2, pPE);
	}

}
