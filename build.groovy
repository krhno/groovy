#!groovy

def custom(params){
    sh "cd ${env.WORKSPACE}/source/ecom-palacio-custom/ && rm -f package-lock.json && rm -rf node-modules/"
    sh "${params.buildCustomCommand}"
    sh "npm install codeceptjs"
}