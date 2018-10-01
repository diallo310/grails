package fr.mbds.tp

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.userdetails.GrailsUser

@Transactional
class UserProfileService {

    def springSecurityService
    UserService userService

    def getCurrentUser() {
        GrailsUser grailsUser = springSecurityService.principal
        return new User(username:grailsUser.username, password:grailsUser.password, enabled:grailsUser.enabled, accountExpired:!grailsUser.accountNonExpired, accountLocked:!grailsUser.accountNonLocked, passwordExpired:false)
    }

}
