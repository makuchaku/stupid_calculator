package com.makulabs.models;


public class CalculatorModel {

	public String process(String input) {
		String output = "0";
		
		if(CalculatorModel.isWithOperator(input, "+") != false)
			output = add(input.split("\\+", 2));
		else if(CalculatorModel.isWithOperator(input, "-") != false)
			output = subtract(input.split("\\-", 2));
		else if(CalculatorModel.isWithOperator(input, "*") != false)
			output = multiply(input.split("\\*", 2));
		else if(CalculatorModel.isWithOperator(input, "/") != false)
			output = divide(input.split("\\/", 2));		
		
		return output;
	}
	
	
	// Returns true if the input string has the operator in it
	public static boolean isWithOperator(String input, String op) {
		return input.indexOf(op) == -1 ? false : true;
	}
	
	// Returns true if any operator is found in the string
	public static boolean isWithAnyOperator(String input) {
		return CalculatorModel.isWithOperator(input, "+") ||
				CalculatorModel.isWithOperator(input, "-") ||
				CalculatorModel.isWithOperator(input, "*") ||
				CalculatorModel.isWithOperator(input, "/");
	}
	
	public String add(String[] inputs) {
		return convertToIntIfRequired((Float.parseFloat(inputs[0]) + Float.parseFloat(inputs[1])));		
	}
	
	public String subtract(String[] inputs) {
		return convertToIntIfRequired((Float.parseFloat(inputs[0]) - Float.parseFloat(inputs[1])));
	}
	
	public String multiply(String[] inputs) {
		return convertToIntIfRequired((Float.parseFloat(inputs[0]) * Float.parseFloat(inputs[1])));
	}
	
	public String divide(String[] inputs) {
		return convertToIntIfRequired((Float.parseFloat(inputs[0]) / Float.parseFloat(inputs[1])));
	}
	
	// Converts 1.0 to "1"
	public String convertToIntIfRequired(Float number) {
		if(number == Math.ceil((double) number))	// if number is 1.0 but not 1.1
			return number.toString().split("\\.")[0];
		else
			return number.toString();
	}
	
}
