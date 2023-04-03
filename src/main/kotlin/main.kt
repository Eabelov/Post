fun main() {
    println(WallService.add(Post(1, 1, "Test", 1, 1, 1, Like(1, "Name1"), "Type1", true, null, emptyArray())))
    println(WallService.update(Post(1, 2, "Test", 2, 2, 2, Like(2, "Name2"), "Type2", false, null, emptyArray())))
    WallService.clear()
}

object WallService {

    private var posts = emptyArray<Post>()
    private var id = 1
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
