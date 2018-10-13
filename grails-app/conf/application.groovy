

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'fr.mbds.tp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'fr.mbds.tp.UserRole'
grails.plugin.springsecurity.authority.className = 'fr.mbds.tp.Role'
grails.plugin.springsecurity.requestMap.className = 'fr.mbds.tp.UserRole'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = 'http://localhost:8081/home/index'
grails.plugin.springsecurity.securityConfigType = 'Annotation'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern:  '/login/**',      access:['IS_AUTHENTICATED_ANONYMOUSLY']],
	[pattern: '/**',             access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/api/**',         access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/match/index',access: ['permitAll']],
	[pattern: '/match/show/**',access: ['permitAll']],
	[pattern: '/match/edit',access: ['ROLE_ADMIN']],
	[pattern: '/match/delete',access: ['ROLE_ADMIN']],
	[pattern: '/user/index',access: ['ROLE_ADMIN']],
	[pattern: '/user/show/**',access: ['permitAll']],
	[pattern: '/match/edit',access: ['ROLE_ADMIN']],
	[pattern: '/match/delete',access: ['ROLE_ADMIN']],
	[pattern: '/message/index',access: ['permitAll']],
	[pattern: '/message/show/**',access: ['permitAll']],
	[pattern: '/message/edit',access: ['ROLE_ADMIN']],
	[pattern: '/message/delete',access: ['ROLE_ADMIN']]
]


grails.plugin.springsecurity.filterChain.chainMap = [
		//Stateless chain
		[
				pattern: '/api/**',
				filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
		],

		//Traditional chain
		[
				pattern: '/**',
				filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
		]
]

//configuration spring security
grails.plugin.springsecurity.rest.token.storage.jwt.useSignedJwt = true
grails.plugin.springsecurity.rest.token.storage.jwt.secret = 'qrD6h8K6S9503Q06Y6Rfk21TErImPYqa'
grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 3600
grails.plugin.springsecurity.rest.token.storage.jwt.useEncryptedJwt = false
grails.plugin.springsecurity.rest.token.storage.jwt.privateKeyPath = null
grails.plugin.springsecurity.rest.token.storage.jwt.publicKeyPath = null
grails.plugin.springsecurity.rest.login.active = true
grails.plugin.springsecurity.rest.login.endpointUrl = '/api/login'
grails.plugin.springsecurity.rest.login.failureStatusCode = 401
grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'

//token validate
grails.plugin.springsecurity.rest.token.validation.useBearerToken = true
grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'
grails.plugin.springsecurity.rest.token.validation.active=true
grails.plugin.springsecurity.rest.token.validation.endpointUrl='/api/validate'


grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/home'


