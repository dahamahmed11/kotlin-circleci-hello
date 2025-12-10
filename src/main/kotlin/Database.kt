import java.sql.Connection
import java.sql.DriverManager

object Database {
    fun getConnection(): Connection {
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
    }

    fun init() {
        val conn = getConnection()
        conn.createStatement().use {
            it.execute(
                """
                CREATE TABLE IF NOT EXISTS users (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(255)
                );
                INSERT INTO users (name) VALUES ('ahmed');
                """.trimIndent()
            )
        }
    }
}
