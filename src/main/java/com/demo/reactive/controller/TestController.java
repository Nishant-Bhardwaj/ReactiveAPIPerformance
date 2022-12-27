package com.demo.reactive.controller;


import com.demo.reactive.controller.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/")
public class TestController {

    Logger logger = LogManager.getLogger(TestController.class);

    @Autowired
    TestService testService;

    @GetMapping(path = "/{name}")
    public Mono<String> predictGender(@PathVariable("name") String name){
        Long startTime = System.currentTimeMillis();
        logger.info("API :: START:: "+ startTime);
        Mono<String> response = testService.predictGender(name);
        logger.info("API :: END:: Total Time: "+ (System.currentTimeMillis()-startTime));
        return response;
    }


    @GetMapping(path = "/rest/{name}")
    public ResponseEntity<String> predictGenderRest(@PathVariable("name") String name){
        Long startTime = System.currentTimeMillis();
        logger.info("API :: START:: "+ startTime);
        ResponseEntity<String> response = testService.predictGenderResponse(name);
        logger.info("API :: END:: Total Time: "+ (System.currentTimeMillis()-startTime));
        return response;
    }

    @GetMapping(path = "/hyb/{name}")
    public ResponseEntity<String> predictGenderWeb(@PathVariable("name") String name){
        Long startTime = System.currentTimeMillis();
        logger.info("API :: START:: "+ startTime);
        String response = testService.predictGenderResponseWeb(name).block();
        logger.info("API :: END:: Total Time: "+ (System.currentTimeMillis()-startTime));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
