pipeline {
  agent {
          docker {
              image 'markhobson/maven-chrome:jdk-17'
              args '-v /dev/shm:/dev/shm'
          }
      }
  stages {


    stage('Run inside Docker') {
      steps {
            sh "java --version"
            sh "mvn clean test -DSuiteXmlFile='testng.xml' "

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