file:///C:/Users/dell/UoC/FuntionalProgramming/Practicals/Prac5/Prac5.scala
### java.nio.file.InvalidPathException: Illegal char <:> at index 3: jar:file:///C:/Users/dell/AppData/Local/Coursier/cache/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12-sources.jar!/scala/Option.scala

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 1699
uri: file:///C:/Users/dell/UoC/FuntionalProgramming/Practicals/Prac5/Prac5.scala
text:
```scala
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
        bookList.find(_.title == Title) m@@
    }


    displayLibrary()
    AddNewBook("The Catcher in the Rye", " J.D. Salinger", "9780316769488")
    AddNewBook("Pride and Prejudice", "Jane Austen", "9780141040349")
    displayLibrary()
    removeBook("9780141040349")
    displayLibrary()

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
    //Question1_5()
    println("Question 2")
    Question2_5()
    println("Question 3")
    //Question3_5()

}

```



#### Error stacktrace:

```
java.base/sun.nio.fs.WindowsPathParser.normalize(WindowsPathParser.java:182)
	java.base/sun.nio.fs.WindowsPathParser.parse(WindowsPathParser.java:153)
	java.base/sun.nio.fs.WindowsPathParser.parse(WindowsPathParser.java:77)
	java.base/sun.nio.fs.WindowsPath.parse(WindowsPath.java:92)
	java.base/sun.nio.fs.WindowsFileSystem.getPath(WindowsFileSystem.java:232)
	java.base/java.nio.file.Path.of(Path.java:147)
	java.base/java.nio.file.Paths.get(Paths.java:69)
	scala.meta.io.AbsolutePath$.apply(AbsolutePath.scala:58)
	scala.meta.internal.metals.MetalsSymbolSearch.$anonfun$definitionSourceToplevels$2(MetalsSymbolSearch.scala:70)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.metals.MetalsSymbolSearch.definitionSourceToplevels(MetalsSymbolSearch.scala:69)
	dotty.tools.pc.completions.CaseKeywordCompletion$.sortSubclasses(MatchCaseCompletions.scala:326)
	dotty.tools.pc.completions.CaseKeywordCompletion$.matchContribute(MatchCaseCompletions.scala:276)
	dotty.tools.pc.completions.Completions.advancedCompletions(Completions.scala:307)
	dotty.tools.pc.completions.Completions.completions(Completions.scala:109)
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:90)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.nio.file.InvalidPathException: Illegal char <:> at index 3: jar:file:///C:/Users/dell/AppData/Local/Coursier/cache/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12-sources.jar!/scala/Option.scala