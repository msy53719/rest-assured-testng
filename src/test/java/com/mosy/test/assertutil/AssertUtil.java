package com.mosy.test.assertutil;

import java.util.Map;
import java.util.Map.Entry;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;

public class AssertUtil {

	public static void assertResToMap(String str, Map<String, String> map) {
		JsonPath jsonpath = new JsonPath(str);
		for (Entry<String, String> entery : map.entrySet()) {
			Assert.assertEquals( jsonpath.getString(entery.getKey()),entery.getValue());
		//	Assert.assertEquals(actual, jsonpath.get(path)));
		}
	}
}