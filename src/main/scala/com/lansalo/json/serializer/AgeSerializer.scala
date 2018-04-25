package com.lansalo.json.serializer

import com.lansalo.model.Age
import org.json4s.CustomSerializer
import org.json4s.JsonAST.JInt

case object AgeSerializer extends CustomSerializer[Age](format => ( {
  case JInt(age) => new Age(age.intValue)
  },
  {
  case age: Int => JInt(BigInt(age))
}))
