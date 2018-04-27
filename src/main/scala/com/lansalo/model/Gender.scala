package com.lansalo.model

sealed trait Gender {
  val sex: String
}

final case object Male extends Gender {
  val sex = "male"
}

final case object Female extends Gender {
  val sex = "female"
}

final case object Other extends Gender {
  val sex = "other"
}

object GenderHelper {
  private val genders: Set[Gender] = Set(Male, Female, Other)
  def toGender(sex: String): Option[Gender] = genders.find(_.sex == sex)
}
