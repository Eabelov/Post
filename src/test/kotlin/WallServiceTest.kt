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
        service.add(
            Post(
                1, 1, 1, 1, 1, "Test1",
                1, 1, true, null, null, Like(1, "like"),
                null, View(1), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
                true, true, true, true, Donut(true, 1, null, true, "Mode"), 1
            )
        )
        val update = Post(
            1, 2, 2, 2, 2, "Test2",
            2, 2, true, null, null, Like(1, "like"),
            null, View(2), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
            true, true, true, true, Donut(true, 2, null, true, "Mode"), 1
        )
        val result = service.update(update)
        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService
        service.add(
            Post(
                1, 1, 1, 1, 1, "Test1",
                1, 1, true, null, null, Like(1, "like"),
                null, View(1), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
                true, true, true, true, Donut(true, 1, null, true, "Mode"), 1
            )
        )
        val update = Post(
            3, 1, 1, 1, 1, "Test1",
            1, 1, true, null, null, Like(1, "like"),
            null, View(1), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
            true, true, true, true, Donut(true, 1, null, true, "Mode"), 1
        )
        val result = service.update(update)
        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test
    fun addPost() {
        val service = WallService
        val result = service.add(
            Post(
                1, 1, 1, 1, 1, "Test1",
                1, 1, true, null, null, Like(1, "like"),
                null, View(1), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
                true, true, true, true, Donut(true, 1, null, true, "Mode"), 1
            )
        )
        assertEquals(1, result.id)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
        val service = WallService
        service.add(
            Post(
                1, 1, 1, 1, 1, "Test1",
                1, 1, true, null, null, Like(1, "like"),
                null, View(1), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
                true, true, true, true, Donut(true, 1, null, true, "Mode"), 1
            )
        )
        service.add(
            Post(
                2, 1, 1, 1, 1, "Test1",
                1, 1, true, null, null, Like(1, "like"),
                null, View(1), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
                true, true, true, true, Donut(true, 1, null, true, "Mode"), 1
            )
        )
        service.createComment(
            3,
            Comments(
                //несовпадение с первым элементом сразу выбрасывает ошибку в вашем варианте
                1,
                1,
                11,
                "test",
                Donut(true, 1, null, true, "Mode"),
                1,
                1,
                AudioAttachment("Voice", Audio("Voice1")),
                emptyArray(),
                Thread(1, emptyArray(), true, true, true)
            ),
        )
    }

    @Test
    fun shouldNotThrow() {
        val service = WallService
        val post = Post(
            1, 1, 1, 1, 1, "Test1",
            1, 1, true, null, null, Like(1, "like"),
            null, View(1), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
            true, true, true, true, Donut(true, 1, null, true, "Mode"), 1
        )
        service.add(post)

        val comment = Comments(
            1,
            1,
            11,
            "test",
            Donut(true, 1, null, true, "Mode"),
            1,
            1,
            AudioAttachment("Voice", Audio("Voice1")),
            emptyArray(),
            Thread(1, emptyArray(), true, true, true)
        )
        service.createComment(post.id, comment)

        assertEquals(1, service.comments.size)
        assertEquals(comment, service.comments.last())
    }
}
