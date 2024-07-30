import scala.io.StdIn

def Question1() = {
  case class Product(
      productId: String,
      name: String,
      quantity: Int,
      price: Double
  )
  def readInventory(): List[Product] = {
    var products = List[Product]()
    var continue = true

    while (continue) {
      println("Enter Product ID (or press Enter to finish):")
      val id = StdIn.readLine()
      if (id.isEmpty) {
        continue = false
      } else {
        println("Enter Product Name:")
        val name = StdIn.readLine()

        println("Enter Product Quantity:")
        val quantity = StdIn.readLine().toInt

        println("Enter Product Price:")
        val price = StdIn.readLine().toDouble

        products = products :+ Product(id, name, quantity, price)
      }
    }

    products
  }
  def getProductNameList(inventory: List[Product]): List[String] = {
    inventory.map(_.name)
  }

  def calculateTotalValue(inventory: List[Product]): Double = {
    inventory.map(product => product.quantity * product.price).sum
  }

  def isCollectionEmpty(inventory: List[Product]): Boolean = {
    inventory.isEmpty
  }

  def mergeProductCollections(
      products1: List[Product],
      products2: List[Product]
  ): List[Product] = {
    val productMap =
      (products1 ++ products2).groupBy(_.productId).map { case (id, products) =>
        val combinedQuantity = products.map(_.quantity).sum
        val highestPrice = products.map(_.price).max
        products.head.copy(quantity = combinedQuantity, price = highestPrice)
      }
    productMap.toList
  }

  def findProductById(products: List[Product], productId: String): Unit = {
    products.find(_.id == productId) match {
      case Some(product) =>
        println(s"Product ID: ${product.id}")
        println(s"Name: ${product.name}")
        println(s"Quantity: ${product.quantity}")
        println(s"Price: $${product.price}")
      case None =>
        println("Product not found.")
    }
  }
}
