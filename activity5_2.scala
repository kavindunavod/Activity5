import scala.io.StdIn
object activity5_2 {

  case class book(title:String, author:String, isbn:String)


  def addbook(library:Set[book], newbook: book): Set[book] ={
    library+newbook
  }


  def displaybook(library:Set[book]):Unit={
    println("Library Books:")
    var index = 1
    library.foreach { book =>
      println(s"$index. Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      index += 1
    }

  }


  def remove(library: Set[book], isbnToRemove: String): Set[book] = {
    library.filterNot(_.isbn == isbnToRemove)
  }




  def search(library: Set[book], title1: String): Unit = {
    val result = library.find(_.title == title1)
    result match {
      case Some(book) =>
        println(s"result is: (${book.title},${book.author},${book.isbn})")
      case None =>
        println("Book not found in library.")
    }
  }


  def main(args: Array[String]): Unit = {

    var librarybook = Set(
      book("abirahas gaweshanaya","Martin perera","9780981531687"),
      book("Clean Code", "Robert C. Martin", "9780132350884"),
      book("Design Patterns", "Erich Gamma", "9780201633610")

    )
    val newbook = book("Refactoring", "Martin Fowler", "9780134757599")
    librarybook= addbook(librarybook,newbook)
    println("book details : ")
    displaybook(librarybook)
    val isbnToRemove = "9780132350884"
    val removing=remove(librarybook,isbnToRemove)
    println("after removing the book : ")
    displaybook(removing)

    var boole=true
    while(boole) {
      println("do you want to search a book? (1 for yes and 0 for not) ")
      var answer=StdIn.readLine().toInt
      if(answer==1)
        {
          boole=true
        }
      else if(answer==0)
        {
          boole= false;
        }
      else
      {
          return 0
      }
      if(boole)
        {
          println("enter the name of the book : ")
          var name1 = StdIn.readLine().toString
          search(librarybook, name1)
        }
    }


  }

}
