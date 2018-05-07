package com.lansalo.json.serializer

import com.lansalo.model.Age
import org.json4s.JsonAST.JInt
import org.json4s.DefaultFormats
import org.scalatest.{FlatSpec, MustMatchers}

class AgeSerializerSpec extends FlatSpec with MustMatchers {

  implicit val formats = DefaultFormats + AgeSerializer

  "AgeSerializer" should "deserialize 22 into the corresponding object" in {
    JInt(22).extract[Age] mustBe new Age(22)
  }

}
