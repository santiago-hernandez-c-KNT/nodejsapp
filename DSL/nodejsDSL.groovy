job('AplicacionNode') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
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
        shell("npm install")
    }
}
