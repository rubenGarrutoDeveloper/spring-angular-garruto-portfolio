package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.entity.Hello;
import com.garruto.portfolio_backend.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public ResponseEntity<List<Hello>> getAllHello() {
        log.info("GET /api/v1/hello - Fetching all hello records");

        List<Hello> hellos = helloService.findAll();

        log.info("Found {} hello records", hellos.size());
        log.debug("Hello records: {}", hellos);

        return ResponseEntity.ok(hellos);
    }
}