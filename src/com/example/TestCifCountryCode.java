package com.example;

import com.couchbase.client.java.json.JsonObject;
import java.util.*;

public class TestCifCountryCode {

	public static void main(String[] args) {

		// ----- Dummy List<JsonObject> -----
		List<JsonObject> phoneRefDetails = new ArrayList<>();

		phoneRefDetails.add(JsonObject.create().put("ORGKEY", "CIF1001").put("PHONENOCOUNTRYCODE", "91"));

		phoneRefDetails.add(JsonObject.create().put("ORGKEY", "CIF1001").put("PHONENOCOUNTRYCODE", "44"));

		phoneRefDetails.add(JsonObject.create().put("ORGKEY", "CIF1002").put("PHONENOCOUNTRYCODE", "65"));

		phoneRefDetails.add(JsonObject.create().put("ORGKEY", "CIF1001").put("PHONENOCOUNTRYCODE", "971"));

		phoneRefDetails.add(JsonObject.create().put("ORGKEY", "CIF1002").put("PHONENOCOUNTRYCODE", "1"));

		Map<String, List<Integer>> result = getCifListFromPhoneRefDetails(phoneRefDetails);

		System.out.println("OUTPUT:");
		result.forEach((key, value) -> {
			System.out.println(key + " => " + value);
		});
	}

	private static Map<String, List<Integer>> getCifListFromPhoneRefDetails(List<JsonObject> phoneRefDetails) {

		Map<String, List<Integer>> cifList = new HashMap<>();

		for (int i = 0; i < phoneRefDetails.size(); i++) {

			String cifId = phoneRefDetails.get(i).getString("ORGKEY");
			Integer countryCode = Integer.parseInt(phoneRefDetails.get(i).getString("PHONENOCOUNTRYCODE"));

			cifList.computeIfAbsent(cifId, k -> new ArrayList<>()).add(countryCode);
		}

		return cifList;
	}
}
