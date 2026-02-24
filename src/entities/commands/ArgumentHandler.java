package entities.commands;

import java.util.ArrayList;
import java.util.List;

import entities.exceptions.QuotesException;

public class ArgumentHandler {
	private List<String> arguments = new ArrayList<>();

	public ArgumentHandler() { 
	}
	
	public ArgumentHandler(List<String> arguments) {
		this.arguments = arguments;
	}
	
	public void addArgument(String arg) {
		arguments.add(arg);
	}
	
	public void removeArgument(String arg) {
		arguments.remove(arg);
	}
	
	public List<String> getArguments() {
		return arguments;
	}

	public String pathParse() {
		int quoteCount = 0;
		for (String s : arguments) {
			if (s.contains("\"")) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '\"') {
						quoteCount++;
					}
				}
			}
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String finalString = null;
		
		if (arguments.size() == 1) {
			stringBuilder.append(String.format("%s", arguments.get(0)));
		} else {
			for (int i = 0; i < arguments.size(); i++) {
				if (i == 0) {
					stringBuilder.append(String.format("%s", arguments.get(i)));
				} else {
					stringBuilder.append(String.format(" %s", arguments.get(i)));
				}
			}
		}
		
		finalString = stringBuilder.toString();
		
		if (quoteCount == 2) {
			finalString = finalString.substring(1, finalString.length() - 1);
			return finalString;
		} else if (quoteCount == 0) {
			return finalString;
		} else {
			throw new QuotesException("Illegal amount of quotes in command argument. Please check your syntax.\n");
		}
	}
	
	public String[] echoParse() {
		int quoteCount = 0;
		for (String s : arguments) {
			if (s.contains("\"")) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '\"') {
						quoteCount++;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String finalString;
		
		for (int i = 0; i < arguments.size(); i++) {
			if (i == 0) {
				sb.append(String.format("%s", arguments.get(i)));
			} else {
				sb.append(String.format(" %s", arguments.get(i)));
			}
		}
		
		finalString = sb.toString();
		String[] finalArray = finalString.split(" > ");
		finalArray[0] = finalArray[0].substring(1, finalArray[0].length() - 1);
		
		if (quoteCount == 2) {
			return finalArray;
		} else {
			throw new QuotesException("Echo can only be used with quotes around the text to be inserted. Please check your syntax.\n");
		}
	}
}
