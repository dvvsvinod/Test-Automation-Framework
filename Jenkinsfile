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

    stage('Checkout Code') {
      steps {
        checkout scm
      }
    }

    stage('Run inside Docker') {
      steps {
        script {
          dockerImage.inside('-v /dev/shm:/dev/shm') {
            sh 'mvn clean install'
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