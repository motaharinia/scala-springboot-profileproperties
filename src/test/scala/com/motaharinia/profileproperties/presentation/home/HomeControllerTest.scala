package com.motaharinia.profileproperties.presentation.home

import java.util.Collections

import org.junit.jupiter.api.TestInstance
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.{HttpEntity, HttpHeaders, HttpMethod, HttpStatus, MediaType}
import org.springframework.test.context.{ActiveProfiles, TestContextManager}
import org.scalatest.Assertions._
import org.springframework.util.ObjectUtils

//@RunWith(classOf[SpringRunner])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(Array("dev"))
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ContextConfiguration(
//  locations = Array("com.motaharinia"),
//  loader = classOf[AnnotationConfigContextLoader])
class HomeControllerTest extends AnyFunSuite with BeforeAndAfter with BeforeAndAfterAll {

  @LocalServerPort
  val port: Integer = null

  @Autowired
  var restTemplate: TestRestTemplate = _

  new TestContextManager(this.getClass).prepareTestInstance(this)

  override protected def beforeAll(): Unit = println("beforeAll")

  override protected def afterAll(): Unit = println("afterAll")

  before {
    println("before")
  }

  after {
    println("after")
  }

  test("test1") {
//    try {
      val uri = "http://localhost:" + port;

      // build the request
      val headers = new HttpHeaders
      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      val entity = new HttpEntity;
      println("restTemplate", restTemplate)
      val response = restTemplate.exchange(uri, HttpMethod.GET, entity, classOf[String]);
      assert(!ObjectUtils.isEmpty(response))
      assert(response.getStatusCodeValue().equals(HttpStatus.OK.value()))
      assert(!ObjectUtils.isEmpty(response.getBody()))
      val responseString = response.getBody()
      println(responseString)
      assert(responseString.equalsIgnoreCase("scala-springboot-profileproperties"))
//    } catch {
//      case ex: Exception => fail(ex.toString())
//    }
  }
  test("test2") {
    println("test2")
    assert(Set.empty.size == 0)
  }

  test("test3") {
    println("test3")
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }

}
