package com.motaharinia.profileproperties

import org.junit.jupiter.api.TestInstance
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll}
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.{ActiveProfiles, TestContextManager};

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(Array("dev"))
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScalaProfilePropertiesApplicationTests extends AnyFunSuite  with BeforeAndAfter with BeforeAndAfterAll{

    new TestContextManager(this.getClass).prepareTestInstance(this)

    @LocalServerPort
    val randomServerPort: Integer = null

    override protected def beforeAll(): Unit = println("beforeAll")

    override protected def afterAll(): Unit = println("afterAll")

    before {
        println("before")
    }

    after {
        println("after")
    }

    test("test1") {
        println("test1")
        assert(Set.empty.size == 0)
    }

    test("test2") {
        println("test2")
        assertThrows[NoSuchElementException] {
            Set.empty.head
        }
    }

}
