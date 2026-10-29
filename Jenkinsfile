
pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timestamps()
    }

    environment {
        IMAGE_NAME = 'arysbay-miras-student-api'
        IMAGE_TAG = 'v1.0-37011'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean compileJava'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
            }
        }

        stage('Verify') {
            steps {
                sh 'docker image inspect ${IMAGE_NAME}:${IMAGE_TAG} > /dev/null'
                echo 'Docker image verified successfully'
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Student API CI/CD Pipeline completed!'
        }

        failure {
            echo 'FAILURE: Check the Jenkins Console Output.'
        }
    }
}



