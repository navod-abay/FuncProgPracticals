def filterEvenNumber(numbers: List[Int]): List[Int] =  {
    numbers.filter(num=> num % 2 == 0)
}

@main def main() = {
    var test  = List(1, 2, 3, 6, 7, 8, 9)
    println(filterEvenNumber(test))
}