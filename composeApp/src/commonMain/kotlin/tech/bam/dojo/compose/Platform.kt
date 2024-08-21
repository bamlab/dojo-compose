package tech.bam.dojo.compose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform