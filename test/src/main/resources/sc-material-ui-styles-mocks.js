const styles = require('@material-ui/core/styles-orig');

let withStylesCompCounter = 1

module.exports = {
  ...styles,

  MuiThemeProvider: 'MuiThemeProvider',
  ThemeProvider: 'ThemeProvider',

  withStyles: function (stylesArg) {
    if (typeof stylesArg == 'function') {
      const theme = styles.createTheme({})
      stylesArg(theme)
    }
    
    return comp => {
      return "WithStylesMock-" + comp + "-" + (withStylesCompCounter++);
    };
  }
}
