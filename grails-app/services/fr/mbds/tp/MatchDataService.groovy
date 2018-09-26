package fr.mbds.tp

import grails.gorm.transactions.Transactional

@Transactional
class MatchDataService {

    def MatchService matchService
    def getUser(Map params) {
        def users=matchService.list(params)
        def usersRole = [:]
        users.each{
            user->usersRole.put(user.looser,user.id)
                println(user)
        }

        return usersRole

    }
}
