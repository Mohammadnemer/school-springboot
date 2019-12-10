node {
    def rtMaven = Artifactory.newMavenBuild()

    stage ('Clone') {
        git url: 'https://github.com/JFrog/project-examples.git'
    }
    stage ('Exec Maven') {
        rtMaven.run pom: 'pom.xml', goals: 'clean install'
    }
}
