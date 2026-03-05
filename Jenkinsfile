pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
          PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
          DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
          DOCKERHUB_REPO = 'annialanen/weather_test'
          DOCKER_IMAGE_TAG = 'v1'
      }


    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/annimala/OTP1_inclass_assignment.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Generate Report') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Debug Files') {
            steps {
                bat 'dir target'
                bat 'dir target\\classes'
                bat 'dir target\\test-classes'
                bat 'dir target\\site\\jacoco'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco(
                    execPattern: "${env.WORKSPACE}\\target\\jacoco.exec",
                    classPattern: "${env.WORKSPACE}\\target\\classes",
                    sourcePattern: "${env.WORKSPACE}\\src\\main\\java"
                )
            }
        }

         stage('Build Docker Image') {
              steps {
                 script {
                     docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                 }
              }
         }

         stage('Push Docker Image to Docker Hub') {
                  steps {
                      script {
                          docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                              docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                          }
                      }
                  }
              }

    }
}