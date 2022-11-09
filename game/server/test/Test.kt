import com.example.TestClass
import com.example.getDeclaredFieldsWithoutCompanion
import org.junit.jupiter.api.Test
import kotlin.reflect.jvm.kotlinProperty

class Test {

    companion object {
        private val cardServiceTestClass = TestClass(
            "CardService",
            "com.example.card",
            fields = listOf(
                "WORDS_IN_CARD",
                "cardsAmount",
            ),
        )

        private val teamServiceTestClass = TestClass(
            "TeamService",
            "com.example.team",
            fields = listOf(
                "teamsStorage",
            ),
        )

        private val gameResultsTestClass = TestClass(
            "GameResultsService",
            "com.example.results",
            fields = listOf(
                "gameHistory",
            ),
        )
    }

    private fun kotlinPropertyBugTest(testClass: TestClass) {
        val clazz = testClass.getJavaClass()
        val declaredFields = clazz.getDeclaredFieldsWithoutCompanion()
        testClass.fields.forEach { field ->
            val currentField = declaredFields.find { it.name == field }
            assert(currentField != null)
            val kotlinProp = currentField!!.kotlinProperty
            assert(kotlinProp != null) { "Kotlin property for the field $field must be not null" }
        }
    }

    @Test
    fun cardServiceFieldsTest() {
        kotlinPropertyBugTest(cardServiceTestClass)
    }

    @Test
    fun teamServiceFieldsTest() {
        kotlinPropertyBugTest(teamServiceTestClass)
    }

    @Test
    fun gameResultsServiceFieldsTest() {
        kotlinPropertyBugTest(gameResultsTestClass)
    }
}