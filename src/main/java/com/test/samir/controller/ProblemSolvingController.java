package com.test.samir.controller;

import com.test.samir.model.dto.request.ProblemSolvingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProblemSolvingController {
    @PostMapping(value = "/problem-solving")
    public ResponseEntity<Object> sumOfEven(@RequestBody ProblemSolvingRequest req) {
        Integer sum = 0;
        for (Integer num : req.getNumbers()) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        Map<String, Integer> response = new HashMap<>();
        response.put("sum of all even numbers", sum);
        return ResponseEntity.ok().body(response);
    }
}
