#!groovy

def init(){
    print "Starting appium server"
    sh 'cd ${env.WORKSPACE}/source/ecom-palacio-custom/ && npx appium --relaxed-security > /dev/null 2>&1 &' //Triger appium job or send to background
    print "Starting Android Emulator"
    sh 'emulator -no-snapshot-load -avd Pixel4 -no-window -no-audio -no-boot-anim -netspeed full -netdelay none > /dev/null 2>&1 &' //Triger emulator job or send to background
}

def destroy(){
    print "Closing the Appium server"
    sh "pkill -9 -f appium"
    print "Closing All emulators"
    sh "adb devices | grep emulator | cut -f1 | while read line; do adb -s $line emu kill; done"
}
