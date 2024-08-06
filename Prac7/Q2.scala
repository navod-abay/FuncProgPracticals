def calculateSquare(numbers: List[Int]): List[Int] =  {
    numbers.map(num=> num * num)
}

@main def main() = {
    var test  = List(1, 2, 3, 6, 7, 8, 9)
    println(calculateSquare(test))
}