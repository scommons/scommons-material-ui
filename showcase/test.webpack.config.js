
const nodeExternals = require('webpack-node-externals')
const merge = require("webpack-merge")
const commonConfig = require("./scommons.webpack.config.js")

module.exports = merge(commonConfig, {

  output: {
    libraryTarget: 'commonjs'
  },
  mode: 'development',
  target: 'node', // important in order not to bundle built-in modules like path, fs, etc.
  node: { // tell webpack to not polyfill or mock these:
    __filename: false,
    __dirname: false
  },
  externals: [nodeExternals()] // in order to ignore all modules in node_modules folder
})
