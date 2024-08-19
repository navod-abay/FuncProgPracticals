object NameFormatter {
  def main(args: Array[String]): Unit = { 
    def toUpper(str: String): String = str.toUpperCase()

    def toLower(str: String): String = str.toLowerCase()

    def formatNames(name: String)(formatFunc: String => String): String = {
      formatFunc(name)
    }

    
    println(formatNames("Benny")(toUpper))            // BENNY
    println(formatNames("Niroshan")(name => toUpper(name.substring(0, 2)) + toLower(name.substring(2))))  // NIroshan
    println(formatNames("Saman")(toLower))            // saman
    println(formatNames("Kumara")(name => toUpper(name.substring(0, 1))  + toLower(name.substring(1, name.length - 1))+ toUpper(name.substring(name.length - 1))))  // KumarA
  }
}
