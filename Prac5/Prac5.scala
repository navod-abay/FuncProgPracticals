def Question1_5() =  {


    def getProductList() : Array[String] = {
        var temp = scala.io.StdIn.readLine() 
        if(temp == "Done")
            Array.empty[String]
        else 
            Array(temp) ++ getProductList()
    }

    var productList = getProductList()

    def printProductList(productList: Array[String], index:Int = productList.length - 1): Any  = {
        if(index > 0) {
            println((index + 1) + "\t" + productList(index ))
            printProductList(productList, index - 1)
        }
    }

    printProductList(productList)

    def getTotalProducts(productList: Array[String]): Int = productList.length


}

def Question2_5() = {
    case class Book(title: String, author: String, ISBN: String)
    var bookList = Set(Book("1984", "George Orwell", "1234567890"), 
                        Book("To Kill a Mockingbird", "Harper Lee", "2345678901"),
                        Book("The Great Gatsby", "F. Scott Fitzgerald", "3456789012")
    )

    def AddNewBook(Title: String, Author: String, ISBN: String) = {
        bookList = bookList ++ Set(Book(Title, Author, ISBN))
    }

    def removeBook(ISBN: String) = {
        bookList.find(_.ISBN == ISBN) match {
            case Some(book) => 
                bookList = bookList -- Set(book)
            case None => 
                println("No book was found with ISBN" + ISBN)
        }
    }

    def displayLibrary() = {
        bookList.foreach(book => println("Title:\t" + book.title + " Author:\t" + book.author + " ISBN:\t" + book.ISBN))
        println()
    }

    def searchBook(Title: String) = {
        bookList.find(_.title == Title) match {
            case Some(book) => {
                println("Book Found")
                println("Title:\t" + book.title + " Author:\t" + book.author + " ISBN:\t" + book.ISBN)
            } case None => {
                println("Book not found")
            }
        }
    }
    def listByAuthor(Author:String) = {
        println("\nBooks by " + Author)
        bookList.foreach(book => {
            if(book.author == Author)
                println("Title:\t" + book.title + " Author:\t" + book.author + " ISBN:\t" + book.ISBN)
            })
        println()
    }


    displayLibrary()
    AddNewBook("The Catcher in the Rye", "J.D. Salinger", "9780316769488")
    AddNewBook("Pride and Prejudice", "Jane Austen", "9780141040349")
    AddNewBook("Sense and Sensibility", "Jane Austen", "9780141439662")
    displayLibrary()
    removeBook("9780316769488")
    displayLibrary()
    searchBook("1984")
    searchBook("Tail of Two Cities")
    listByAuthor("Jane Austen")

}

def Question3_5() = {
    def Fibbonacci() = {
        var n = scala.io.StdIn.readInt()
        if(n > 1) {
            println(0)
        }
        FibbonacciHelper(0, 1, n - 1)
    }
    def FibbonacciHelper(prev1: Int, prev2: Int, n:Int): Any = {
        if(n > 0){
            println((prev2 + prev1))
            FibbonacciHelper(prev1 + prev2, prev1, n - 1)
        }
    }

    Fibbonacci()
}

@main def main() = {
    println("Question 1")
    Question1_5()
    println("Question 2")
    Question2_5()
    println("Question 3")
    Question3_5()

}
