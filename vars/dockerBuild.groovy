import com.company.cicd.DockerUtils

def call(String image, String tag) {
    def docker = new DockerUtils(this)
    docker.build(image, tag)
    docker.push(image, tag)
}
