def Question1_3(input: String): String = {
    if (input.isEmpty() || input.length() == 1)
      input
    else
      input.last + Question1_3(input.init)
  }

def Question2_3(strings: List[String]): List[String] = {
    strings.filter(_.length > 5)
  }

def Question3_3(num1: Int, num2: Int): Double = {
    val mean = (num1 + num2).toDouble / 2.0
    "%.2f".format(mean).toDouble;
  }

def Question4_3(numbers: List[Int]): Int = {
    numbers.filter(_ % 2 == 0).sum
  }



@main def main = {
    var result = Question1_3("Hello World")
    println(result)
    println()
    println("_____________________________________________________________________________")
    val inputList = List("navod", "ramisha", "Pehan", "Emil", "Tilakna")
    val filteredList = Question2_3(inputList)
    println("Original List: " + inputList)
    println("Filtered List (length > 5): " + filteredList)
    println()
    println("_____________________________________________________________________________")
    println("num 1" + 30 + " num2: " + 40)
    var result1 = Question3_3(30,40)
    println("result: "+ result1)
    println()
    println("_____________________________________________________________________________")
    val numList= List(1, 3, 2, 5, 3, 4, 8, 12, 14, 5, 7)
    val outputSum = Question4_3(numList)
    println("numList: " + numList)
    println("outputSum: " + outputSum)

}