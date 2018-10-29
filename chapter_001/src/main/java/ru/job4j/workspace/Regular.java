package ru.job4j.workspace;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

//http://proglang.su/java/regular-expressions
public class Regular {

    public boolean checkItemNameForAdultWords(String itemName) {
        return itemName != null && itemName.matches("(?i).*?(Masturbator|Dildo|Vibrator).*?");
    }

    public boolean checkItemNameForPaymentWords(String itemName) {
        List<String> paymentWords = asList("Price","Difference", "Payment", "Extra", "Costs");
        itemName = itemName.toLowerCase();
        for (String fistword: paymentWords) {
            if (itemName.contains(fistword.toLowerCase())) {
                for (String secondWord: paymentWords) {
                    if (itemName.contains(secondWord.toLowerCase()) && (!fistword.equals(secondWord))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkItemNameForPaymentPairWords2(String itemName) {

        itemName = itemName.toLowerCase();

        HashMap <String, String> paymentPairWords = new HashMap<String, String>();
        paymentPairWords.put("price", "difference");
        paymentPairWords.put("payment", "difference");
        paymentPairWords.put("extra", "costs");

        for (Map.Entry<String, String> pair : paymentPairWords.entrySet()) {
	        int firstWordIndex = itemName.indexOf(pair.getKey());
	        if (firstWordIndex != -1) {
	        	int secondWordIndex = itemName.indexOf(pair.getValue(), firstWordIndex);
		        if (secondWordIndex != -1) {
			        return true;
		        }
	        }
        }
	    return false;
    }

	public boolean checkItemNameForPaymentPairWords(String itemName) {

		Pattern p = Pattern.compile("^.*?\\bPrice\\b.*?\\bDifference\\b.*?$|^.*?\\bPayment\\b.*?\\bDifference\\b.*?$|^.*?\\bExtra\\b.*?\\bCosts\\b.*?$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(itemName);

		return m.find();
	}

	/*
	private static boolean findByMap(String item) {
		Map<String, String> paymentWords = new HashMap<String, String>();
		paymentWords.put("Price", "Difference");
		paymentWords.put("Payment", "Difference");
		paymentWords.put("Extra", "Costs");

		for (Map.Entry<String, String> entry : paymentWords.entrySet()) {
			if (StringUtils.containsIgnoreCase(entry.getKey(), item)
					&& StringUtils.containsIgnoreCase(entry.getValue(), item)) {
				return true;
			}
		}
		return false;
	}
	*/

}
