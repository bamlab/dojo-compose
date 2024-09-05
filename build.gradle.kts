plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinter) apply false
}

// How to invoke this task
// ./gradlew createModule -PmoduleNameInCamelCase=MyNewModule
tasks.register("createModule") {
    // Argument for module name in camelCase
    val templateModuleName =
        project.properties["moduleNameInCamelCase"]?.toString()
            ?: throw IllegalArgumentException("Module name is required")
    val templateLowerCaseModuleName = templateModuleName.lowercase()

    // Create a directory for the new module
    val moduleDir = file(templateModuleName)
    val srcMainDir = file("$templateModuleName/src/commonMain/kotlin/tech/bam/dojo/$templateLowerCaseModuleName")
    val srcAndroidDir = file("$templateModuleName/src/androidMain/kotlin/tech/bam/dojo/$templateLowerCaseModuleName")

    doLast {
        // Step 2: Create module directory and basic structure
        moduleDir.mkdirs()
        srcMainDir.mkdirs()
        srcAndroidDir.mkdirs()

        // Step 3: Update settings.gradle.kts to include the new module
        val settingsFile = file("settings.gradle.kts")
        settingsFile.appendText("\ninclude(\":$templateModuleName\")")

        // Step 4: Create build.gradle.kts in the module directory based on a template
        val templateFile = file("template/template.build.gradle.kts")
        val buildGradleFile = file("$templateModuleName/build.gradle.kts")
        val templateText =
            templateFile
                .readText()
                .replace("templateModuleName", templateModuleName)
                .replace("templateLowerCaseModuleName", templateLowerCaseModuleName)
        buildGradleFile.writeText(templateText)

        // Step 5: Create commonMain source set with a Kotlin class
        val templateClassName = "${templateModuleName}Screen"
        val templateSpaceName = templateModuleName.replace(Regex("([a-z])([A-Z])"), "$1 $2")
        val screenTemplateFile = file("template/template.Screen.kt")
        val screenContent =
            screenTemplateFile
                .readText()
                .replace("templateModuleName", templateModuleName)
                .replace("templateLowerCaseModuleName", templateLowerCaseModuleName)
                .replace("templateClassName", templateClassName)
                .replace("templateSpaceName", templateSpaceName)

        val commonMainFile = file("$srcMainDir/$templateClassName.kt")
        commonMainFile.writeText(screenContent)

        // Step 6: Create androidMain source set with a Kotlin file for previews
        val templatePreviewFile = file("template/template.Previews.kt")
        val previewsContent =
            templatePreviewFile
                .readText()
                .replace("templateModuleName", templateModuleName)
                .replace("templateLowerCaseModuleName", templateLowerCaseModuleName)
                .replace("templateClassName", templateClassName)

        val previewsFile = file("$srcAndroidDir/Previews.kt")
        previewsFile.writeText(previewsContent)

        // Step 7: Add the class to the screen list
        val screenListFile = file("composeApp/src/commonMain/kotlin/tech/bam/dojo/compose/screenList.kt")
        val screenListText = screenListFile.readText()

        // Find the position of the last item in the list and insert the new screen
        val updatedScreenListText =
            screenListText.replace(
                "listOf(",
                "listOf(\n    tech.bam.dojo.$templateLowerCaseModuleName.$templateClassName(),"
            )

        screenListFile.writeText(updatedScreenListText)

        // Step 8: Add the new module to the dependencies in the build.gradle.kts of the composeApp
        val composeAppBuildFile = file("composeApp/build.gradle.kts")
        val composeAppBuildText = composeAppBuildFile.readText()

        val updatedComposeAppBuildText =
            composeAppBuildText.replace(
                "// Import each project",
                "// Import each project\n        implementation(project(\":$templateModuleName\"))"
            )
        composeAppBuildFile.writeText(updatedComposeAppBuildText)
    }
}
