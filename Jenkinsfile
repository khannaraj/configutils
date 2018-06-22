pipeline {
  agent any
  stages {
    stage('CodeQuality') {
      steps {
        String result = 'failure'
        catchError {
          sh 'mvn sonar:sonar'
          result = 'success'
        }
        if (result == 'failure') {
          step ([$class: 'Mailer', recipients: 'gnce.acsl@gmail.com'])
          error "Code Quality Check failed, please read logs..."
        }
      }
    }
    stage('CodeBuild') {
      steps {
        catchError {
          sh 'cd config-utils; mvn install'
        }
        step ([$class: 'Mailer', recipients: 'gnce.acsl@gmail.com'])
        error "Code Build failed, please read logs..."
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
