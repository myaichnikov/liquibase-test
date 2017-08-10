package com.example.liquitest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DataManagementController {

    public static final String DATA_MGMT_ENDPOINT = "/management/data";

    @Autowired
    private DataManagementService service;

    @PostMapping(DATA_MGMT_ENDPOINT)
    public ResponseEntity<Object> applyDataMigrationScript(@RequestParam("script") String script) {
        service.applyScript(script);
        return ResponseEntity.ok().build();
    }
}
