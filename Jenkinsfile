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
          sh "docker run --rm maven-java-docker-chrome mvn clean test"
        }

      }
    }
  }

  post {
    always {
      echo 'Pipeline completed'
    }
  }
}