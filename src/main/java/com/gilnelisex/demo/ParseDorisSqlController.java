package com.gilnelisex.demo;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class ParseDorisSqlController {

    private final ParseDorisSqlService parseDorisSqlService;

    @PostMapping("/sql")
    public void getDehoopToken(@RequestBody Map<String, String> sql) {
        parseDorisSqlService.parse(sql.get("sql"));
    }
}
