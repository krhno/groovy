#!groovy

def custom(params){
    sh "cd ${env.WORKSPACE}/source/ecom-palacio-custom/" 
    sh "rm -f package-lock.json && rm -rf node-modules"
    sh "npm install appium"
    sh "${params.buildCustomCommand}"
    sh "npm install codeceptjs"
}