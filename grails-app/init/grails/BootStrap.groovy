package grails

import fr.mbds.tp.Match
import fr.mbds.tp.Message
import fr.mbds.tp.Role
import fr.mbds.tp.User
import fr.mbds.tp.UserRole
import grails.core.GrailsApplication
class BootStrap {

    GrailsApplication grailsApplication

    def init = { servletContext ->
        def maxLineNumbers =  grailsApplication.config.getProperty('max.line.numbers')

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def gamingRole = new Role(authority: 'ROLE_USER').save()


        def adminUser = new User(username: 'admin',image: 'admin.png',password: 'password').save()
        def playerUser = new User(username: 'playerUser',image: 'playerUser.png',password: 'playerUser').save()
        def playerTwoUser = new User(username: 'playerTwoUser',image: 'playerTwoUser.png',password: 'playerTwoUser').save()
        def ines = new User(username: 'ines',image: '4.png',password: 'ines').save()
        def hawaou = new User(username: 'hawaou',image: '3.png',password: 'hawaou').save()

        UserRole.create(adminUser,adminRole,true)
        UserRole.create(playerUser,gamingRole,true)
        UserRole.create(playerTwoUser,gamingRole,true)
        UserRole.create(ines,gamingRole,true)
        UserRole.create(hawaou,adminRole,true)

        new Match(winner: playerUser, looser: playerTwoUser , winnerScore: 10, looserScore: 1).save()
        new Match(winner: ines, looser: hawaou , winnerScore: 9, looserScore: 5).save()
        new Match(winner: hawaou, looser: ines , winnerScore: 11, looserScore: 8).save()


        new Message(author: playerUser, target: playerTwoUser, content:"hello friend",isRead: false).save()
        new Message(author: playerTwoUser, target: playerUser , content:"hello friend ",isRead: false).save()
        new Message(author: hawaou, target: ines, content:"hello ines",isRead: false).save()
        new Message(author: ines, target:hawaou , content:"hello friend ",isRead: false).save()
    }



    def destroy = {
    }
}
