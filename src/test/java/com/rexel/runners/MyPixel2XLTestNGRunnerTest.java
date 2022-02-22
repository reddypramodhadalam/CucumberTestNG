package com.rexel.runners;

import io.cucumber.testng.CucumberOptions;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(
        plugin = {"pretty"
        , "html:target/Pixel2XL/cucumber"
        , "summary"
        , "me.jvt.cucumber.report.PrettyReports:target/Pixel3a/cucumber-html-reports"}
        ,features = {"src/test/resources"}
        ,glue = {"com.rexel.stepdef"}
        ,dryRun=false
        ,monochrome=true
        //,tags = "@test"
        )
public class MyPixel2XLTestNGRunnerTest extends RunnerBase {

}