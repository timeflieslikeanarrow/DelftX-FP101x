package lab4

object RecursiveFunctions:
  def triangle(n: Int): Int =
    if n == 0 then 0 else n + triangle(n-1)
    
  def count[T](a: T, seq: Seq[T]): Int =
    if seq.isEmpty 
    then 0 
    else (if a == seq.head then 1 else 0) + count(a, seq.tail)

  val xs = Seq(1,2,35,2,3,4,8,2,9,0,5,2,8,4,9,1,9,7,3,9,2,0,5,2,7,6,92,8,3,6,1,9,2,4,8,7,1,2,8,0,4,5,2,3,6,2,3,9,8,4,7,1,4,0,1,8,4,1,2,4,56,7,2,98,3,5,28,4,0,12,4,6,8,1,9,4,8,62,3,71,0,3,8,10,2,4,7,12,9,0,3,47,1,0,23,4,8,1,20,5,7,29,3,5,68,23,5,6,3,4,98,1,0,2,3,8,1)
  val ys = xs.map (x => math.pow((x + 1) * 3, 3).intValue() - 7)

  val poem = Seq("Three Types for the Lisp-kings under the parentheses,"
      , "Seven for the Web-lords in their halls of XML,"
      , "Nine for C Developers doomed to segfault,"
      , "One for the Dark Lord on his dark throne"
      , "In the Land of Haskell where the Monads lie."
      , "One Type to rule them all, One Type to find them,"
      , "One Type to bring them all and in the Lambda >>= them"
      , "In the Land of Haskell where the Monads lie.")
  
  def euclid(n: Int, m: Int): Int = 
    if n == m then n
    else if n > m then euclid(n - m, m)
    else euclid(n, m - n)
  
  def funkyMap[T,U](f: T=>U)(g: T=> U)(seq: Seq[T]): Seq[U] =
    seq match {
      case Nil => Nil
      case head +: tail => f(head) +: funkyMap(g)(f)(tail)
    }

  //def h[T, U](g: (T => U) => T)(f: T => U): U = f(g(f))
  def h[T](g: (T => T) => T)(f: T => T): T = f(g(f))
  
  def fix[T](f: T => T): T = h[T](fix)(f)
  
  def f(g: BigInt => BigInt)(n: BigInt): BigInt = 
    if n == BigInt(0) then BigInt(1) else n * g(n - BigInt(1))

  
  
  