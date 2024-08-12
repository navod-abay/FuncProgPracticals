def patternMatch() = {
    val number = scala.io.StdIn.readInt();
    val DivisibleByThree = (x:Int) => x % 3 == 0
    val DivisibleByFive = (x:Int) => x % 5 == 0
    val result = (DivisibleByThree(number), DivisibleByFive(number)) match {
      case (true, true)  => "Multiple of Both Three and Five"
      case (true, false) => "Multiple of Three"
      case (false, true) => "Multiple of Five"
      case _             => "Not a Multiple of Three or Five"
    }
    result
}

@main def main() = {
    println(patternMatch())
    println(patternMatch())
    println(patternMatch())
    println(patternMatch())
}