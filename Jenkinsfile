node {
    checkout scm
    def customImage
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
        customImage = docker.build("${imageName}")
    }
    stage('Push-Images'){
        customImage.push()

    }
    stage('Deploy'){
        customImage.push('latest')
        sh 'kubectl apply -f https://raw.githubusercontent.com/leoinfnet/beerPub/main/k8s_app.yaml '
        sh 'kubectl set image deployment beerpub beerpub=${imageName} --record'
        sh 'kubectl rollout status deployment/beerpub'

    }


}