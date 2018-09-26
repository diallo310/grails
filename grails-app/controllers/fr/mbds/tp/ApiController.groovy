package fr.mbds.tp

import grails.converters.JSON
import grails.converters.XML

class ApiController {
    UserService userService

    def user() {
        switch (request.getMethod()) {
            case "POST":
                if (new User(request.JSON).save(flush: true)) {
                    response.status = 200
                } else {
                    response.status = 404
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
                    user.properties=request.JSON
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
                    userService.delete(request.JSON.id)
                    if(request.JSON.id){
                        response.status=200
                    }else{

                    }
                }else{
                    response.status=404
                }
                break

        }

    }

}

