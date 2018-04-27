package com.lansalo.json

import com.lansalo.json.serializer.{AgeSerializer, GenderSerializer}
import org.json4s.DefaultFormats

trait JsonSupport {

  implicit val formats = DefaultFormats + GenderSerializer + AgeSerializer

}
