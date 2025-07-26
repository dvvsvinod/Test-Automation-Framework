pipeline {
  agent any

  environment {
    CUSTOM_IMAGE = 'maven-java-docker-chrome'
  }

  stages {
    stage('Build Custom Image') {
      steps {
        script {
          sh "docker build -t ${env.CUSTOM_IMAGE} ."
        }
      }
    }


    stage('Run Tests') {
      steps {
        script{
          sh "docker run --rm ${env.CUSTOM_IMAGE} mvn clean test"
        }

      }
    }


  }

  post {
    always {
      allure([
        includeProperties: false,
        jdk: '',
        results: [[path: 'target/allure-results']]
      ])
    }
  }
}