package com.example.RunnerCukeTest;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)


@CucumberOptions (features="src//test//java//Resources",
        glue = "steps",

dryRun = false,
       monochrome = true,
       plugin = {"pretty",
               "html:target\\test-report\\report-html",
               "json:target\\test-report\\report-json.json",
               "junit:target\\test-report\\report-xml.xml"},
       strict = false,

      //format = {"json:target\\cucumber.json", "html:targe\\site\\cucumber-pretty"},

      snippets = SnippetType.CAMELCASE
      ,tags = {"@wip"}
)









public class StigRunnerClass {
}
