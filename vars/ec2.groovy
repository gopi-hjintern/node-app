
def call(String EC2_USER, String EC2_HOST, String SSH_KEY_PATH) {
    pipeline {
        agent any

        stages {
        stage('Deploy to EC2') {
            steps {
                script {
                    
                    sh """
                    ssh -o StrictHostKeyChecking=no -i ${SSH_KEY_PATH} ${EC2_USER}@${EC2_HOST} << 'EOF'
                        cd /home/ubuntu/
                        ls
                        git clone https://github.com/gopi-hjintern/node-app.git
                        cd node-app
                        npm install
                        pm2 start node-app

                    """
                }
            }
        }
    }
    }
}
