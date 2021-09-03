const moduleAlias = require('module-alias')

// see:
//  https://www.npmjs.com/package/module-alias
//
moduleAlias.addAliases({
  '@material-ui/core': __dirname + '/sc-material-ui-mocks.js'
})

