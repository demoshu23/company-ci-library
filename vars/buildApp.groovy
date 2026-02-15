import com.company.cicd.MavenUtils

def call() {
    def maven = new MavenUtils(this)
    maven.cleanPackage()
}
