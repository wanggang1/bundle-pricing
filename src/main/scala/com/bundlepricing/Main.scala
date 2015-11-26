package com.bundlepricing

object Main {

  def main (args: Array[String]) = {
    
    BundleCatalog.bundles.keys foreach {
      key => println(s"$key -> ${BundleCatalog.bundles.getOrElse(key, 0)}")
    }

  }
  
  def checkout(items: List[Item]): Double = 0.0

}
