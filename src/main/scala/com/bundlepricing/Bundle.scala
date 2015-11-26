package com.bundlepricing

import PricePolicy.Pricing

object Bundle {
  def bundleKey(items: List[Item]) = items.map(_.name).sorted.mkString
}

case class Bundle(items: List[Item], f: Pricing) {
  import Bundle._
  
  val name = bundleKey(items)
  val price = f(items)
}
