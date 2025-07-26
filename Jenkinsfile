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
        sh "docker run --rm -v /var/jenkins_home/workspace/Selenium-Docker_master:/app -v /var/jenkins_home/allure-results:/allure-results maven-java-docker-chrome bash -c 'mvn clean test && cp -r target/allure-results/* /allure-results'"
        }

      }
    }


  }

  post {
    always {
      allure([
        includeProperties: false,
        jdk: '',
        results: [[path: 'allure-results']]
      ])
    }
  }
}