interface Attachment {
    val type: String
}

class AudioAttachment(override val type: String, val audio: Audio) : Attachment {

}

data class Audio(val name: String) {

}

class VideoAttachment(override val type: String, val video: Video) : Attachment {

}

data class Video(val name: String) {

}

class PhotoAttachment(override val type: String, val photo: Photo) : Attachment {

}

data class Photo(val name: String) {

}

class LinkAttachment(override val type: String, val link: Link) : Attachment {

}

data class Link(val name: String) {

}

class NoteAttachment(override val type: String, val note: Note) : Attachment {

}

data class Note(val name: String) {

}