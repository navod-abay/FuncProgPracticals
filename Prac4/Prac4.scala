def Question1_4() =  {
    def readQuantities(i:Int):Array[Int]={
        if(i<1) Array()
        else {
            Array(scala.io.StdIn.readInt())++readQuantities(i-1)
        }
    }
    
    def readNames(i:Int):Array[String]={
        if(i<1) Array()
        else {
            Array(scala.io.StdIn.readLine())++readNames(i-1)
        }
    }

    var numItems = 4
    println("Enter Items(4)")
    var names = readNames(numItems)
    println("Enter Quatities(4)")
    var quantities=readQuantities(numItems)

    def displayInventory(i:Int = numItems - 1): Any = if (i >= 0) {
        println(names(i) + "\t: " + quantities(i))
        displayInventory(i - 1)
    }

    def searchItem(name:String, index:Int = numItems - 1) : Int = if(index >= 0) {
        if(names(index) == name) index
        else searchItem(name, index - 1)
    } else {
        -1
    }

    def restockItem(name:String, quantity: Int): Any = {
        var index = searchItem(name)
        if(index == -1)
            println("Item not found")
        else
            quantities(index) = quantities(index) + quantity
    }

    def sell(index:Int, quantity:Int) : Any = {
        if(quantities(index) > quantity)
            quantities(index) = quantities(index) - quantity
        else
            println("Not enough inventory")
    }

    def sellItem(name:String, quantity:Int): Any = {
        var index = searchItem(name)
        if(index == -1)
            println("Item not found")
        else
            sell(index, quantity)
    }

    displayInventory()
    println()
    restockItem("Tea", 50)
    displayInventory()
    println()
    sellItem("Milk", 4)
    displayInventory()
    println()
    sellItem("Detergent", 23)


}

def Question2_4() = {
    println("Enter a number: ")
    val num = scala.io.StdIn.readInt()
    num match {
        case x if x <= 0 => println("number is negative or Zero")
        case x if (x % 2 == 1) => println("number is odd")
        case x if (x % 2 == 0) => println("number is even")
    }
}

def Question3_4() = {
    def toUpper(input: String): String = input.toUpperCase
    def toLower(input: String): String = input.toLowerCase

    def formatNames(input: String, func: String => String) = {
        func(input)
    }
    println(formatNames("Benny", toUpper))
    println(formatNames("Saman", toLower))
}

@main def main() = {
    println("Question 1")
    Question1_4()
    println("Question 2")
    Question2_4()
    println("Question 3")
    Question3_4()
}
