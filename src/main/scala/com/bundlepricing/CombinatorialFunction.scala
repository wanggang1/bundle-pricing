package com.bundlepricing

object CombinatorialFunction {
  
  def subs[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => List(Nil)
    case y :: ys => 
      val zss = subs(ys)
      zss ++ zss.map(zs => y :: zs)
  }

}
