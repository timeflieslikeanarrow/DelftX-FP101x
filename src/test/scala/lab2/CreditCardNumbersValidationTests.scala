package lab2

import munit._

import CreditCardNumberValidator._

class CreditCardNumbersValidationTests extends FunSuite:
  test("converting credit card number to digits") {
    assert(List(1,2,3,2,1) == toDigits(12321))
    assert(List(1,2,3,4,5) == toDigits(12345))
  }

  test("negative credit card number") {
    intercept[IllegalArgumentException] {
      toDigits(-531)
    }
  }

  test("credit card number is 0") {
    assert(List(0) == toDigits(0))
  }

  test("credit card number is 666") {
    assert(List(6,6,6) == toDigits(666))
  }

  test("reverse credit card numberes") {
    assert(List(1,2,3,2,1) == toDigitsRev(12321))
    assert(List(5,4,3,2,1) == toDigitsRev(12345))
  }

  test("double the second") {
    assert(List() == doubleSecond(List()))
    assert(List(5) == doubleSecond(List(5)))
    assert(List(2, 10) == doubleSecond(List(2, 5)))
    
    assert(List(1, 4, 3, 8) == doubleSecond(List(1,2,3,4)))
    assert(List(1,0,1,0,1) == doubleSecond(List(1,0,1,0,1)))
    
    assert(List(8, 14, 6, 10) == doubleSecond(List(8, 7, 6, 5)))
  }

  test("sum 0 digits") {
    assert(0 == sumDigits(List()))
    assert(0 == sumDigits(List(0, 0, 0)))
  }

  test("sum digits with negative numbers") {
    intercept[IllegalArgumentException] {
      sumDigits(List(-12, 12))
    }
  }

  test("sum large digits") {
    assert(36 == sumDigits(List(6, 66, 666)))
    assert(20 == sumDigits(List(8, 14, 6, 10)))
    assert(30 == sumDigits(List(3, 9, 4, 15, 8)))
  }

  test("negative number is invalid") {
    assert(!isValid(-12786592316))
  }

  test("valid numbers") {
    assert(isValid(4012888888881881))
    assert(isValid(5256283618614517))
    assert(isValid(0000000000000000))
  }

  test("invalid numbers") {
    assert(!isValid(4556945538735694))
  }

//  test("lab answer") {
//    import Lab2Template._
//    assert(94 == numValid(Lab2Template.creditcards))
//  }