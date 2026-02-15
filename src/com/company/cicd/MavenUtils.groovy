package com.company.cicd

class MavenUtils implements Serializable {

    def steps

    MavenUtils(steps) {
        this.steps = steps
    }

    def cleanPackage() {
        steps.sh "mvn clean package -DskipTests"
    }
}
