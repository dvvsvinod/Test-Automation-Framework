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
         sh "docker run -it -v /var/jenkins_home/workspace/Selenium-Docker_master:/app -w /app ${env.CUSTOM_IMAGE} bash"
         sh "mvn clean test -DSuiteXmlFile=testng.xml"
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