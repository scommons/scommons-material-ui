
const nodeExternals = require('webpack-node-externals')

module.exports = {
//  stats: {
//    children: false // disable child plugin/loader logging
//  },

  output: {
    libraryTarget: 'commonjs'
  },
  mode: 'development',
  target: 'node', // important in order not to bundle built-in modules like path, fs, etc.
  node: { // tell webpack to not polyfill or mock these:
    __filename: false,
    __dirname: false
  },
  externals: [nodeExternals()], // in order to ignore all modules in node_modules folder
  
  resolve: {
    modules: [
      './node_modules',
      '.'
    ]
  }
}
