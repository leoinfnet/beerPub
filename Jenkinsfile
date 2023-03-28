node {
    checkout scm
    //Pego o ID do ultimo commit
    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile("commit-id").replace("\n", "").replace("\r", "")

    appName = "beerpub"
    registryHost = "127.0.0.1:30400/"
    imageName = "${registryHost}${appName}:${tag}"

    stage('Build-Code'){
        withMaven(maven: 'maven'){
            sh 'mvn clean package'
        }
    }

}