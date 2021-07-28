package org.example;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzz {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fizzbuzz(@RequestParam String entry) {
        if (ObjectUtils.isEmpty(entry)) {
            return ResponseEntity.ok(resultOfFirst100());
        } else {
            return ResponseEntity.ok(resutlOfSpecificCondition(Integer.valueOf(entry)));
        }
    }

    private boolean isMultipleOf(Integer entry, Integer base) {
        return entry % base == 0;
    }
    
    private String resutlOfSpecificCondition(Integer entry) {
        StringBuilder result = new StringBuilder();
        if (isMultipleOf(entry, 3)) {
            result.append("fizz");
        }
        if (isMultipleOf(entry, 5)) {
            result.append("buzz");
        }
        return (result.length()>0)?result.toString():entry.toString();
    }

    private String[] resultOfFirst100() {
        int i = 1;
        List<String> results = new ArrayList<String>(100);
        while(i<=100) {
            results.add(resutlOfSpecificCondition(i++));
        }
        return results.toArray(new String[0]);
    }
}
