data class Post(
    val id: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Int,
    val likes: Like,
    val postType: String,
    val canDelete: Boolean,
    val original: Post?
) {
}