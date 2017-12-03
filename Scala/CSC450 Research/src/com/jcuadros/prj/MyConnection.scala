import java.sql.Connection
import java.sql.DriverManager

object MyConnection {

  def main(args: Array[String]): Unit = {

    var connection: Connection = null

    try {
      Class.forName("com.mysql.cj.jdbc.Driver")
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root")

      val statement = connection.createStatement()

      var index = 0
      var maxID = 330266

      for (index <- 1 until 100000) {
        statement.execute("INSERT INTO researchResults(`id`, `language`, `iteration`, `startTime`) VALUES ( " + maxID + ", 'Scala', " + index + ", Now(6))")
        statement.executeQuery("SELECT * FROM sakila.seniorresearch LIMIT " + index)
        statement.executeUpdate("UPDATE researchResults SET `endTime` = Now(6) WHERE id = " + maxID)
        maxID = maxID + 1
      }

    } catch {
      case e => e.printStackTrace()
    }
    connection.close()
  }
}