package com.neural.net.model;

public class DataPoint {
	private String name;
	private double MDVP_Fo_Hz;
	private double MDVP_Fhi_Hz;
	private double MDVP_Flo_Hz;
	private double MDVP_Jitter_percent;
	private double MDVP_Jitter_abs;
	private double MDVP_RAP;
	private double MDVP_PPQ;
	private double Jitter_DDP;
	private double MDVP_Shimmer;
	private double MDVP_Shimmer_dB;
	private double Shimmer_APQ3;
	private double Shimmer_APQ5;
	private double MDVP_APQ;
	private double Shimmer_DDA;
	private double NHR;
	private double HNR;
	private int status;
	private double RPDE;
	private double DFA;
	private double spread1;
	private double spread2;
	private double D2;
	private double PPE;
	private double result;
	
	public DataPoint(String name, double mDVP_Fo_Hz, double mDVP_Fhi_Hz,
			double mDVP_Flo_Hz, double mDVP_Jitter_percent,
			double mDVP_Jitter_abs, double mDVP_RAP, double mDVP_PPQ,
			double jitter_DDP, double mDVP_Shimmer, double mDVP_Shimmer_dB,
			double shimmer_APQ3, double shimmer_APQ5, double mDVP_APQ,
			double shimmer_DDA, double nHR, double hNR, int status,
			double rPDE, double dFA, double spread1, double spread2, double d2,
			double pPE) {
		this.name = name;
		MDVP_Fo_Hz = mDVP_Fo_Hz;
		MDVP_Fhi_Hz = mDVP_Fhi_Hz;
		MDVP_Flo_Hz = mDVP_Flo_Hz;
		MDVP_Jitter_percent = mDVP_Jitter_percent;
		MDVP_Jitter_abs = mDVP_Jitter_abs;
		MDVP_RAP = mDVP_RAP;
		MDVP_PPQ = mDVP_PPQ;
		Jitter_DDP = jitter_DDP;
		MDVP_Shimmer = mDVP_Shimmer;
		MDVP_Shimmer_dB = mDVP_Shimmer_dB;
		Shimmer_APQ3 = shimmer_APQ3;
		Shimmer_APQ5 = shimmer_APQ5;
		MDVP_APQ = mDVP_APQ;
		Shimmer_DDA = shimmer_DDA;
		NHR = nHR;
		HNR = hNR;
		this.status = status;
		RPDE = rPDE;
		DFA = dFA;
		this.spread1 = spread1;
		this.spread2 = spread2;
		D2 = d2;
		PPE = pPE;
	}

	public String getName() {
		return name;
	}

	public double getMDVP_Fo_Hz() {
		return MDVP_Fo_Hz;
	}

	public double getMDVP_Fhi_Hz() {
		return MDVP_Fhi_Hz;
	}

	public double getMDVP_Flo_Hz() {
		return MDVP_Flo_Hz;
	}

	public double getMDVP_Jitter_percent() {
		return MDVP_Jitter_percent;
	}

	public double getMDVP_Jitter_abs() {
		return MDVP_Jitter_abs;
	}

	public double getMDVP_RAP() {
		return MDVP_RAP;
	}

	public double getMDVP_PPQ() {
		return MDVP_PPQ;
	}

	public double getJitter_DDP() {
		return Jitter_DDP;
	}

	public double getMDVP_Shimmer() {
		return MDVP_Shimmer;
	}

	public double getMDVP_Shimmer_dB() {
		return MDVP_Shimmer_dB;
	}

	public double getShimmer_APQ3() {
		return Shimmer_APQ3;
	}

	public double getShimmer_APQ5() {
		return Shimmer_APQ5;
	}

	public double getMDVP_APQ() {
		return MDVP_APQ;
	}

	public double getShimmer_DDA() {
		return Shimmer_DDA;
	}

	public double getNHR() {
		return NHR;
	}

	public double getHNR() {
		return HNR;
	}

	public int getStatus() {
		return status;
	}

	public double getRPDE() {
		return RPDE;
	}

	public double getDFA() {
		return DFA;
	}

	public double getSpread1() {
		return spread1;
	}

	public double getSpread2() {
		return spread2;
	}

	public double getD2() {
		return D2;
	}

	public double getPPE() {
		return PPE;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMDVP_Fo_Hz(double mDVP_Fo_Hz) {
		MDVP_Fo_Hz = mDVP_Fo_Hz;
	}

	public void setMDVP_Fhi_Hz(double mDVP_Fhi_Hz) {
		MDVP_Fhi_Hz = mDVP_Fhi_Hz;
	}

	public void setMDVP_Flo_Hz(double mDVP_Flo_Hz) {
		MDVP_Flo_Hz = mDVP_Flo_Hz;
	}

	public void setMDVP_Jitter_percent(double mDVP_Jitter_percent) {
		MDVP_Jitter_percent = mDVP_Jitter_percent;
	}

	public void setMDVP_Jitter_abs(double mDVP_Jitter_abs) {
		MDVP_Jitter_abs = mDVP_Jitter_abs;
	}

	public void setMDVP_RAP(double mDVP_RAP) {
		MDVP_RAP = mDVP_RAP;
	}

	public void setMDVP_PPQ(double mDVP_PPQ) {
		MDVP_PPQ = mDVP_PPQ;
	}

	public void setJitter_DDP(double jitter_DDP) {
		Jitter_DDP = jitter_DDP;
	}

	public void setMDVP_Shimmer(double mDVP_Shimmer) {
		MDVP_Shimmer = mDVP_Shimmer;
	}

	public void setMDVP_Shimmer_dB(double mDVP_Shimmer_dB) {
		MDVP_Shimmer_dB = mDVP_Shimmer_dB;
	}

	public void setShimmer_APQ3(double shimmer_APQ3) {
		Shimmer_APQ3 = shimmer_APQ3;
	}

	public void setShimmer_APQ5(double shimmer_APQ5) {
		Shimmer_APQ5 = shimmer_APQ5;
	}

	public void setMDVP_APQ(double mDVP_APQ) {
		MDVP_APQ = mDVP_APQ;
	}

	public void setShimmer_DDA(double shimmer_DDA) {
		Shimmer_DDA = shimmer_DDA;
	}

	public void setNHR(double nHR) {
		NHR = nHR;
	}

	public void setHNR(double hNR) {
		HNR = hNR;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setRPDE(double rPDE) {
		RPDE = rPDE;
	}

	public void setDFA(double dFA) {
		DFA = dFA;
	}

	public void setSpread1(double spread1) {
		this.spread1 = spread1;
	}

	public void setSpread2(double spread2) {
		this.spread2 = spread2;
	}

	public void setD2(double d2) {
		D2 = d2;
	}

	public void setPPE(double pPE) {
		PPE = pPE;
	}
	
	public void setResult(double result) {
		this.result = result;
	}
	
	public double getResult(){
		return result;
	}

	@Override
	public String toString() {
		return "DataPoint [name=" + name + ", MDVP_Fo_Hz=" + MDVP_Fo_Hz
				+ ", MDVP_Fhi_Hz=" + MDVP_Fhi_Hz + ", MDVP_Flo_Hz="
				+ MDVP_Flo_Hz + ", MDVP_Jitter_percent=" + MDVP_Jitter_percent
				+ ", MDVP_Jitter_abs=" + MDVP_Jitter_abs + ", MDVP_RAP="
				+ MDVP_RAP + ", MDVP_PPQ=" + MDVP_PPQ + ", Jitter_DDP="
				+ Jitter_DDP + ", MDVP_Shimmer=" + MDVP_Shimmer
				+ ", MDVP_Shimmer_dB=" + MDVP_Shimmer_dB + ", Shimmer_APQ3="
				+ Shimmer_APQ3 + ", Shimmer_APQ5=" + Shimmer_APQ5
				+ ", MDVP_APQ=" + MDVP_APQ + ", Shimmer_DDA=" + Shimmer_DDA
				+ ", NHR=" + NHR + ", HNR=" + HNR + ", status=" + status
				+ ", RPDE=" + RPDE + ", DFA=" + DFA + ", spread1=" + spread1
				+ ", spread2=" + spread2 + ", D2=" + D2 + ", PPE=" + PPE + ", result=" + result + "]";
	}
	
	public double[] toArray() {
		double[] vars = {MDVP_Fo_Hz,MDVP_Fhi_Hz,MDVP_Flo_Hz,MDVP_Jitter_percent,MDVP_Jitter_abs,MDVP_RAP,MDVP_PPQ,Jitter_DDP,MDVP_Shimmer,MDVP_Shimmer_dB,
		     			Shimmer_APQ3,Shimmer_APQ5,MDVP_APQ,Shimmer_DDA,NHR,HNR,RPDE,DFA,spread1,spread2,D2,PPE}; 
		return vars; 
		
	}
	
}
