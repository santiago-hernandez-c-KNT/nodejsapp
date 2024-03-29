job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/santiago-hernandez-c-KNT/nodejsapp.git', 'main') { node ->
            node / gitConfigName('santiago-hernandez-c-KNT')
            node / gitConfigEmail('santiago.hernandez.c@konecta-group.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('santiagohernandezc5/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
