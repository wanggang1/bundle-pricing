package com.bundlepricing

import PricePolicy.Pricing

object Bundle {
  
  def bundleKey(items: List[Item]): String = items.map(_.name).mkString
  
  /*
   * string representations of permutation of item names
   */
  def keyPermutations(items: List[Item]): List[String] =
    items.map(_.name).permutations.map(_.mkString).toList
  
}

case class Bundle(items: List[Item], f: Pricing) {
  import Bundle._

  val price = f(items)
  
  val keys = keyPermutations(items)
}
