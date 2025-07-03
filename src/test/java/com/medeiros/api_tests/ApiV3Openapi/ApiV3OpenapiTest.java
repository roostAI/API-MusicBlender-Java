
package com.medeiros.api_tests;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiV3OpenapiTest {

	@Test
	void testAll() {
		String petapihost = System.getenv().get("PET_API_HOST");
		String petauthtoken = System.getenv().get("PET_AUTH_TOKEN");
		Results results = Runner.path("src/test/java/com/medeiros/api_tests/ApiV3Openapi")
			.systemProperty("PET_API_HOST", petapihost)
			.systemProperty("PET_AUTH_TOKEN", petauthtoken)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
