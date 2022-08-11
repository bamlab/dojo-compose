# dojo-compose
Repository to store compose dojo

You can find board of compose dojos here: https://www.notion.so/m33/Dojo-Jetpack-Compose-472e1620b11c4e3d9eb336a07b06a9ef?p=71cda0280c9e4b319f51296a23ec7c8d&pm=s


## set up a dojo workshop (20 min first time then 5 min)

- DOJO: STEP 1 - add a new android library module to the project
  - right click on the project and select "New" -> "Module"
  - ![dojo-step-5.png](dojo-step-5.png)
  - replace the module build content by the following content:
    - `apply from: "$rootDir/gradle/baseFeature.gradle"`
    - add namespace:
      - ```
        android {
          namespace 'bam.tech.dojo.compose.onPressEffect'
        }
        ```
  - add some dependencies if needed
- Follow the "DOJO: STEP" 2 to 4 in the code
- [optional] DOJO: STEP 5 - create a method to launch quickly the current dojo screen
  - ![dojo-step-4.png](dojo-step-4.png)
- [optional] DOJO: STEP 6 - prepare some code in the module
- DOJO: STEP 7 - Check it builds then push the code on main branch
- [optional] DOJO: STEP 8 - On a other branch put expected result/ help / partial result
- [mandatory] DOJO: STEP 9 - Have fun

## Finalization when dojo workshop is finished (20 min first time then 5 min)

- add a readme containing GIF of the result in the module
- push the result on the main branch
