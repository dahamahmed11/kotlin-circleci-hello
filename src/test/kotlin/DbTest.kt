import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DbTest {

    @Test
    fun testDatabaseQuery() {
        val runDb = System.getenv("RUN_DB_TESTS") ?: "0"

        if (runDb == "0") {
            println("Skipping DB tests because RUN_DB_TESTS=0")
            assertTrue(true)
            return
        }

        val name = Database.getUserName(1)
        assertEquals("Ahmed", name)
    }
}
