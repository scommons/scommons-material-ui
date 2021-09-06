
module.exports = {
  
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
