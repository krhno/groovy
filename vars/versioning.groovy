#!groovy

def checkout(params){
    print("Checkout ecom-palacio-custom")
    def bitbucketID = "7e979ce2-e826-4c51-bbc9-0c59965e8e89"
    dir("source/ecom-palacio-custom"){
        git(
            url: params.repoCustom,
            branch: params.branchCustom, 
            credentialsId: bitbucketID
        )
    }
}
