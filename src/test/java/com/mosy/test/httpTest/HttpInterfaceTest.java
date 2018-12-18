package com.mosy.test.httpTest;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.specification.RequestSpecification;
import com.alibaba.fastjson.JSONObject;
import static org.junit.Assert.assertThat;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpInterfaceTest {

	private final static String url = "http://127.0.0.1:8081";
	private final static String getPath = "/query/all";
	private final static String postPath = "/addFood";
	private Response response = null;

	@Test
	public void PostTest() {
		RequestSpecification request = given().header("Content-Type", "application/json").body(MapToJson());
		response = request.post(url + postPath);
		log.debug(":", response.getBody().asString());
		log.debug(":", response.getBody().prettyPrint());
		assertThat(response.getBody().prettyPrint(), matchesJsonSchemaInClasspath("schema\\json\\base.json"));
	}

	@Test
	public void GetTest() {
		RequestSpecification request = given();// header("Content-Type", "application/json");
		response = request.get(url + getPath);
		log.debug("get返回", response.getBody().prettyPrint());
	}

	public static JSONObject MapToJson() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("name", "西红柿");
		map.put("type", "水果蔬菜");
		map.put("colour", "黄红色");
		JSONObject json = (JSONObject) JSONObject.toJSON(map);
		return json;
	}

}
