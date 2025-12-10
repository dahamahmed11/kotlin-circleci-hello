import kotlin.test.Test
import kotlin.test.assertEquals

class DbTest {

    @Test
    fun testDatabaseQuery() {
        if (System.getenv("RUN_DB_TESTS") != "1") {
            println("Skipping DB tests because RUN_DB_TESTS != 1")
            return
        }

        Database.init()
        val name = Database.getUserName(1)

        assertEquals("yessin", name)
    }
}
