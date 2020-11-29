pipeline {
    agent any

    tools { 
	maven 'Maven 3.6.3' 
	jdk 'JDK 8'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
	stage('Deliver') {
	    steps {
		echo 'Delivered to Customer by Bruce Tian - fcy416'
	    }
	}
    }
}
