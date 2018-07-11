package com.mosy.core.util;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendRequestUtil {

	public static Response getResponse(Header header, ContentType contenttype, Map<String, Object> reqParam,
			String url) {
		if (null != header) {
			RequestSpecification request = given().header(header).contentType(contenttype).params(reqParam);
			Response response = request.post(url);
			return response;
		} else {
			RequestSpecification request = given().contentType(contenttype).params(reqParam);
			Response response = request.post(url);
			return response;
		}

	}

}
