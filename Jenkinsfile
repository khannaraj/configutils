pipeline {
  agent any
  stages {
    stage('CodeQuality') {
      steps {
        script {
          try {
            sh 'cd config-utils; mvn sonar:sonar'
          } catch (err) {
          step ([$class: 'Mailer', recipients: 'gnce.acsl@gmail.com'])
          error "Code Quality Check failed, please read logs..."
          }
        }
      }
    }
    stage('CodeBuild') {
      steps {
        script {
          try {
            sh 'mvn install'
          } catch (err) {
          step ([$class: 'Mailer', recipients: 'gnce.acsl@gmail.com'])
          error "Code Build failed, please read logs..."
          }
        }
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
