
module.exports = {
  
  ThemeProvider: 'ThemeProvider',
  
  createTheme: function () {
    let res = {};
    [...arguments].forEach(arg => {
      res = {
        ...res,
        ...arg
      }
    });
  
    return {
      ...res,
      spacing: () => {
        return [...arguments].join(' ');
      }
    };
  },

  withStyles: function () {
    const WithStylesComp = function () {
      return null;
    };

    return () => {
      return WithStylesComp;
    };
  },

  createStyles: function (obj) {
    return obj;
  },

  makeStyles: function (callback) {
    const styles = callback({
      spacing: () => {
        return [...arguments].join(' ');
      }
    })
    const obj = {}
    Object.keys(styles).forEach(key => {
      obj[key] = "classes." + key
    })
    return () => {
      return obj;
    };
  }
}
