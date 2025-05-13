pipeline {
    agent any

    environment {
        SAUCE_USERNAME = 'oauth-suryamitracse-abd27'
        SAUCE_ACCESS_KEY = '1fefc8fc-3999-419f-9c3a-c006df5daf7f'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from your GitHub repository
                git 'https://github.com/isuryamitra/selenium-testng.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Build the project using Maven (use bat on Windows)
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run the tests with Maven and TestNG (use bat on Windows)
                    bat 'mvn test'
                }
            }
        }

        stage('Publish TestNG Report') {
            steps {
                // Publish the TestNG report as an artifact
                publishHTML (target: [
                    reportName: 'TestNG Report',
                    reportDir: 'target/', // Ensure this matches your test report directory
                    reportFiles: 'index.html',
                    keepAll: true
                ])
            }
        }
    }

    post {
        always {
            // Clean up workspace after the build
            cleanWs()
        }
        success {
            // Notify or log on successful run
            echo 'Tests ran successfully!'
        }
        failure {
            // Notify or log on failure
            echo 'Tests failed. Please check the reports.'
        }
    }
}
