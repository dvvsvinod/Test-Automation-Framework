pipeline {
  agent any
  stages {
    stage('Build Docker Image') {
      steps {
        script {
          dockerImage = docker.build("${IMAGE_NAME}")
        }

      }
    }

    stage('Run inside Docker') {
      steps {
        script {
          dockerImage.inside('-v /dev/shm:/dev/shm') {
            sh "mvn clean test -DSuiteXmlFile='testng.xml' "
          }
        }

      }
    }

  }
  environment {
    IMAGE_NAME = 'my-maven-chrome-image'
  }
  post {
    always {
      echo 'Done'
    }

  }
}