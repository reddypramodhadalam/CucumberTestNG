package com.rexel.runners;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty"
        , "html:target/iOSBrowserstack/cucumber"
        , "summary"
        , "me.jvt.cucumber.report.PrettyReports:target/iOSBrowserstack/cucumber-html-reports"}
        ,features = {"src/test/resources"}
        ,glue = {"com.rexel.stepdef"}
        ,dryRun=false
        ,monochrome=true
        //,tags = "@test"
        )
public class BrowserstackIosRunnerTest extends RunnerBase {
}