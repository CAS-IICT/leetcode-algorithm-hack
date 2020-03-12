package algorithm.tools.kotlin
class ReadCase{
    fun read(path: String): String{
        val file = File(path)
        return file.content
    }
}
