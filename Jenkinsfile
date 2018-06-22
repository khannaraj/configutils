pipeline {
  agent any
  stages {
    stage('CodeQuality') {
      steps {
        catchError {
          sh 'mvn sonar:sonar'
        }
        step ([$class: 'Mailer', recipients: 'gnce.acsl@gmail.com'])
        error "Program failed, please read logs..."
      }
    }
    stage('CodeBuild') {
      steps {
        sh 'cd config-utils; mvn install'
      }
    }
    stage('Install') {
      steps {
        sh 'echo "Installing the code"'
      }
    }
    stage('Test') {
      steps {
        sh 'echo "Successfully Run Test on the server"'
      }
    }
    stage('Upload') {
      steps {
        sh 'echo "Upload executable to Nexus"'
      }
    }
    stage('Notify') {
      steps {
        sh 'echo "Send email to test team for testing"'
      }
    }
  }
}
