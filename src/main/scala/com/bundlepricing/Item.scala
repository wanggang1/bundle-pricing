package com.bundlepricing

sealed trait Item {
  val name: String
  val price: Double
}

case object Milk extends Item {
  val name: String = "Milk"
  val price: Double = 2.99
}

case object Bread extends Item {
  val name: String = "Bread"
  val price: Double = 1.99
}

case object Cereal extends Item {
  val name: String = "Cereal"
  val price: Double = 2.50
}

case object SlicedCheese extends Item {
  val name: String = "SlicedCheese"
   val price: Double = 4.50
}

case object PeanutButter extends Item {
  val name: String = "PeanutButter"
   val price: Double = 2.50
}

case object Apple extends Item {
  val name: String = "Apple"
  val price: Double = 1.00
}
