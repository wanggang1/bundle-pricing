package com.bundlepricing

/**
 * Unit tests for Bundle
 */
class CombinatorialFunctionSpecs extends UnitSpec {

  import CombinatorialFunction._
  
  "CombinatorialFunction.subs" must "generate all possible sub-combinations with given items" in {
    Given("items List(Milk, Bread, Apple, Bread)")
    val items = List(Milk, Bread, Apple, Bread)

    Then("there must be 16 possible combinations")
    val combinations = subs(items)
    combinations.size mustBe 16
    
    And("must contain all possible combinations")
    combinations.contains(List()) mustBe true
    combinations.contains(List(Bread)) mustBe true
    combinations.contains(List(Apple)) mustBe true
    combinations.contains(List(Milk)) mustBe true
    combinations.contains(List(Milk, Bread)) mustBe true
    combinations.contains(List(Milk, Apple)) mustBe true
    combinations.contains(List(Bread, Apple)) mustBe true
    combinations.contains(List(Bread, Bread)) mustBe true
    combinations.contains(List(Apple, Bread)) mustBe true
    combinations.contains(List(Milk, Bread, Apple)) mustBe true
    combinations.contains(List(Milk, Bread, Bread)) mustBe true
    combinations.contains(List(Milk, Apple, Bread)) mustBe true
    combinations.contains(List(Bread, Apple, Bread)) mustBe true
    combinations.contains(List(Milk, Bread, Apple, Bread)) mustBe true
    
    And("must contain 2 List(Bread)")
    combinations.filter(_ == List(Bread)).size mustBe 2
    
    And("must contain 2 List(Milk, Bread)")
    combinations.filter(_ == List(Milk, Bread)).size mustBe 2
  }

  it must "generate an list(Nil) with empty items" in {
    Given("items List()")
    val items = List()

    Then("the combinations must be List(Nil)")
    subs(items) mustBe List(Nil)
  }

}
