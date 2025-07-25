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
          sh "docker run --rm -v /var/jenkins_home/workspace/Selenium-Docker_master:/app -w /app maven-java-docker-chrome mvn clean test"
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