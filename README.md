# 2016-knight-fury
FRC Team 2879 robot code for the 2016 Stronghold competition, code-named "Knight Fury"

To set up this module in your development environment, follow these steps:

1. Clone the repository  
2. Run `gradlew eclipse` for eclipse, or `gradlew idea` for IntelliJ (linux/mac users should use `./gradlew` instead of `gradlew`.)  
3. Edit the `build.gradle` file to reflect your desired configuration (e.g. changing the Team Number)  

To build this module, simply run `gradlew build`.
To deploy this module to your Robot, simply run `gradlew deploy`.
If you haven't already, you can deploy [Toast](https://github.com/Open-RIO/ToastAPI) to your Robot by running `gradlew toastDeploy`.