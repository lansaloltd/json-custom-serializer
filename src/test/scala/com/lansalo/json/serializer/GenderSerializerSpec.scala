package com.lansalo.json.serializer

import com.lansalo.model.{Gender, Male}
import org.json4s.JsonAST.JString
import org.json4s.native.Serialization.write
import org.json4s.{DefaultFormats, MappingException}
import org.scalatest.{FlatSpec, MustMatchers}

class GenderSerializerSpec extends FlatSpec with MustMatchers {

  implicit val formats = DefaultFormats + GenderSerializer

  "GenderSerializer" should "deserialize male into the corresponding object" in {
    JString("male").extract[Gender] mustBe Male
  }

  it should "serialize male into json" in {
    write[Gender](Male) mustBe """"male""""
  }

  it should " not serialize unrecognized genders and throw an exception" in {
    intercept[MappingException] {
      JString("bogus").extract[Gender]
    }
  }

}
