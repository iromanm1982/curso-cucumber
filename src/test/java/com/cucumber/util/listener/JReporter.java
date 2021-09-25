package com.cucumber.util.listener;

import com.cucumber.models.ScenarioExecutionInfo;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JReporter implements ConcurrentEventListener {
    private static final String ELASTIC_SEARCH_URL = "http://localhost:9200/automation/suite";
    private static final String executionId = "46683840-a7a4";



    private void onTestCaseFinished(final TestStepFinished event) {
        ScenarioExecutionInfo scenarioExecutionInfo = new ScenarioExecutionInfo();
        scenarioExecutionInfo.setExecutionId(executionId);
        scenarioExecutionInfo.setExecutionId(event.getTestCase().getId().toString());
        scenarioExecutionInfo.setName(event.getTestCase().getName());
        scenarioExecutionInfo.setStatus(event.getResult().getStatus().toString());

        RestAssured
                .given()
                .body(scenarioExecutionInfo)
                .contentType(ContentType.JSON)
                .when()
                .post(ELASTIC_SEARCH_URL);

    }


    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::onTestCaseFinished);
    }
}
