package fr.mbds.tp

import grails.gorm.transactions.Transactional

@Transactional
class UserRoleDataService {

    def role(User user,String role){
        if(role=="ROLE_ADMIN"){
            def test = new Role(authority: 'ROLE_ADMIN').save()
            UserRole.create(user,test,true)
            println(test +" dans service")
        }else{
            def adminRole = new Role(authority: 'ROLE_USER').save()
            UserRole.create(user,adminRole)
        }

    }
}
