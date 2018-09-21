package fr.mbds.tp

import grails.gorm.transactions.Transactional

@Transactional
class UserDataService {
    UserService userService

    def getRole(Map params){
        def users=userService.list(params)
        def usersRole = [:]
        users.each{
            user->usersRole.put(user,user.getAuthorities())
        }

        return usersRole
    }


}
