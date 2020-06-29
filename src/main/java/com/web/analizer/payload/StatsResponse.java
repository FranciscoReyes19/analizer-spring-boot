package com.web.analizer.payload;

public class StatsResponse {
	
	//“count_mutations”:40, “count_no_mutation”💯  “ratio”:0.4
	private int count_mutations;
	private int count_no_mutation;
	private int ratio;
	private String status;
	public StatsResponse(int count_mutations, int count_no_mutation, int ratio,String status) {
		super();
		this.count_mutations = count_mutations;
		this.count_no_mutation = count_no_mutation;
		this.ratio = ratio;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount_mutations() {
		return count_mutations;
	}
	public void setCount_mutations(int count_mutations) {
		this.count_mutations = count_mutations;
	}
	public int getCount_no_mutation() {
		return count_no_mutation;
	}
	public void setCount_no_mutation(int count_no_mutation) {
		this.count_no_mutation = count_no_mutation;
	}
	public int getRatio() {
		return ratio;
	}
	public void setRatio(int ratio) {
		this.ratio = ratio;
	}
	
	

}
