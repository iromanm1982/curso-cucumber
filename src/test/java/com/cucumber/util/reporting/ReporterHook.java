package com.cucumber.util.reporting;

import com.cucumber.models.ScenarioExecutionInfo;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ReporterHook {

    private static final String ELASTIC_SEARCH_URL = "http://localhost:9200/automation/suite";
    private static final String executionId = "46683840-a7a4-4ea9-b979-419dec84a739";

    @After
    public void reportFinalScenarioStatus(Scenario scenario) {
        ScenarioExecutionInfo scenarioExecutionInfo = new ScenarioExecutionInfo();
        scenarioExecutionInfo.setExecutionId(executionId);
        scenarioExecutionInfo.setExecutionId(scenario.getId());
        scenarioExecutionInfo.setName(scenario.getName());
        scenarioExecutionInfo.setStatus(scenario.getStatus().toString());

        RestAssured
                .given()
                .body(scenarioExecutionInfo)
                .contentType(ContentType.JSON)
                .when()
                .post(ELASTIC_SEARCH_URL);

    }

}
