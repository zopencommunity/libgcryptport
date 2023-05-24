node('linux')
{
   
  stage (Poll) {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        userRemoteConfigs: [[url: "https://github.com/ZOSOpenTools/libgcryptport.git"]]])
        }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/libgcryptport.git'), string(name: 'PORT_DESCRIPTION', value: 'Libgcrypt is a general purpose cryptographic library originally based on code from GnuPG.' )]
  }
}
