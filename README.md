# Dojo Jetpack Compose
Repository to store compose dojo workshops

You can find board of compose dojos here: https://www.notion.so/m33/Dojo-Jetpack-Compose-472e1620b11c4e3d9eb336a07b06a9ef?p=71cda0280c9e4b319f51296a23ec7c8d&pm=s

## set up a dojo workshop (20 min first time then 5 min)

1. Create your module (add some dependencies if needed). Use the following
   command to create a new module:

```shell
./gradlew createModule -PmoduleNameInCamelCase=MyNewModule
```

2. [optional] prepare some code in the module
3. Check it builds then push the code on main branch
4. [optional] On a other branch put expected result/ help / partial result
5. Let's train !

## When dojo workshop is finished

- add a readme containing GIF of the result in the module
- push the result on the main branch
- if valuable
    - show to design team / interested people in BAM
    - write an article if not already written
    - Share on Twitter/linkedin
    - export it to School dojo
## Run

### Android

Use android studio to run the project on emulator or android device

### iOS

Open the project in Xcode and run the project on a simulator or iOS device.
Set up the team in the Signing & Capabilities tab in Xcode if needed.

### Web

Run the following command in the terminal:

```shell
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### Desktop

Run the following command in the terminal:

```shell
./gradlew :composeApp:run
```
