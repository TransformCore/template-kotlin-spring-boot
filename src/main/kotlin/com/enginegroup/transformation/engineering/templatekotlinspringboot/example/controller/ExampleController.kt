package com.enginegroup.transformation.engineering.templatekotlinspringboot.example.controller

import com.enginegroup.transformation.engineering.templatekotlinspringboot.example.dto.ExampleResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class ExampleController {

    val counter = AtomicLong()

    @GetMapping("/")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            ExampleResult(counter.incrementAndGet(), "Hello, $name")

}
