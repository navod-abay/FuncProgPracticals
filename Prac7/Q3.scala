def isPrime(n: Int): Boolean = {
  if (n <= 1) false
  else if (n == 2) true
  else !(2 to math.sqrt(n).toInt).exists(n % _ == 0)
}

def filterPrime(numbers: List[Int]): List[Int] = {
  numbers.filter(num => isPrime(num))
}

@main def main(): Unit = {
  val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
  val output = filterPrime(input)
  println(output) 
}
