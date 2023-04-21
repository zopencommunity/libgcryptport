node('linux')
{
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/gcryptlibport.git'), string(name: 'PORT_DESCRIPTION', value: 'Libgcrypt is a general purpose cryptographic library originally based on code from GnuPG.' )]
  }
}
