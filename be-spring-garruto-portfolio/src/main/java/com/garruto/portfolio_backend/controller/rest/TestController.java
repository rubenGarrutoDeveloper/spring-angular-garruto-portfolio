package com.garruto.portfolio_backend.controller.rest;

import com.garruto.portfolio_backend.costant.ApiPaths;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.BASE_PATH+ApiPaths.TEST_PATH)
@Log4j2
public class TestController {

    @GetMapping
    public ResponseEntity<TestDto> test() {
        TestDto testDto = new TestDto(1L, "test name", "test description");
        return ResponseEntity.ok(testDto);
    }

    @Data
    @AllArgsConstructor
    public static class TestDto {
        private Long id;
        private String name;
        private String description;
    }

}
