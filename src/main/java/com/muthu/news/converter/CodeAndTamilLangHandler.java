package com.muthu.news.converter;

public class CodeAndTamilLangHandler {

	public String tamilToUnicode(String input) {
		StringBuilder convertedUnicode = new StringBuilder();

		for (char c : input.toCharArray()) {
			convertedUnicode.append("\\u").append(Integer.toHexString((int) c));
		}

		return convertedUnicode.toString();
	}

	public String unicodeToTamil(String input) {
		String inputStr = input.split(" ")[0];
		inputStr = inputStr.replace("\\", "");
		String[] inputArr = inputStr.split("u");
		String convertedTamil = "";
		for (int i = 1; i < inputArr.length; i++) {
			int hexVal = Integer.parseInt(inputArr[i], 16);
			convertedTamil += (char) hexVal;
		}
		return convertedTamil;
	}

	public String backSlashReplacer(String input) {
		return input.replaceAll("\\\\", "PAP");
	}

	public String papWordReplacer(String input) {
		return input.replaceAll("PAP", "\\\\");
	}

}
