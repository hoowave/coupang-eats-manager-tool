package com.coupang_eats_gdmotors.hoowave.tools;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ToolsApiController {

    @GetMapping("/tools")
    public ResponseEntity<String> toolsAccess() {
        return ResponseEntity.ok("Access granted to tools page");
    }

}