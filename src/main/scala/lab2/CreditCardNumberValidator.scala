package lab2

object CreditCardNumberValidator:
  def toDigits(ccn: Long) : List[Long] = 
    def compute(ccn: Long, acc: List[Long]): List[Long] =
      if ccn == 0 then acc
      else compute(ccn / 10, ccn % 10 +: acc)
    end compute
    
    if ccn < 0 then throw IllegalArgumentException("Credit card number can not be negative")
    else if ccn == 0 then List(0)
    else compute(ccn, List())
  end toDigits

  def toDigitsRev(ccn: Long): List[Long] = toDigits(ccn).reverse

  def doubleSecond(list: List[Long]): List[Long] =
    list.zipWithIndex.map {(n, i) => if i % 2 != 0 then 2 * n else n }
    
  def normalizeDigits(list: List[Long]): List[Long] =
    list.map(d => if d >= 10 then d - 9 else d )
    
  def sumDigits(list: List[Long]): Long =
    if list.exists(_ < 0 ) then throw IllegalArgumentException("digits cannot be negative")
    else list.flatMap(toDigits(_)).sum
    
  def isValid(ccn: Long): Boolean =
    if ccn < 0 then false
    else
      val digitsSum = sumDigits(doubleSecond(toDigitsRev(ccn)))
      digitsSum % 10 == 0

