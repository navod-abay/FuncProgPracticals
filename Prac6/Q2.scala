import scala.io.StdIn
import scala.util.{Try, Success, Failure}


def validateInput(name: String, marks: String, totalMarks: String): (Boolean, Option[String]) = {
  if (name.isEmpty) {
    (false, Some("Name cannot be empty."))
  } else {
    Try((marks.toInt, totalMarks.toInt)) match {
      case Success((marksInt, totalMarksInt)) if marksInt >= 0 && totalMarksInt >= 0 =>
        if (marksInt > totalMarksInt) {
          (false, Some("Marks cannot exceed total possible marks."))
        } else {
          (true, None)
        }
      case Success(_) =>
        (false, Some("Marks and total marks must be positive integers."))
      case Failure(_) =>
        (false, Some("Invalid input. Please enter valid integers for marks and total marks."))
    }
  }
}


def calculatePercentageAndGrade(marks: Int, totalMarks: Int): (Double, Char) = {
  val percentage = (marks.toDouble / totalMarks) * 100
  val grade = percentage match {
    case p if p >= 90 => 'A'
    case p if p >= 75 => 'B'
    case p if p >= 50 => 'C'
    case _ => 'D'
  }
  (percentage, grade)
}


def getStudentInfo(): (String, Int, Int, Double, Char) = {
  println("Enter student name:")
  val name = StdIn.readLine()

  println("Enter marks obtained:")
  val marks = StdIn.readLine()

  println("Enter total possible marks:")
  val totalMarks = StdIn.readLine()

  validateInput(name, marks, totalMarks) match {
    case (true, None) =>
      val marksInt = marks.toInt
      val totalMarksInt = totalMarks.toInt
      val (percentage, grade) = calculatePercentageAndGrade(marksInt, totalMarksInt)
      (name, marksInt, totalMarksInt, percentage, grade)
    case (false, Some(errorMessage)) =>
      println(errorMessage)
      getStudentInfo() 
  }
}


def getStudentRecords(): Array[(String, Int, Int, Double, Char)] = {
  var records = Array[(String, Int, Int, Double, Char)]()
  var continue = true

  while (continue) {
    val record = getStudentInfo()
    records :+= record 

    println("Do you want to enter another student record? (yes/no):")
    val response = StdIn.readLine().trim.toLowerCase

    continue = response == "yes"
  }

  records
}


def printStudentRecord(studentRecord: (String, Int, Int, Double, Char)): Unit = {
  val (name, marks, totalMarks, percentage, grade) = studentRecord
  println(s"Name: $name")
  println(s"Marks: $marks/$totalMarks")
  println(f"Percentage: $percentage%.2f%%")
  println(s"Grade: $grade")
}


@main def main() = {
  val studentRecords = getStudentRecords()
  studentRecords.foreach(printStudentRecord)
}
