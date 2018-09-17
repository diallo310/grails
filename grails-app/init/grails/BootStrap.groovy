package grails

import fr.mbds.tp.Match
import fr.mbds.tp.Message
import fr.mbds.tp.Role
import fr.mbds.tp.User
import fr.mbds.tp.UserRole

class BootStrap {

    def init = { servletContext ->

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def gamingRole = new Role(authority: 'ROLE_USER').save()


        def adminUser = new User(username: 'admin',password: 'password').save()
        def playerUser = new User(username: 'playerUser',password: 'playerUser').save()
        def playerTwoUser = new User(username: 'playerTwoUser',password: 'playerTwoUser').save()

        UserRole.create(adminUser,adminRole,true)
        UserRole.create(playerUser,gamingRole,true)
        UserRole.create(playerTwoUser,gamingRole,true)

        def match = new Match(winner: playerUser, looser: playerTwoUser , winnerScore: 10, looserscore: 1).save()

        new Message(author: playerUser, target: playerTwoUser, content:"hello friend").save()
        new Message(author: playerTwoUser, target: playerUser , content:"hello friend").save()
    }



    def destroy = {
    }
}
