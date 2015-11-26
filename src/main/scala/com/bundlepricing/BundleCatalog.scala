/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bundlepricing

object BundleCatalog {

  //TODO type parameter???
  private val single = (items: List[Item]) => {
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
  
  private val buy2GetTheOtherHalf = (items: List[Item]) => {
    require(items.size == 3)
    items(0).price + items(1).price + items(2).price / 2
  }
  
  private val buy3GetTheOtherFree = (items: List[Item]) => {
    require(items.size == 4)
    items.dropRight(1).map(_.price).foldLeft(0.0)(_ + _)
  }
  
  val appleSingle = Bundle(List(Apple), single)
  val milkSingle = Bundle(List(Milk), single)
  val breadSingle = Bundle(List(Bread), single)
  val cerealSingle = Bundle(List(Cereal), single)
  val cheeseSingle = Bundle(List(SlicedCheese), single)
  val peanutbutterSingle = Bundle(List(PeanutButter), single)
  
  val appleBuy3Get1Free = Bundle(List(Apple, Apple, Apple, Apple), buy3GetTheOtherFree)
  val appleBuy2GetPBHalf = Bundle(List(Apple, Apple, PeanutButter), buy2GetTheOtherHalf)
  
  val milkBuy1Get1Free = Bundle(List(Milk, Milk), buy1Get1Free)
  val milkBuy2Get1CheeseHalf = Bundle(List(Milk, Milk, SlicedCheese), buy2GetTheOtherHalf)
  
  val breadBuy1Get1Free = Bundle(List(Bread, Bread), buy1Get1Free)
  
  val chessBuy1Get2ndHalf = Bundle(List(SlicedCheese, SlicedCheese), buy1Get2ndHalf)
  
  val pbBuy1Get2ndHalf = Bundle(List(PeanutButter, PeanutButter), buy1Get2ndHalf)
  
  val cerealBuy2Get3rdHalf = Bundle(List(Cereal, Cereal, Cereal), buy2GetTheOtherHalf)
  val cerealBuy3GetMilkFree = Bundle(List(Cereal, Cereal, Cereal, Milk), buy3GetTheOtherFree)
  
  val bundles: Map[String, Double] =
    Map(
      appleSingle.name -> appleSingle.price,
      milkSingle.name -> milkSingle.price,
      breadSingle.name -> breadSingle.price,
      cerealSingle.name -> cerealSingle.price,
      cheeseSingle.name -> cheeseSingle.price,
      peanutbutterSingle.name -> peanutbutterSingle.price,
      appleBuy3Get1Free.name -> appleBuy3Get1Free.price,
      appleBuy2GetPBHalf.name -> appleBuy2GetPBHalf.price,
      milkBuy1Get1Free.name -> milkBuy1Get1Free.price,
      milkBuy2Get1CheeseHalf.name -> milkBuy2Get1CheeseHalf.price,
      breadBuy1Get1Free.name -> breadBuy1Get1Free.price,
      chessBuy1Get2ndHalf.name -> chessBuy1Get2ndHalf.price,
      pbBuy1Get2ndHalf.name -> pbBuy1Get2ndHalf.price,
      cerealBuy2Get3rdHalf.name -> cerealBuy2Get3rdHalf.price,
      cerealBuy3GetMilkFree.name -> cerealBuy3GetMilkFree.price
    )

}
