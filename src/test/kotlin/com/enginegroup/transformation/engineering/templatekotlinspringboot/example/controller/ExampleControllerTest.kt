package com.enginegroup.transformation.engineering.templatekotlinspringboot.example.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class ExampleControllerTest {

    val exampleController = ExampleController();

    @Nested
    inner class Greeting {

        @Test
        fun `returns the expected content`()
        {
            val result1 = exampleController.greeting("Joe Bloggs");

            Assertions.assertEquals("Hello, Joe Bloggs", result1.content)
        }

        @Test
        fun `increments the id`()
        {
            val result1 = exampleController.greeting("Joe Bloggs");
            val result2 = exampleController.greeting("Joe Bloggs");

            Assertions.assertAll(
                    Executable { Assertions.assertEquals(1, result1.id) },
                    Executable { Assertions.assertEquals(2, result2.id) }
            )
        }
    }
}
