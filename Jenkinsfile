pipeline {
  agent any
  stages {
    stage('CodeQuality') {
      steps {
        try {
          sh 'mvn sonar:sonar'
        } catch (err) {
          echo "FOund an error "
          echo err
        }
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
