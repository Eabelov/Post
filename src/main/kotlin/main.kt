fun main() {
    println(
        WallService.add(
            Post(
                1, 1, 1, 1, 1, "Test1",
                1, 1, true, null, null, Like(1, "like"),
                null, View(1), "PostType1", emptyArray(), Geo("Geo", "11/11/11", null), 1, emptyArray(), true, true,
                true, true, true, true, Donut(true, 1, null, true, "Mode"), 1
            )
        )
    )
    println(
        WallService.update(
            Post(
                2, 2, 2, 2, 2, "Test2",
                2, 2, false, null, null, Like(2, "like"),
                null, View(2), "PostType2", emptyArray(), Geo("Geo", "22/22/22", null), 2, emptyArray(), false, false,
                false, false, false, false, Donut(true, 2, null, false, "Mode"), 2
            )
        )
    )
    println(
        WallService.createComment(
            3,
            Comments(
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
    )

    WallService.clear()

}

object WallService {

    private var posts = emptyArray<Post>()
    private var id = 1
    private var comments = emptyArray<Comments>()


    fun createComment(postId: Int, comment: Comments): Comments {
        for ((index, currentPost) in posts.withIndex()) { //если posts пустой, то не отработает for
            if (currentPost.id == postId) { // будет ошибка всегда когда postId не первый в массиве
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("No post with $postId")
    }

    fun add(post: Post): Post {
        posts += post.copy(id = id++)
        return posts.last()
    }


    fun update(post: Post): Boolean {
        var result = false
        for ((index, currentPost) in posts.withIndex()) {
            if (currentPost.id == post.id) {
                posts[index] = currentPost.copy(text = post.text)
                result = true
            }
        }
        return result

    }

    fun clear() {
        posts = emptyArray()
        id = 1
    }
}
