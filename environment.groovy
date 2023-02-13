#!groovy

def init(){
    print "Starting appium server"
    sh 'cd ${env.WORKSPACE}/source/ecom-palacio-custom/ && npx appium --relaxed-security' //Triger appium job or send to background
    print "Starting Android Emulator"
    sh 'emulator -no-snapshot-load -avd Pixel4 -no-boot-anim -netspeed full -netdelay none' //Triger emulator job or send to background
}

def destroy(){
    print "Closing the Appium server"
    sh "ps -ef | grep -i 'appium' | awk '{print $2}' | xargs sudo kill -9"
    print "Closing All emulators"
    sh "adb devices | grep 'emulator' | cut -f1 | while read line; do adb -s $line emu kill; done"
}