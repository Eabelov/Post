import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
        val service = WallService
        service.add(Post(1, 1, "Test", 1, 1, 1, Like(1, "Name1"), "Type1", true))
        val update = Post(1, 2, "Test", 2, 2, 2, Like(2, "Name2"), "Type2", false)
        val result = service.update(update)
        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService
        service.add(Post(1, 1, "Test", 1, 1, 1, Like(1, "Name1"), "Type1", true))
        val update = Post(3, 2, "Test", 2, 2, 2, Like(2, "Name2"), "Type2", false)
        val result = service.update(update)
        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test
    fun addPost() {
        val service = WallService
        val result = service.add(Post(1, 1, "Test", 1, 1, 1, Like(1, "Name1"), "Type1", true))
        assertEquals(1,result.id)
    }
}