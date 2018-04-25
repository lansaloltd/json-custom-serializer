package com.lansalo.json

import org.json4s.DefaultFormats

trait JsonSupport {

  implicit val formats = DefaultFormats// + SiteNameSerializer + TransliterableSerializer


}
