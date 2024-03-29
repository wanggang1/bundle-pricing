/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bundlepricing

object BundleCatalog {

  private val unitPrice = (items: List[Item]) => {
    require(items.size == 1)
    items.head.price
  }
  
  private val buy1Get1Free = (items: List[Item]) => {
    require(items.size == 2)
    items.head.price
  }
  
  private val buy1Get2ndHalf = (items: List[Item]) => {
    require(items.size == 2)
    items.head.price + items.last.price / 2
  }
  
  private val buy2Get3rdHalf = (items: List[Item]) => {
    require(items.size == 3)
    items(0).price + items(1).price + items(2).price / 2
  }
  
  private val buy3Get4thFree = (items: List[Item]) => {
    require(items.size == 4)
    items.dropRight(1).map(_.price).foldLeft(0.0)(_ + _)
  }
  
  val allBundles = List(
    Bundle(List(Apple), unitPrice),
    Bundle(List(Apple, Apple, Apple, Apple), buy3Get4thFree),
    Bundle(List(Apple, Apple, PeanutButter), buy2Get3rdHalf),
    Bundle(List(Bread), unitPrice),
    Bundle(List(Bread, Bread), buy1Get1Free),
    Bundle(List(Bread, Bread, PeanutButter), buy2Get3rdHalf),
    Bundle(List(Cereal), unitPrice),
    Bundle(List(Cereal, Cereal, Cereal), buy2Get3rdHalf),
    Bundle(List(Cereal, Cereal, Cereal, Milk), buy3Get4thFree),
    Bundle(List(Milk), unitPrice),
    Bundle(List(Milk, Milk), buy1Get1Free),
    Bundle(List(Milk, Milk, SlicedCheese), buy2Get3rdHalf),
    Bundle(List(PeanutButter), unitPrice),
    Bundle(List(PeanutButter, PeanutButter), buy1Get2ndHalf),
    Bundle(List(SlicedCheese), unitPrice),
    Bundle(List(SlicedCheese, SlicedCheese), buy1Get2ndHalf)
  )
  
  val bundlePrices: Map[String, Double] = {
    val pairs = for {
      bundle <- allBundles 
      keyPermutation <- bundle.keys
    } yield (keyPermutation -> bundle.price)
    
    pairs.toMap
  }
  
}
