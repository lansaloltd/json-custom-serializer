package com.lansalo.json.serializer

import com.lansalo.model.{Gender, GenderHelper}
import org.json4s.CustomSerializer
import org.json4s.JsonAST.JString

case object GenderSerializer extends CustomSerializer[Gender](format => ( {
  case JString(gender) => GenderHelper.toGender(gender).get
}, {
  case gender: Gender => JString(gender.sex)
})
)

