pipeline {
    agent any

    environment {
        HOST_WORKSPACE = "/Users/vinod.dvvs/jenkins_home/workspace/Selenium-Docker_master"
        HOST_ALLURE_RESULTS = "/Users/vinod.dvvs/jenkins_home/allure-results"
        DOCKER_IMAGE = "markhobson/maven-chrome:jdk-17"
    }

    stages {
        stage('Checkout') {
            steps {
                // Replace with your SCM configuration
                checkout scm
            }
        }

        stage('Run Maven Tests') {
            steps {
                script {
                    sh """
                    docker run --rm \
                      --platform linux/amd64 \
                      -v ${HOST_WORKSPACE}:/app \
                      -v ${HOST_ALLURE_RESULTS}:/allure-results \
                      -w /app \
                      ${DOCKER_IMAGE} \
                      bash -c "mvn clean test -DsuiteXmlFile=testng.xml && cp -r target/allure-results /allure-results"
                    """
                }
            }
        }
    }

    post {
        always {
            echo 'Tests completed.'
        }
    }
}
