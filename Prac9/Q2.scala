object OddEven {
    def main(args: Array[String]): Unit = {
        println("Enter a number: ")
        val num = scala.io.StdIn.readInt()
        num match {
            case x if x <= 0 => println("number is negative or Zero")
            case x if (x % 2 == 1) => println("number is odd")
            case x if (x % 2 == 0) => println("number is even")
        }
    }
}