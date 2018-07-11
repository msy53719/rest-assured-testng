package com.mosy.core.util;

import io.restassured.http.Header;

public class HeaderUtil {
	public static final String COOKIE = "";

	public static Header getHeader() {
		Header header = new Header("Cookie", COOKIE);
		return header;
	}

}
