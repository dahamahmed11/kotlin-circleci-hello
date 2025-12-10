import java.sql.Connection
import java.sql.DriverManager

object Database {
    private const val JDBC_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"

    fun connect(): Connection {
        val conn = DriverManager.getConnection(JDBC_URL)
        conn.createStatement().execute(
            """
            CREATE TABLE IF NOT EXISTS users (
                id INT PRIMARY KEY,
                name VARCHAR(255)
            );
            INSERT INTO users (id, name) VALUES (1, 'Ahmed') 
            ON DUPLICATE KEY UPDATE name='Ahmed';
            """.trimIndent()
        )
        return conn
    }

    fun getUserName(id: Int): String? {
        val conn = connect()
        val stmt = conn.prepareStatement("SELECT name FROM users WHERE id = ?")
        stmt.setInt(1, id)
        val rs = stmt.executeQuery()
        return if (rs.next()) rs.getString("name") else null
    }
}
