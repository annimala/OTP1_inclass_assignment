pipeline { agent any

tools {
    maven 'Maven3'
}

environment {
    PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
    DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
    DOCKERHUB_REPO = 'amirdirin/demo1_2026'
    DOCKER_IMAGE_TAG = 'latest'
}

stages {

    stage('Checkout') {
        steps {
            git 'https://github.com/annimala/OTP1_inclass_assignment.git'
        }
    }

    stage('Run Tests') {
        steps {
            bat 'mvn clean test'
        }
    }

    stage('Code Coverage') {
        steps {
            bat 'mvn jacoco:report'
        }
    }

    stage('Publish Test Results') {
        steps {
            junit '**/target/surefire-reports/*.xml'
        }
    }

    stage('Publish Coverage Report') {
        steps {
            jacoco()
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


3. **Save and Run**
   - Save the job and click "Build Now" to run the pipeline.

### Sequence Diagram

```mermaid
sequenceDiagram
    participant User
    participant Jenkins
    participant GitHub

    User->>Jenkins: Create Pipeline Job
    Jenkins->>GitHub: Pull Code and Jenkinsfile
    Jenkins->>Jenkins: Run Pipeline Stages
    Jenkins->>Jenkins: Build, Test, Code Coverage, Publish Results
    Jenkins->>User: Display Results


```
