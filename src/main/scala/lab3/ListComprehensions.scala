package lab3

object ListComprehensions:
  def evens(xs: Seq[Long]): Seq[Long] =
    for {
      x <- xs
      if x % 2 == 0
    } yield x

  def squares(n: Long): Seq[Long] =
    for {
      i <- 1L to n
    } yield i * i

  def sumSquares(n: Long): Long =
    squares(n).sum

  def squares2(m: Long)(n: Long): Seq[Long] =
    for {
      i <- 1L to m
    } yield (n + i) * (n+i)

  def sumSquares2(n: Long): Long =
    ((m: Long, n: Long) => squares2(m)(n))(n, n).sum

  def coords(m: Long)(n: Long): Seq[(Long, Long)] =
    for {
      x <- 0L to m
      y <- 0L to n
    } yield (x, y)