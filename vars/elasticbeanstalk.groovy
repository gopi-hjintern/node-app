def call(String appName, String versionLabel, String s3Bucket, String s3Key, String environmentName, String region = 'us-east-1') {
    pipeline {
        agent any

        stages {
            stage('Prepare Elastic Beanstalk') {
                steps {
                    script {
                        sh """
                        aws s3 cp app.zip s3://$s3Bucket/$s3Key --region $region
                        aws elasticbeanstalk create-application-version --application-name $appName --version-label $versionLabel --source-bundle S3Bucket=$s3Bucket,S3Key=$s3Key --region $region
                        aws elasticbeanstalk update-environment --environment-name $environmentName --version-label $versionLabel --region $region
                        """
                    }
                }
            }
        }
    }
}
