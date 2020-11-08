package com.motaharinia.profileproperties.presentation.home

import java.util.Collections

import org.junit.jupiter.api.{Test, TestInstance}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.{HttpEntity, HttpHeaders, HttpMethod, HttpStatus, MediaType}
import org.springframework.test.context.{ActiveProfiles, TestContextManager}
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(Array("dev"))
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomeController2Test {

  new TestContextManager(this.getClass).prepareTestInstance(this)

    @LocalServerPort
    val port: Integer = null

    @Autowired
    var restTemplate: TestRestTemplate = _

    @Test
    def test1()={
        try {
            val uri = "http://localhost:" + port ;

            // build the request
            val headers = new HttpHeaders
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));
            val entity = new HttpEntity;
            val response = restTemplate.exchange(uri, HttpMethod.GET, entity, classOf[String]);
//            assertThat(response).isNotEqualTo(null)
//            assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value())
//            assertThat(response.getBody()).isNotEqualTo(null)
            val responseString = response.getBody()
            println(responseString)
            assertThat(responseString).isEqualTo("scala-springboot-profileproperties")
        } catch  {
            case ex: Exception => fail(ex.toString())
        }
    }

}
