package com.bundlepricing

object Main {

  import Bundle._
    
  def main (args: Array[String]): Unit = {

    println("-----------------Bundled Price Catalog------------------")
    BundleCatalog.bundlePrices.keys foreach {
      key => println(s"$key -> ${BundleCatalog.bundlePrices.getOrElse(key, 0)}")
    }

    println("--Purchase: Bread, Bread, PeanutButter, Milk, Cereal, Cereal, Cereal, Milk---")
    val cost = checkout(List(Bread, Bread, PeanutButter, Milk, Cereal, Cereal, Cereal, Milk))
    println(s"Optimized Cost $$$cost")
    
  }
  
  def checkout(items: List[Item]): Double = {
    val purchasePermutations = keyPermutations(items)
    
    val combinations = CombinatorialFunction.subs(items).filter {
      itemCombination: List[Item] => BundleCatalog.bundlePrices.contains( bundleKey(itemCombination) )
    }
    println("priced combinations : " + combinations)

    val purchases = CombinatorialFunction.subs(combinations).filter {
      purchase: List[List[Item]] => purchasePermutations.contains( bundleKey(purchase.flatten.toList) )
    }
    
    println("possible purchases:")
    val costs = purchases.map { purchase: List[List[Item]] =>
      val cost = purchase.map(combinedItem => BundleCatalog.bundlePrices.getOrElse(bundleKey(combinedItem), 0.0)).foldLeft(0.0)(_ + _)
      val costRounded = BigDecimal(cost).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
      println(s"$purchase -> $$$costRounded")
      costRounded
    }
    
    costs.min
  }

}
