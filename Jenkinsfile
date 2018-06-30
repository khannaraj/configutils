pipeline {
  agent any
  stages {
    stage('CodeQuality') {
      steps {
        script {
          try {
            sh 'cd config-utils; mvn sonar:sonar'
          } catch (Exception e) {
            mail to: 'gnce.acsl@gmail.com', 
            subject: "Job '${JOB_NAME}' (${BUILD_NUMBER}) is waiting for input",
            body: "Please go to ${BUILD_URL} and verify the build"
            error "Code Quality Check failed, please read logs..."
          }
        }
      }
    }
    stage('CodeBuild') {
      steps {
        script {
          try {
            sh 'cd config-utils; mvn install'
          } catch (Exception e) {
            mail to: 'gnce.acsl@gmail.com', 
            subject: "Job '${JOB_NAME}' (${BUILD_NUMBER}) code build failed, awaiting input",
            body: "Please go to ${BUILD_URL} and verify the build"
            error "Code Build failed, please read logs..."
          }
        }

      }
    }
    stage('Install') {
      steps {
        sh 'echo "Installing the code"'
        sh 'cp config-utils/target/utility.war  /usr/share/tomcat8/webapps'
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
