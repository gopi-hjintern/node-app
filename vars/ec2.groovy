
def call(String ec2User, String ec2Host, String sshKeyPath, String appDir) {
    pipeline {
        agent any

        stages {
            stage('Deploy to EC2') {
                steps {
                    script {
                        sh """
                        scp -i $sshKeyPath app.zip $ec2User@$ec2Host:$appDir
                        ssh -i $sshKeyPath $ec2User@$ec2Host << EOF
                        cd $appDir
                        unzip -o app.zip
                        npm install
                        pm2 restart app
                        EOF
                        """
                    }
                }
            }
        }
    }
}
