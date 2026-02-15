package com.company.cicd

class KubernetesUtils implements Serializable {

    def steps

    KubernetesUtils(steps) {
        this.steps = steps
    }

    def deploy(String image, String tag) {
        def deployment = steps.libraryResource 'k8s/deployment.yaml'
        deployment = deployment.replace("IMAGE_TAG", tag)
        deployment = deployment.replace("IMAGE_NAME", image)

        steps.writeFile file: 'deployment.yaml', text: deployment
        steps.sh "kubectl apply -f deployment.yaml"
    }
}
