package fr.mbds.tp


import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

class UserController {

    UserService userService
    UserRoleService userRoleService
    UserProfileService userProfileService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        User utilisateurCourant = userProfileService.getCurrentUser()
        respond userService.list(params), model:[userCount: userService.count(), username:utilisateurCourant.username]
    }

    def show(Long id) {
        respond userService.get(id)
    }


    def create() {
       // respond new User(params)
        def rolesU = Role.getAll()
        render view: 'create', model: [user: new User(params), roles: Role.getAll().sort {-it.id}]

    }

    def save(User user) {
        if (user == null) {
            notFound()
            return
        }
        println params.profileImage.getClass()

        String imagename =  user.username + '.jpg'
        String filename = '/var/www/html/img/' + imagename

        File imageFile = new File(filename)

        try{
            imageFile.createNewFile()
            params.profileImage.transferTo(imageFile)
        }
        catch(IOException ex){
            System.out.println("Could not find file " );
        }

        user.image = imagename

        try {
            userService.save(user)
             // user.save flush:true
              UserRole.create(user, Role.findById(params['roles.authority']), true)

        } catch (ValidationException e) {
            respond user.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userService.get(id)
    }

    def update(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        User user = userService.get(id)
        user.setEnabled(false)
        userService.save(user)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def role(){
        render userRoleService.list(params), model:[userRoleService: userRoleService.count()]
    }

}
