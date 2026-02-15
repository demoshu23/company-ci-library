package com.company.cicd

class DockerUtils implements Serializable {

    def steps

    DockerUtils(steps) {
        this.steps = steps
    }

    def build(String image, String tag) {
        steps.sh "docker build -t ${image}:${tag} ."
    }

    def push(String image, String tag) {
        steps.withCredentials([steps.usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            steps.sh """
                echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                docker push ${image}:${tag}
            """
        }
    }
}
