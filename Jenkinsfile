pipeline {
    agent any

    environment {
        IMAGE_NAME = 'my-maven-chrome-image'
    }

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    // Build the image from local Dockerfile
                    dockerImage = docker.build("${IMAGE_NAME}")
                }
            }
        }

        stage('Checkout Code') {
            steps {
                // Clone the repo into the workspace
                checkout scm
            }
        }


        stage('Run inside Docker') {
            steps {
                script {
                    // Run commands inside the container
                    dockerImage.inside('-v /dev/shm:/dev/shm') {
                        sh 'mvn clean install'
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Done"
        }
    }
}
