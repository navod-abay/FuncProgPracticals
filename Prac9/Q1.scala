object Interest {
  def main(args: Array[String]): Unit = {
    val multiply: Double => Double => Double = (deposit) => (rate) => deposit * rate

    val calculateInterest: Double =>  Double = deposit => deposit match {
      case d if d <= 20000 => multiply(0.02)(deposit)
      case d if d <= 200000 => multiply(0.035)(deposit)
      case d if d <= 2000000 => multiply(0.04)(deposit)
      case d => multiply(0.065)(deposit)
    };

    println("The interest for " + 10000 + "is: " + calculateInterest(10000))   
    println("The interest for " + 100000 + "is: " + calculateInterest(100000))  
    println("The interest for " + 1000000 + "is: " + calculateInterest(1000000)) 
    println("The interest for " + 10000000 + "is: " + calculateInterest(10000000)) 
  }
}
