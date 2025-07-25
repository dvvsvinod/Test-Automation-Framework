pipeline {
  agent any

  environment {
    CUSTOM_IMAGE = 'maven-java-docker-chrome:latest'
  }

  stages {
    stage('Build Custom Image') {
      steps {
        script {
          sh "docker build -t ${env.CUSTOM_IMAGE} ."
        }
      }
    }

    stage('Verify Custom Image') {
      steps {
        sh "docker run --rm ${env.CUSTOM_IMAGE} java -version"
        sh "docker run --rm ${env.CUSTOM_IMAGE} mvn -version"
        sh "docker run --rm ${env.CUSTOM_IMAGE} docker --version"
        sh "docker run --rm ${env.CUSTOM_IMAGE} google-chrome --version"
      }
    }

    stage('Run Tests') {
      steps {
        // Run your tests inside a container based on the built image
        sh "docker run --rm -v \$PWD:/app -w /app ${env.CUSTOM_IMAGE} mvn clean test -DSuiteXmlFile=testng.xml"
      }
    }
  }

  post {
    always {
      echo 'Pipeline completed'
    }
  }
}