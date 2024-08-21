package tech.bam.dojo.compose

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Dojo compose on: ${platform.name}!"
    }
}
