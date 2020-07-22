# Web UI Automation Test

Web UI Automation BDD project using Cucumber, Serenity and Zalenium Grid

## Running the tests

When you run ```mvn clean verify``` from the command line, all features will run in parallel separate browsers. 
By default, the tests will run using Chrome. You can run them in Firefox by overriding the driver system property.
```sh
mvn verify -Dwebdriver.driver=firefox
``` 

Drivers are located under ``` src/test/resources/webdriver``` directory.

## Reports

The test results will be recorded under ``` target/site/serenity/index.html```  here. 
To see the result, run the below command from root directory after test execution.
``` 
open target/site/serenity/index.html 
``` 

## Grid Parallel Run with Docker
Parallel runs have been implemented with docker container using the Zalenium.
Your machine needs docker to be installed to run the tests with Zalenium. Once docker is installed. Please follow the below steps.
- Pull Zelenium from dockerhub
```
docker pull dosel/zalenium
``` 

- Run it as below
``` 
docker run --rm -ti --name zalenium -p 4444:4444 \
      -e PULL_SELENIUM_IMAGE=true \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/seluser/videos \
      --privileged dosel/zalenium start
``` 
- Now, Zalenium grid is up and readt, you can run the test as below
``` 
mvn verify -Dwebdriver.driver=remote -Dwebdriver.remote.url=http://localhost:4444/wd/hub
``` 

- You can see live stream of the tests running in chrome and firefox from http://localhost:4444/grid/admin/live and after that you can visit Zalenium dashboard http://localhost:4444/dashboard/ to view the test video, logs and results

- To stop the grid
``` 
docker stop zalenium
``` 

## Built With

* [Junit](https://junit.org/junit5/) - Testing framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Selenium Webdriver](https://www.selenium.dev/) - Testing Tool
* [Cucumber](https://cucumber.io/) - Testing Tool
* [Serenity BDD](http://www.thucydides.info/#/) - Test Report Tool
* [Zalenium](https://opensource.zalando.com/zalenium/) - Docker Based Selenium Grid
* [Jackson](https://opensource.zalando.com/zalenium/) - Json Parser

