#!groovy

def executeTests(params){
    // To run the test suite you must have a dw.json credentials file
    withCredentials([file(credentialsId: "testing-sfra-dw",variable:"testingDW")]){
        writeFile file: "${env.WORKSPACE}/source/ecom-palacio-custom/dw.json",text: readFile(testingDW)
    }
    String tagsToRun = env.TAGS
    String [] optionsDefined = tagsToRun.split(',')
    for(tag in optionsDefined){
       sh "cd ${env.WORKSPACE}/source/ecom-palacio-custom/ && ${params.testCommand} test:acceptance:emulator:phone:${tag} | tee -a results.out"
    }
}