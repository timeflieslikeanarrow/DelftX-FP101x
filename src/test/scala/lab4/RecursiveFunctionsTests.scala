package lab4

import munit._
import RecursiveFunctions._

class RecursiveFunctionsTests extends FunSuite:
  test("triangle") {
    assert(10 == triangle(4))
    assert(125250 == triangle(500))
  }

  test("count") {
    assert(0 == count("Haskell", Seq("Java", "PHP", "Javascript")))
    assert(4 == count('e', "The quick brown fox jumped over the lazy dog."))
    assert(14 == count(722, ys))
    val seq = poem.flatMap(s => s.map(c => (c.toInt + 4)))
    assert(16 == count(101, seq))
  }

  test("euclid") {
    assert(1 == euclid(5,7))
    assert(2 == euclid(4,2))
    assert(12 == euclid(13404, 8832))
  }

  test("funkyMap") {
    assert(Seq(11, 102, 13, 104, 15) == funkyMap[Int, Int](_ + 10)(_ + 100)(Seq(1,2,3,4,5)))
    assert(112319712 == funkyMap[Int, Int](_ + 10)(_ + 100)(ys).sum)
    val chars = poem.flatMap(s => s.toList)
    assert(16805 == funkyMap[Char, Int](c => if (c=='e') 1 else 0)(_.toInt)(chars).sum)
  }

  test("fix") {
    val k = fix(f)
    assert(BigInt("1405006117752879898543142606244511569936384000000000") == k(42) )
  }