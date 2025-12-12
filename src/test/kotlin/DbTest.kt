import kotlin.test.Test
import kotlin.test.assertEquals

class DbTest {

    @Test
    fun testDatabaseQuery() {

        val runDbTests = System.getenv("RUN_DB_TESTS") ?: "0"

        if (runDbTests != "1") {
            println("Skipping DB tests because RUN_DB_TESTS != 1 (actual: $runDbTests)")
            return;:
        }

        Database.init()
        val name = Database.getUserName(1)

        assertEquals("ahmed", name)
    }
}
