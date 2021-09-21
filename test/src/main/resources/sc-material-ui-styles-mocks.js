const styles = require('@material-ui/core/styles-orig');

let withStylesCompCounter = 1

module.exports = {
  ...styles,

  MuiThemeProvider: 'MuiThemeProvider',
  ThemeProvider: 'ThemeProvider',

  withStyles: function () {
    styles.withStyles(...arguments)
    
    return comp => {
      return "WithStylesMock-" + comp + "-" + (withStylesCompCounter++);
    };
  }
}
