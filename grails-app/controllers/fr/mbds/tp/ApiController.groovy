package fr.mbds.tp

import grails.converters.JSON

class ApiController {

    UserService userService
    MatchService matchService
    MessageService messageService


    def user() {
        switch (request.getMethod()) {
            case "POST":
                String username = request.JSON.getAt("username").toString()
                String password = request.JSON.getAt("password").toString()
                String authority = request.JSON.getAt("authority").toString()

                User user = User.findOrCreateByUsernameAndPassword(username, password).save(flush: true)
                Role role = Role.findOrCreateByAuthority(authority).save(flush: true)

                UserRole userRole = new UserRole(user: user, role: role)

                if (userRole.save(flush: true)) {
                    response.status = 201
                } else {
                    response.status = 500
                }
                break
            case "GET":
                
                    if (params.id) {
                        if (userService.get(params.id)) {
                            render userService.get(params.id) as JSON
                        } else {
                            render(status: 404, 'Not Found')
                        }

                    } else {
                        if (userService.list(params)) {
                            render userService.list(params) as JSON
                        } else {
                            render(status: 404, 'Not Found')
                        }
                    }
                break
            case "PUT":
                def user = userService.get(request.JSON.id)
                if (user) {
                    user.properties = request.JSON
                    if (user.save(flush: true)) {
                        response.status = 200
                    }

                } else {
                    response.status = 404
                }

                break
            case "DELETE":
                def user = userService.get(request.JSON.id)
                if (user) {
                    user.enabled = false
                    userService.save(user)
                    response.status = 200
                } else {
                    response.status = 404
                }
                break
        }
    }

    def match(){
        switch (request.getMethod()) {
            case "GET":
                if(params.id) {
                    def match = matchService.get(params.id)
                    if (match) {
                        render match as JSON
                        response.status = 200
                    } else {
                        render(status: 404, 'Not Found')
                    }
                }else {
                    if (matchService.list(params)) {
                        render matchService.list(params) as JSON
                    } else {
                        render(status: 404, 'Not Found')
                    }
                }
                break

            case "PUT":
                def match= matchService.get(request.JSON.id)
                if(match) {
                    match.properties = request.JSON
                    if (match.save(flush: true)) {
                        response.status = 200
                    }
                }else{
                    response.status = 404
                    }
                break

            case "DELETE":
                def match = matchService.get(request.JSON.id)
                if (match) {
                    matchService.delete(request.JSON.id)
                    if (request.JSON.id) {
                        response.status = 200
                    }
                } else {
                    response.status = 404
                }
                break
            case "POST":
              def match = new Match(params)
                if(match.save(flush:true)){
                    response.status = 201
                }else{
                    response.status = 400
                }
                if(!match){
                  response.status = 405
                }
                break
        }
    }


    def message(){
        switch (request.getMethod()) {
            case "GET":
                if(params.id){
                    def message = messageService.get(params.id)
                    if(message){
                        render message as JSON
                        response.status = 200
                    }
                    else {
                        render(status: 404, 'Not Found')
                    }
                }else{
                    def message = messageService.list(params)
                    if(message){
                        render message as JSON
                    }
                    else{
                        render(status: 404, 'Not Found')
                    }
                }

                break

            case "PUT":
                def message = messageService.get(request.JSON.id)
                if(message){
                    message.properties=request.JSON
                    if(message.save(flush:true)){
                        render message as JSON
                        response.status = 200
                    }else{
                        response.status = 404
                    }
                }else{
                    response.status = 405
                }
                break

            case "POST":
                def message = new Message(params)
                if(message.save(flush:true)){
                    response.status = 201
                }else{
                    response.status = 400
                }
                if(!message){
                    response.status = 405
                }
                break


            case "DELETE":

                def message = messageService.get(request.JSON.id)
                    if(message){
                        messageService.delete(request.JSON.id)
                        response.status=200
                    }else{
                        response.status = 404
                    }
                break
        }
    }

}

