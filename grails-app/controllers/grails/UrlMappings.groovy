package grails

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

<<<<<<< HEAD
        "/"(controller: "login",action: "auth")
=======
        "/"(view:"/login/auth")
>>>>>>> b16585fd7ad716c9b3c5c3d887cb55387dc6a0ed
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
