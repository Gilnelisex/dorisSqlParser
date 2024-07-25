package com.gilnelisex.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class ParseDorisSqlController {

    private final ParseDorisSqlService parseDorisSqlService;

    @GetMapping("/sql")
    public void getDehoopToken(@RequestParam String sql) {
        parseDorisSqlService.parse(sql);
    }
}
