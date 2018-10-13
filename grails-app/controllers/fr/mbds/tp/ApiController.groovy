package fr.mbds.tp

import grails.converters.JSON

class ApiController {

    UserService userService
    MatchService matchService
    MessageService messageService


    def user() {
        switch (request.getMethod()) {
            case "POST":

                int numberOfUsersAdded = 0
                request.JSON.each { u ->
                    String username = u.username
                    String password = u.password
                    String authority = u.authority
                    String image = u.image

                    User user = User.findOrCreateByUsernameAndImageAndPassword(username, image, password).save(flush: true)
                    Role role = Role.findOrCreateByAuthority(authority).save(flush: true)

                    UserRole userRole = new UserRole(user: user, role: role)
                    if (userRole.save(flush: true)) {
                        numberOfUsersAdded++
                    }

                }

                if (numberOfUsersAdded == 1) {
                    render(status: 201, 'Utilisateur bien ajouté')
                } else if (numberOfUsersAdded > 1) {
                    String message = numberOfUsersAdded.toString() + ' utilisateurs ajoutés'
                    render(status: 201, message)
                } else if(numberOfUsersAdded < 1) {
                    render(status: 400, "Erreur dans l'ajout de l'utilisateur")
                }

                break
            case "GET":

                if (params.id) {
                    if (userService.get(params.id)) {
                        render userService.get(params.id) as JSON
                        render(status: 200, 'Utilisateur avec id ' + params.id +
                                ' est trouvé')
                    } else {
                        render(status: 404, 'Utilisateur avec id ' + params.id +
                                ' non trouvé')
                    }
                } else if (userService.list(params)) {

                    render userService.list(params) as JSON
                    render(status: 200, 'la liste des utilisateurs existe')
                } else{
                    render(status: 404, "la liste des utilisateurs n'existe pas")
                }

                break
            case "PUT":
                def user = userService.get(request.JSON.id)
                if (user) {
                    // on met à jour l'utisateur recuperer par rapport à l'id
                    user.properties = request.JSON
                    if (user.save(flush: true)) {
                        render(status: 200, 'Utilisateur bien modifié')
                    }

                } else {
                    render(status: 404, 'Utilisateur inexistant')
                }

                break
            case "DELETE":
                // on supprime l'utilisateur ayant l'id recuperer
                def user = userService.get(params.id)
                if (user) {
                    user.enabled = false
                    userService.save(user)
                    render(status: 200, 'Utilisateur bien supprimé')
                } else {
                    render(status: 404, 'Utilisateur inexistant')
                }
                break
        }
    }

    def match(){
        switch (request.getMethod()) {
        // recuperation de tous les maths de l'utilisateur ayant l id
            case "GET":
                if(params.id) {
                    def match = matchService.get(params.id)
                    if (match) {
                        render match as JSON
                        response.status = 200
                    } else {
                        render(status: 404, 'Match non trouvé')
                    }
                }else if (matchService.list(params)) {
                    render matchService.list(params) as JSON
                    response.status = 200
                } else {
                    render(status: 404, 'Aucun match trouvé')
                }
                break

            case "PUT":
                def match= matchService.get(request.JSON.id)
                if(match) {
                    match.properties = request.JSON
                    if (match.save(flush: true)) {
                        render(status: 200, 'Match bien modifié')
                    }
                }else{
                    render(status: 404, 'Match non trouvé')
                }
                break

            case "DELETE":
                def match = matchService.get(params.id)
                if (match) {
                    matchService.delete(params.id)
                    render(status: 200, 'Match bien supprimé')
                } else {
                    render(status: 404, 'Match inexistant')
                }
                break
            case "POST":
                if(new Match(request.JSON).save(flush: true)){
                    render(status: 201, 'Match bien ajouté')
                }else{
                    render(status: 400, "Erreur dans l'ajout du match")
                }
                break
        }
    }


    def message(){
        switch (request.getMethod()) {
            case "GET":
                // on recupere l'id de l'utilisateur on retourne ses messages
                if(params.id){
                    def message = messageService.get(params.id)
                    if(message){
                        render message as JSON
                        render(status: 200, 'Message avec id ' + params.id +
                                ' est trouvé')
                    }
                    else {
                        render(status: 404, 'Message avec id ' + params.id +
                                ' non trouvé')
                    }
                    // on retourne tous les messages de la base de donnee
                }else{
                    def message = messageService.list(params)
                    if(message){
                        render message as JSON
                        render(status: 200, 'la liste des messages existe')
                    }
                    else{
                        render(status: 404, "la liste des messages n'existe pas")
                    }
                }

                break

            case "PUT":
                def message = messageService.get(request.JSON.id)
                if(message){
                    message.properties=request.JSON
                    if(message.save(flush:true)){

                        render(status: 200, 'Message bien modifié')
                    }
                }else{
                    render(status: 404, 'Message inexistant')
                }
                break

            case "POST":
                if(new Message(request.JSON).save(flush: true)){
                    render(status: 201, 'Message bien ajouté')
                }else{
                    render(status: 404, 'Erreur dans l\'ajout du message')
                }
                break

            case "DELETE":

                def message = messageService.get(params.id)
                if(message){
                    messageService.delete(params.id)
                    render(status: 200, 'Message bien supprimé')
                }else{
                    render(status: 404, 'Message inexistant')
                }
                break
        }
    }

}

