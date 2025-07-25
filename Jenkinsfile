pipeline {
  agent {
    docker {
      image 'docker:20.10.7-dind'  // Docker CLI + daemon
      args '-v /var/run/docker.sock:/var/run/docker.sock'
    }
  }

  environment {
    CUSTOM_IMAGE = 'local/maven-java-docker-chrome:latest'
  }

  stages {
    stage('Build Custom Image') {
      steps {
        script {
          // Create Dockerfile dynamically inside workspace
          writeFile file: 'Dockerfile', text: """
          FROM maven:3.8.7-openjdk-17
          USER root
          RUN apt-get update && apt-get install -y docker.io wget gnupg2
          RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add -
          RUN echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list
          RUN apt-get update && apt-get install -y google-chrome-stable
          RUN apt-get clean && rm -rf /var/lib/apt/lists/*
          """
          // Build the image
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