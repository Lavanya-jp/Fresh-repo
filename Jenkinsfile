pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Define the Docker image to use in the pipeline
                    def dockerImage = 'java-web-app:latest'

                    // Build the Docker image
                    docker.build(dockerImage, '-f Dockerfile .')

                    // Run the Docker container
                    docker.image(dockerImage).withRun('-p 8080:8082') {
                        // Check if the application is accessible
                        sh "curl http://localhost:8080"
                    }
                }
            }
        }
    }
}