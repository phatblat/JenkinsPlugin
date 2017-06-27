/*
 * Jenkinsfile
 * JenkinsPlugin
 */

node {
    stage('Clone sources') {
        step([$class: 'WsCleanup'])
        if (env.sha1) {
            // PRB needs custom refspec
                Map scm = [
                    $class: 'GitSCM',
                    extensions: [
                    //[$class: 'RelativeTargetDirectory', relativeTargetDir: conf.dir],
                    [$class: 'CleanCheckout'],
                    [$class: 'PruneStaleBranch']
                ],
                userRemoteConfigs: [[
                    credentialsId:  '6715cdce-69af-499f-a621-05488b298ae1',
                    refspec: "+refs/pull/${env.ghprbPullId}/head:refs/remotes/origin/pr/${env.ghprbPullId}",
                    url: 'git@github.com:phatblat/JenkinsPlugin.git'
                ]]
            ]
            checkout scm
        } else {
            // Normal build
          git 'git@github.com:phatblat/JenkinsPlugin.git'
        }
    }
    stage('Maven build') {
        def mvnHome = tool 'Maven'
        env.PATH = "${mvnHome}:${env.PATH}"
        sh 'mvn package'
    }
    stage('Gradle build') {
        def gradleHome = tool 'Gradle'
        env.PATH = "${gradleHome}:${env.PATH}"
        sh 'gradle build'
    }
}