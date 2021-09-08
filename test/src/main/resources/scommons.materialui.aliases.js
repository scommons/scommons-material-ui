const moduleAlias = require('module-alias')

// see:
//  https://www.npmjs.com/package/module-alias
//
moduleAlias.addAliases({
  '@material-ui/core': __dirname + '/sc-material-ui-mocks.js',
  '@material-ui/core/styles': __dirname + '/sc-material-ui-styles-mocks.js',
  '@material-ui/icons': __dirname + '/sc-material-ui-icons-mocks.js'
})

