#!groovy

def call(body){
    def params = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = params
    body()
    pipeline{
        agent any
        //agent {
        //node {
        //label 'mobile-node'}}
        tools {
            nodejs 'node_14'
        }
        parameters {
            string(
                defaultValue: 'homepage',
                description: 'Tags a correr separados por coma', 
                name: 'TAGS'
            )
        }
        stages{
            stage('prepare-env'){
                steps{
                    script{
                        environment.init()
                    }
                }
            }
            stage('get-sourcecode'){
                steps{
                    sleep time: 20
                    script{
                        versioning.checkout(params)
                    }
                }
            }
            stage('Install-modules'){
                steps{
                    script{
                        build.custom(params)
                    }
                }
            }
//            stage('Run-tests'){
//                steps{
//                    script{
//                        test.executeTests(params)
//                    }
//                }
//           }
        }
        post{
            always{
                script{
                    environment.destroy()
                }
            }
        }
    }   
}
