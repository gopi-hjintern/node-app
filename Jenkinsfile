pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Hello from main') {
            when {
                branch 'main'  
            }
            steps {
                echo 'Hello from main branch'
            }
        }
        stage('Hello from test') {
            when {
                branch 'test' 
            }
            steps {
                echo 'Hello from test branch'
            }
        }
    }
}
