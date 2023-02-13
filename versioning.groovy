#!groovy

def checkout(params){
    print("Checkout ecom-palacio-custom")
    def bitbucketID = "e5d0eb7d-80c0-40f9-a690-8e6f95d244a4"
    dir("source/ecom-palacio-custom"){
        git(
            url: params.repoCustom,
            branch: params.branchCustom, 
            credentialsId: bitbucketID
        )
    }
}
