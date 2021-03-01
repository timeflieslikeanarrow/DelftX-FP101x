package lab3

import munit._

import ListComprehensions._

class ListComprehensionsTests extends FunSuite:
  test("sum of even numbers") {
      assert(Seq(2,6,32) == evens(Seq(2,5,6,13,32)))
      assert(43772529500L == evens((827305L to 927104L).toSeq).sum)
    
      assert(0L == evens(Seq()).sum)
  }

  test("sum of squares") {
    assert(42925 == sumSquares(50))
  }

  test("sum of squares with range") {
    assert(295425 == sumSquares2(50))
    assert(385 == squares2(10)(0).sum)
    assert(0 == squares2(0)(10).sum)
  }

  test("coords") {
    assert(Seq((0,0), (0, 1), (1,0), (1, 1)) == coords(1)(1))
    assert(Seq((0,0), (0, 1),(0, 2), (1,0), (1, 1), (1, 2)) == coords(1)(2))
    assert(-60L == coords(5)(7).foldRight(0L) { case ((x: Long, y: Long), result: Long) => x * y - result})
  }